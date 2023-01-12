package com.training.spring;

import com.training.spring.di.Hello;
import com.training.spring.di.IHello;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class SpringProjectApplication implements ApplicationRunner {

    // field injections
    @Autowired
    @Qualifier("createHello")
    private IHello iHello;

    private IHello hello2;

    private IHello hello3;

    @Value("${app.lang.hello}")
    private String langStr;

    // @Autowired
    // Constructor Injection
    public SpringProjectApplication(@Qualifier("helloTr") IHello hello2Param) {
        hello2 = hello2Param;
    }

    // Method Injection
    @Autowired
    public void xyz(@Qualifier("helloEng") IHello hello3Param) {
        hello3 = hello3Param;
    }

    public void printHello(){
        System.out.println(iHello.hello("osman"));
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(iHello.hello("ayşe"));
        System.out.println(hello2.hello("mehmet"));
        System.out.println(hello3.hello("ali"));
        System.out.println(iHello.hello("fatma"));
        System.out.println(langStr);

    }
}
