package com.zte.dna.controller;

import com.zte.dna.strategy.SimpleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/7/10 20:08
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private SimpleContext simpleContext;

    @GetMapping("/choose")
    public String choose(@RequestParam String poolId){
        return simpleContext.getResource(poolId);
    }

}