package com.thoughtworks.capability.gtb.bob;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloFromBob {

    @GetMapping
    public HelloEntity helloWorld(){
        return new HelloEntity("Hello from Bob");
    }
}
