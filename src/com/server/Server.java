package com.server;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.TestService;

public class Server {
    public static void main(String[] args) {
        BeanFactory bf = new ClassPathXmlApplicationContext("config/spring-server.xml");
        TestService ts = bf.getBean(TestService.class);
        System.out.println(ts.hashCode());
        System.out.println("server started.");
    }
}
