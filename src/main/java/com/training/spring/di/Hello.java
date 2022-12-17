package com.training.spring.di;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("helloEng")
// @Lazy
@Scope("singleton")
// @Scope("prototype")
// @Primary
@Qualifier("my_hello_english")
public class Hello implements IHello {

    private int count = 0;

    public Hello() {
        System.out.println("Hello yaratıldı");
    }

    @Override
    public String hello(String name){
        count++;
        return "Hello " + name + " count : " + count;
    }

    public String anotherMethod(){
        return "another";
    }
}
