package com.redis;

import redis.clients.jedis.Jedis;

/**
 * @classname:
 * @description:
 * @author: zhuyuchao
 * @date: 2019/1/10 22:26
 * @version: 1.0
 **/
public class JedisTest {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("127.0.0.1");
        System.out.println("---------");
        jedis.set("text","123");
        System.out.println(jedis.get("text"));
    }
}
