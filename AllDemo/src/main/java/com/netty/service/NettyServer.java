package com.netty.service;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * Created by sunchong on 2017/3/13.
 */
//netty4.0
public class NettyServer{

    public static void main(String[] args){
        //boss线程
        EventLoopGroup boss = new NioEventLoopGroup();
        //worker线程
        EventLoopGroup worker = new NioEventLoopGroup();

        try{
            // Server服务启动器
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(boss, worker);
            bootstrap.channel(NioServerSocketChannel.class);
            bootstrap.option(ChannelOption.SO_BACKLOG, 1024); //连接数
            bootstrap.option(ChannelOption.TCP_NODELAY, true); //不延迟，消息立即发送
            bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true); //长连接
            bootstrap.childHandler(new ChannelInitializer<SocketChannel>(){

                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception{
                    ChannelPipeline p = socketChannel.pipeline();

                    //以（"\n"）为结尾分割的解码器，以\n结尾，否则解析不了
                    p.addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));

                    //字符串解码和编码
                    p.addLast("decoder", new StringDecoder());
                    p.addLast("encoder", new StringEncoder());

                    //添加自己逻辑的handler
                    p.addLast("handler", new NettyServerHandler());
                }
            });
            //服务器绑定端口监听
            ChannelFuture f = bootstrap.bind(8000).sync();

            //监听服务器关闭监听
            f.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            //关闭
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }
}
