package com.zte.dna.strategy;

import com.zte.dna.service.Strategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhouyq
 * @version 1.0
 * @date 2020/7/10 20:07
 */
@Service
public class SimpleContext {

    @Autowired
    private final Map<String, Strategy> strategyMap = new ConcurrentHashMap<>();

    public SimpleContext(Map<String, Strategy> strategyMap) {
        strategyMap.forEach(this.strategyMap::put);
    }

    public String getResource(String poolId) {
        return strategyMap.get(poolId).getVpcList(poolId);
    }

}

