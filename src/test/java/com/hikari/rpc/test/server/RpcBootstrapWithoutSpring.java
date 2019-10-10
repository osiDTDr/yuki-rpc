package com.hikari.rpc.test.server;

import com.hikari.rpc.registry.ServiceRegistry;
import com.hikari.rpc.server.RpcServer;
import com.hikari.rpc.test.client.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RpcBootstrapWithoutSpring {
    private static final Logger logger = LoggerFactory.getLogger(RpcBootstrapWithoutSpring.class);

    public static void main(String[] args) {
        String serverAddress = "127.0.0.1:18866";
        ServiceRegistry serviceRegistry = new ServiceRegistry("127.0.0.1:2181");
        RpcServer rpcServer = new RpcServer(serverAddress, serviceRegistry);
        HelloService helloService = new HelloServiceImpl();
        rpcServer.addService("com.hikari.rpc.test.client.HelloService", helloService);
        try {
            rpcServer.start();
        } catch (Exception ex) {
            logger.error("Exception: {}", ex);
        }
    }
}
