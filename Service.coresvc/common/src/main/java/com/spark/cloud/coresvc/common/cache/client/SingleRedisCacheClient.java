/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.common.cache.client<br/>
 * <b>文件名：</b>SingleRedisCacheClient.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年1月27日-上午10:49:43<br/>
 * 
 */
package com.spark.cloud.coresvc.common.cache.client;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.spark.cloud.coresvc.utils.logger.LogUtil;

/**
 * <b>类 名：</b>SingleRedisCacheClient<br/>
 * <b>类描述：</b>redis缓存客户端，提供缓存操作方法（单台Redis服务器时使用）<br/>
 * <b>创建人：</b>mhli2<br/>
 * <b>创建时间：</b>2015-8-26 上午10:42:28<br/>
 * <b>修改人：</b>mhli2<br/>
 * <b>修改时间：</b>2015-8-26 上午10:42:28<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0<br/>
 * 
 */
public class SingleRedisCacheClient implements CacheClient
{

    /**
     * redis访问模板
     */
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 创建一个新的实例 RedisCacheManager.
     * 
     * @param redisTemplate
     */
    public SingleRedisCacheClient(RedisTemplate<String, String> redisTemplate)
    {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 
     * getCache(通过key获取缓存数据)
     * 
     * @param key 写入redis的key值
     * @return String 对应的数据
     * @since 1.0
     * @author mhli2
     */
    @Override
    public String getCache(String key)
    {
        try
        {
            ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
            return valueOperations.get(key) == null ? "" : valueOperations.get(key).toString();
        }
        catch (RedisConnectionFailureException e)
        {
            e.printStackTrace();
            LogUtil.info("连接redis失败");
            return null;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            LogUtil.info("从缓存获取" + key + "数据失败");
            return null;
        }
    }

    /**
     * 
     * multiGetCaches(获取多个key对应的缓存数据)
     * 
     * @param key redis的key值，可以为多个
     * @return List 对应的值，若key值不存在则返回null
     * @since 1.0
     * @author mhli2
     */
    @Override
    public List<String> multiGetCaches(String... key)
    {
        try
        {
            if (null != key && key.length > 0)
            {
                Collection<String> collection = Arrays.asList(key);
                ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
                List<String> list = valueOperations.multiGet(collection);
                if (null != list && list.size() > 0)
                {
                    return list;
                }
                else
                {
                    return null;
                }
            }
            else
            {
                return null;
            }
        }
        catch (RedisConnectionFailureException e)
        {
            e.printStackTrace();
            LogUtil.info("连接redis失败");
            return null;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            LogUtil.info("multiGetCaches从缓存获取据失败");
            return null;
        }
        
    }

    /**
     * 
     * setCache(将数据写入redis)
     * 
     * @param key 写入redis的key值
     * @param value 写入redis的数据
     * @since 1.0
     * @author mhli2
     */
    @Override
    public void setCache(String key, String value)
    {
        try
        {
            ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
            valueOperations.set(key, value);
        }
        catch (RedisConnectionFailureException e)
        {
            e.printStackTrace();
            LogUtil.info("连接redis失败");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            LogUtil.info(key + "写入缓存失败");
        }
        
    }

    /**
     * 
     * setCacheWithExpire(将数据写入redis，并设置过期时间)
     * 
     * @param key 写入redis的key值
     * @param value 写入redis的数据
     * @param timeOut 过期时间，单位秒
     * @since 1.0
     * @author mhli2
     */
    @Override
    public void setCacheWithExpire(String key, String value, long timeOut)
    {
        try
        {
            ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
            valueOperations.set(key, value, timeOut, TimeUnit.SECONDS);
        }
        catch (RedisConnectionFailureException e)
        {
            e.printStackTrace();
            LogUtil.info("连接redis失败");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            LogUtil.info(key + "写入缓存失败");
        }
    }
}
