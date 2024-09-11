package com.dssf;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.util.Map;

public class test1 {
    private Jedis jedis;

    @BeforeEach
    void setup(){
        jedis = jedis_ljc.getJedis();
        jedis.auth("ZwJ193728");
        jedis.select(0);

    }

    @Test
    void teststring() {
        String result=jedis.set("name2","胡歌");
        System.out.println(result);
        String name=jedis.get("name2");
        System.out.println(name);
    }

    @Test
    void thash() {
        jedis.hset("user:1","name","小明");
        jedis.hset("user:1","age","21");

        Map<String, String> stringStringMap = jedis.hgetAll("user:1");
        System.out.println(stringStringMap);
    }

    @AfterEach
    void tear() {
        if(jedis !=null){
            jedis.close();
        }
    }
}
