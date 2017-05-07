package com.netty.service;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.net.InetAddress;

/**
 * Created by rich1 on 5/7/17.
 */
public class NettyServerHandler extends SimpleChannelInboundHandler<String>{
    //每次接受到消息的时候触发
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception{
        // 收到消息直接打印输出
        System.out.println(ctx.channel().remoteAddress() + " Say : " + msg);
        // 返回客户端消息 - 我已经接收到了你的消息
        ctx.writeAndFlush("Received your message !\n");
    }

    /**
     * 覆盖channelActive方法 在channel被启动的时候出发(在建立链接的时候)
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception{
        System.out.println("RemoteAddress:" + ctx.channel().remoteAddress() + " active!");
        ctx.writeAndFlush("Welcome to" + InetAddress.getLocalHost().getHostName()+" service!\n");
        super.channelActive(ctx);
    }
}
