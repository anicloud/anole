package com.ani.anole.repository;

import com.ani.anole.domain.statemachine.StateObject;
import com.ani.utils.core.AniCacheUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by zsl on 17-5-11.
 */
@Component
public class ObjectStateRepoRedis implements ObjectStateRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(ObjectStateRepoRedis.class);

    private String STATE_OBJECT_KEY = "stateObject";

    public ObjectStateRepoRedis() {

    }

    private String generateKey(String stateObjectId) {
        return AniCacheUtils.getRedisKey(STATE_OBJECT_KEY, stateObjectId);
    }

    @Resource(name = "stateRedisTemplate")
    private RedisTemplate<String, StateObject> redisTemplate;

    @Override
    public StateObject getStateObject(String stateObjectId) {
        LOGGER.info("get StateObject from redis, key {}.", stateObjectId);
        return redisTemplate.opsForValue().get(
                generateKey(stateObjectId)
        );
    }

    @Override
    public void putStateObject(String stateObjectId, StateObject stateObject) {
        LOGGER.info("put stateObject into redis, key {}.", stateObject.stateObjectId);
        redisTemplate.opsForValue().set(
                generateKey(stateObjectId),
                stateObject
        );
    }

    @Override
    public void putIfAbsent(String stateObjectId, StateObject stateObject) {
        LOGGER.info("putIfAbsent, key {}.", stateObject.stateObjectId);
        redisTemplate.opsForValue().setIfAbsent(
                generateKey(stateObjectId),
                stateObject
        );
    }

    @Override
    public void delStateObject(String stateObjectId) {
        LOGGER.info("evict StateObject, key {}.", stateObjectId);
        redisTemplate.delete(stateObjectId);
    }
}
