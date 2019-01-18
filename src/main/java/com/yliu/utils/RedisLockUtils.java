package com.yliu.utils;

import redis.clients.jedis.Jedis;

public class RedisLockUtils {
	
	private static final String OK = "OK";
	
	private static final String SET_IF_NOT_EXIST = "NX";
	    
	private static final String SET_WITH_EXPIRE_TIME = "PX";
	    
	private final static String LOCKED = "LOCKED";
	
	private final static String UNLOCKED = "UNLOCKED";
	/**
	 * 加锁
	 * @param lockKey
	 * @param expireTime
	 * @return
	 */
	public static boolean lock(String lockKey,int expireTime){
		Jedis jedis = RedisUtils.getJedis();
        String result = jedis.set(lockKey,LOCKED,SET_IF_NOT_EXIST,SET_WITH_EXPIRE_TIME,expireTime);
        return OK.equals(result);

	}
	
	public static void unlock(String lockKey){
		
	}
}
