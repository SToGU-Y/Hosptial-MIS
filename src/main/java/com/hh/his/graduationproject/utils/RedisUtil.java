package com.hh.his.graduationproject.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component("redisUtil")
public class RedisUtil {

    @Qualifier("jedisPool")
    @Autowired
    private JedisPool jedisPool;

    /**
     * 向Redis中存值，永久有效
     */
    public Long hset(String key,String field, String value) {
        try {
            return jedisPool.getResource().hset(key, field, value);
        } catch (Exception e) {
            System.out.println("错误信息："+e.getMessage());
            return 0L;
        } finally {
            jedisPool.getResource().close();
        }
    }


    /**
     * 根据传入Key,field获取指定Value
     */
    public String hget(String key,String field) {
        try {
            return jedisPool.getResource().hget(key,field);
        } catch (Exception e) {
            System.out.println("错误！！！！");
            return "";
        } finally {
            jedisPool.getResource().close();
        }
    }

    /**
     * 通过key和field判断是否有指定的value存在
     *
     * @param key
     * @param field
     * @return
     */
    public Boolean hexists(String key, String field) {
        return jedisPool.getResource().hexists(key, field);
    }

    /**
     * 删除指定Key-Value
     */
    public Long Hdel(String key,String field) {
        try {
            return jedisPool.getResource().hdel(key,field);
        } catch (Exception e) {
            return 0L;
        } finally {
            jedisPool.getResource().close();
        }
    }

    public void set(String key,String value){
        try {
            jedisPool.getResource().setex(key,60,value);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            jedisPool.getResource().close();
        }
    }

    public void del(String key){
        try {
            jedisPool.getResource().del(key);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            jedisPool.getResource().close();
        }
    }

    public String get(String key){
        try {
            return jedisPool.getResource().get(key);
        }catch (Exception e){

            return null;
        }finally {
            jedisPool.getResource().close();
        }
    }

}
