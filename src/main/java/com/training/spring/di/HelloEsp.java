package com.training.spring.di;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class HelloEsp implements IHello {

    @Override
    public String hello(String name) {
        return "Ola " + name;
    }
}
