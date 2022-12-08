package com.training.spring;

import com.training.spring.di.Hello;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class SpringStart {

    public static void main(String[] args) {
//        Hello hello = new Hello();
//        hello.hello("osman");

        ConfigurableApplicationContext context = SpringApplication.run(SpringProjectApplication.class,
                                                                       args);

//        SpringProjectApplication bean = context.getBean(SpringProjectApplication.class);
//        bean.printHello();
    }
}
