package com.zte.dna.service;

import org.springframework.stereotype.Component;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/7/10 20:05
 */
@Component("B")
public class ServiceB implements Strategy {

    @Override
    public String getVpcList(String id) {
        System.out.println("B,getVpcList ==========="+id);
        return id;
    }
}
