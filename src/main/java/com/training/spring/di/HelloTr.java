package com.training.spring.di;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("my_hello_turkish")
public class HelloTr implements IHello {

    @Override
    public String hello(String name) {
        return "Selam " + name;
    }
}
