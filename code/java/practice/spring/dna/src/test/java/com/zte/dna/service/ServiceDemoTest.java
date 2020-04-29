package com.zte.dna.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/4/29 22:39
 */

@RunWith(SpringRunner.class)
@SpringBootTest
class ServiceDemoTest {
    @Autowired
    ServiceDemo serviceDemo;

    @Test
    public void testDemo() {
        String result = serviceDemo.testDemo();
        Assert.assertEquals(result, "我是返回结果");
    }

}