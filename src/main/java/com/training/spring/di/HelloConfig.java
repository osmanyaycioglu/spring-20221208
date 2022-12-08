package com.training.spring.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class HelloConfig {


    @Bean
    public IHello createHello(Environment environment) {
        String property = environment.getProperty("app.lang.hello");
        switch (property) {
            case "tr":
                return new HelloTr();
            case "esp":
                return new HelloEsp();
            case "eng":
            default:
                return new Hello();
        }
    }

    @Bean
    public IHello createHelloEx(@Value("${app.lang.hello}") String lang) {
        switch (lang) {
            case "tr":
                return new HelloTr();
            case "esp":
                return new HelloEsp();
            case "eng":
            default:
                return new Hello();
        }
    }

//    @Bean
//    public IHello createHelloEx2(@Value("#{beanName.fieldName}") String lang) {
//        switch (lang) {
//            case "tr":
//                return new HelloTr();
//            case "esp":
//                return new HelloEsp();
//            case "eng":
//            default:
//                return new Hello();
//        }
//    }


    @Bean
    public IHello createHello2() {
        return new Hello();
    }

}
