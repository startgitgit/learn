package com.zte.dna.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloSpringBoot {
    public static final Logger logger = LoggerFactory.getLogger(HelloSpringBoot.class);

//    @RequestMapping(path = {"/people"}, method = RequestMethod.GET)
    @GetMapping("/people")
    public String getRequestDemo(@RequestParam(value = "name", required = false) String name) {
        logger.info("name:{}", name);
        return String.format("your name is:%s",name);
    }
}
