package com.client;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        BeanFactory bf = new ClassPathXmlApplicationContext("config/spring-client.xml");
        Client client = bf.getBean(Client.class);
        client.execute();
    }
}
