/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.common.cache.factory<br/>
 * <b>文件名：</b>CacheClientFactory.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年1月27日-上午10:49:43<br/>
 * 
 */
package com.spark.cloud.coresvc.common.cache.factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.spark.cloud.coresvc.common.cache.client.CacheClient;
import com.spark.cloud.coresvc.common.cache.client.SingleRedisCacheClient;

/**
 * <b>类   名：</b>CacheClientFactory<br/>
 * <b>类描述：</b>缓存客户端工厂类<br/>
 * <b>创建人：</b>longzhao<br/>
 * <b>创建时间：</b>2015-9-7 下午1:35:03<br/>
 * <b>修改人：</b>longzhao<br/>
 * <b>修改时间：</b>2015-9-7 下午1:35:03<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
@Component
public class CacheClientFactory implements ApplicationContextAware
{
    // spring应用程序上下文环境
    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext)
    {
        CacheClientFactory.applicationContext = applicationContext;
    }
    
    /**
     * 构造方法私有化
     */
    private CacheClientFactory() 
    {
    }

    /**
     * 
     * createClient(生成一个缓存访问客户端)
     * 
     * @return 缓存访问客户端
     * @since 1.0
     * @author longzhao
     */
    public static CacheClient createClient()
    {
        // 最简单的情况，直接返回单个实例Redis访问客户端工具类
        CacheClient cacheClient = applicationContext.getBean(SingleRedisCacheClient.class);
        
        // TODO 可以根据需要扩展返回不同的缓存访问客户端
//        String isDistributedStr = ConfigurationHolder.getInstance().getProperty("redis.isDistributed");
//        if (StringUtils.isNotBlank(isDistributedStr))
//        {
//            boolean isDistributed = Boolean.valueOf(isDistributedStr);
//            if (isDistributed)
//            {
//                cacheClient = applicationContext.getBean(SharedRedisClient.class);
//            }
//            else
//            {
//                cacheClient = applicationContext.getBean(SingleRedisClient.class);
//            }
//        }
        
        return cacheClient;
    }
}
