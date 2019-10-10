package com.hikari.rpc.test.server;

import com.hikari.rpc.test.client.HelloService;
import com.hikari.rpc.test.client.Person;
import com.hikari.rpc.server.RpcService;

@RpcService(HelloService.class)
public class HelloServiceImpl implements HelloService {

    public HelloServiceImpl(){

    }

    @Override
    public String hello(String name) {
        return "Hello! " + name;
    }

    @Override
    public String hello(Person person) {
        return "Hello! " + person.getFirstName() + " " + person.getLastName();
    }
}
