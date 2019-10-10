package com.hikari.rpc.client;

import com.hikari.rpc.protocol.RpcDecoder;
import com.hikari.rpc.protocol.RpcEncoder;
import com.hikari.rpc.protocol.RpcRequest;
import com.hikari.rpc.protocol.RpcResponse;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;


public class RpcClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline cp = socketChannel.pipeline();
        cp.addLast(new RpcEncoder(RpcRequest.class));
        cp.addLast(new LengthFieldBasedFrameDecoder(65536, 0, 4, 0, 0));
        cp.addLast(new RpcDecoder(RpcResponse.class));
        cp.addLast(new RpcClientHandler());
    }
}
