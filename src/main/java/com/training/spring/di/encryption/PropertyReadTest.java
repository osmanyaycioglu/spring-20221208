package com.training.spring.di.encryption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PropertyReadTest implements CommandLineRunner {

    @Autowired
    private NoteObject noteObject;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("url : "
                           + noteObject.getDesc1()
                           + " user : "
                           + noteObject.getDesc2()
                           + " pass : "
                           + noteObject.getDesc3());
        System.out.println("Note : " + noteObject);
    }
}
