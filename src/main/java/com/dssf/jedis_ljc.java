package com.dssf;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


public class jedis_ljc {
       private static JedisPool jedisPool;
       static {
               JedisPoolConfig config = new JedisPoolConfig();
               config.setMaxIdle(8);
               config.setMaxTotal(8);
               config.setMinIdle(0);
               config.setMaxWaitMillis(100);
               jedisPool = new JedisPool(config, "192.168.88.131", 6379,1000,"ZwJ193728");

       }
       public static Jedis getJedis() {
               return jedisPool.getResource();
       }
}
