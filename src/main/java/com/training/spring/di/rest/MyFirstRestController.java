package com.training.spring.di.rest;

import com.training.spring.di.IHello;
import com.training.spring.di.rest.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/first")
public class MyFirstRestController {

    @Autowired
    @Qualifier("createHello")
    private IHello helloBean;

    // /first/hello1 -> GET Request
    // @RequestMapping(method = RequestMethod.GET,path = "/hello1")
    @GetMapping("/hello1")
    public String hello() {
        return "hello world";
    }

    @PostMapping("/hello1")
    public String helloPost() {
        return "hello world POST";
    }

    @PutMapping("/hello1")
    public String helloPut() {
        return "hello world PUT";
    }

    // /first/hello2/XXXXX/test/double/YYYYY
    @GetMapping("/hello2/{abc}/test/double/{xyz}")
    public String hello2(@PathVariable("abc") String name,
                         @PathVariable("xyz") String surname) {
        return helloBean.hello(name + " " + surname);

    }

    // /first/hello4?abc=osman&xyz=yaycıoğlu
    @GetMapping("/hello4")
    public String hello4(@RequestParam("abc") String name,
                         @RequestParam("xyz") String surname) {
        return "hello 4 :  " + helloBean.hello(name + " " + surname);

    }


    @PostMapping("/hello3")
    public String hello3(@RequestBody Person personParam){
        return "Person deser : " + personParam;
    }

}
