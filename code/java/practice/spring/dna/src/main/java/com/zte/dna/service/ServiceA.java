package com.zte.dna.service;

import org.springframework.stereotype.Component;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/7/10 20:05
 */
@Component("A")
public class ServiceA implements Strategy {

    @Override
    public String getVpcList(String id) {
        System.out.println("A,getVpcList ==========="+id);
        return id;
    }
}
