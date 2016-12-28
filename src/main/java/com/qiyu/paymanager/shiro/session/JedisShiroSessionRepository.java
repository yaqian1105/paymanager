package com.qiyu.paymanager.shiro.session;

import com.qiyu.paymanager.shiro.JedisManager;
import com.qiyu.paymanager.shiro.RedisUtil;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.Serializable;
import java.util.Collection;

/**
 * redis save shiro session class
 *
 * @author michael
 */
public class JedisShiroSessionRepository implements ShiroSessionRepository {

    private static final String REDIS_SHIRO_SESSION = "shiro-session:";
    private static final int SESSION_VAL_TIME_SPAN = 18000;
    private static final int DB_INDEX = 1;
    private String redisShiroSessionPre;

    private JedisManager jedisManager;
    private RedisUtil redisUtil;

    @Autowired
    private RedisTemplate<Serializable, Object> redisTemplate;

    @Override
    public void saveSession(Session session) {
        if (session == null || session.getId() == null)
            throw new NullPointerException("session is empty");
        try {
            long sessionTimeOut = session.getTimeout() / 1000;
            Long expireTime = sessionTimeOut + SESSION_VAL_TIME_SPAN + (5 * 60);
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(getRedisSessionKey(session.getId()), session);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("save session error");
        }
    }

    @Override
    public void deleteSession(Serializable id) {
        if (id == null) {
            throw new NullPointerException("session id is empty");
        }
        try {
            redisUtil.remove(getRedisSessionKey(id));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("delete session error");
        }
    }

    @Override
    public Session getSession(Serializable id) {
        if (id == null)
            throw new NullPointerException("session id is empty");
        Session session = null;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            Object object = operations.get(getRedisSessionKey(id));
            if (object != null) {
                return (Session)object;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("get session error");
        }
        return session;
    }

    @Override
    public Collection<Session> getAllSessions() {
        //TODO
        System.out.println("get all sessions");
        return null;
    }

    private String buildRedisSessionKey(Serializable sessionId) {
        return REDIS_SHIRO_SESSION + sessionId;
    }

    public JedisManager getJedisManager() {
        return jedisManager;
    }

    public void setJedisManager(JedisManager jedisManager) {
        this.jedisManager = jedisManager;
    }

    /**
     * 获取redis中的session key
     *
     * @param sessionId
     * @return
     */
    private String getRedisSessionKey(Serializable sessionId) {
        return getRedisShiroSessionPre() + sessionId;
    }

    public RedisUtil getRedisUtil() {
        return redisUtil;
    }

    public void setRedisUtil(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    public String getRedisShiroSessionPre() {
        if (redisShiroSessionPre == null || redisShiroSessionPre.trim().length() == 0) {
            return REDIS_SHIRO_SESSION  + ":";
        }
        return REDIS_SHIRO_SESSION + "-" + redisShiroSessionPre + ":";
    }

    public void setRedisShiroSessionPre(String redisShiroSessionPre) {
        this.redisShiroSessionPre = redisShiroSessionPre;
    }
}
