package com.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by sunchong on 2017/3/13.
 */
public class NettyClient{

    public static String host = "127.0.0.1"; //所要链接的服务器
    public static int port = 8000; //服务器的监听端口

    public static void main(String[] args){

        EventLoopGroup group = new NioEventLoopGroup();
        try{
            Bootstrap b = new Bootstrap();
            b.group(group);
            b.channel(NioSocketChannel.class);
            b.handler(new ChannelInitializer<SocketChannel>(){
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception{
                    ChannelPipeline pipeline = socketChannel.pipeline();

                    /**
                     * 这个地方必须和服务器对应上，否则无法正常解码和编码
                     *
                     */
                    pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192,Delimiters.lineDelimiter()));
                    pipeline.addLast("decoder", new StringDecoder());
                    pipeline.addLast("encoder", new StringEncoder());

                    //客户端逻辑
                    pipeline.addLast("handler", new MyClientHandler());
                }
            });

            //连接服务器
            Channel ch = b.connect(host, port).sync().channel();
            //控制台输入
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            do{
                String line = in.readLine();
                if(null == line){
                    continue;
                }
                /**
                 * 向服务端发送在控制台输入的文本，并用\r\n结尾
                 * 只所以用\r\n结尾是因为我们在handler中添加了DelimiterBasedFrameDecoder帧解码
                 * 这个解码器是一个根据\n符号为分割符的解码器。所以每条消息的最后必须加上\n否则无法识别和解码
                 */
                ch.writeAndFlush(line+"\r\n");
            }while (true);

        }catch (Exception e){
            e.printStackTrace();
        }finally{
            group.shutdownGracefully();
        }
    }

}
