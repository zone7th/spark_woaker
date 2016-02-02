/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.common.config<br/>
 * <b>文件名：</b>ConfigurationHolder.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年1月27日-上午10:49:43<br/>
 * 
 */
package com.spark.cloud.coresvc.common.config;

import com.github.diamond.client.PropertiesConfiguration;
import com.github.diamond.client.PropertiesConfigurationFactoryBean;
import com.github.diamond.client.util.PropertiesUtils;
import com.spark.cloud.coresvc.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * <b>类   名：</b>ConfigurationHolder<br/>
 * <b>类描述：</b>配置管理中心（单例），可以从多个配置文件和远程调用中收集配置项，同步以单例类和统一RPC服务提供配置项的获取<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年1月7日 下午4:37:08<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年1月7日  下午4:37:08<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 *
 */
public class ConfigurationHolder
{
    private Logger logger = LoggerFactory.getLogger(ConfigurationHolder.class);
    private PropertiesUtils proUtil = PropertiesUtils.getCommentedPropertiesInstance();
    /**
     * 读取配置文件默认编码（UTF-8）
     */
    private static final String PROPERTY_FILE_ENCODING = "UTF-8";

    // 配置项保存结构（配置项非常多并且操作频繁影响性能时，可以使用redis等缓存保存此结构）
    private static ConcurrentHashMap<String, String> propertiesMap = new ConcurrentHashMap<>();

    // 单例类中唯一实例
    private static ConfigurationHolder instance = null;

    // 属性数据来源（配置文件列表）
    private List<String> propertyFiles;

    // // 配置加载标识符
    // private boolean loadCompleteFlg = false;

    /**
     * 
     * setPropertyFiles(设置属性数据来源配置文件列表，默认classpath路径下，spring属性注入使用)
     * 
     * @param propertyFiles 配置文件classpath相对路径列表
     * @since 1.0
     */
    public void setPropertyFiles(List<String> propertyFiles)
    {
        if ((propertyFiles != null) && (propertyFiles.size() > 0))
        {
            logger.info("===========从配置文件中加载属性开始============");
            this.propertyFiles = propertyFiles;
            loadFromPropertyFiles();
            logger.info("===========从配置文件中加载属性结束============");
        }
    }

    /**
     * 
     * setRpcUrls(设置远程调用取得属性数据来源地址)
     * 
     * @param rpcUrls 远程调用取得属性值的地址
     * @since 1.0
     */
    public void setRpcUrls(List<String> rpcUrls)
    {
    }

    /**
     * 构造函数私有化 创建一个新的实例 ConfigurationHolder.
     * 
     */
    private ConfigurationHolder()
    {
        // 加载配置属性值
        // TODO 从配置文件列表中
        // spring执行构造函数时，对应的属性值如propertyFiles还未注入
        // loadFromPropertyFiles();
        // TODO 调用RPC
    }

    /**
     * 
     * getInstance(取得唯一实例)
     * 
     * @return ConfigurationHolder 配置中心实例（全局唯一）
     * @since 1.0
     */
    public static synchronized ConfigurationHolder getInstance()
    {
        if (instance == null)
        {
            instance = new ConfigurationHolder();
        }

        return instance;
    }

    /**
     * 
     * loadFromPropertyFiles 从配置文件中加载属性列表 默认UTF-8编码解决中文乱码问题，默认最大程度加载配置文件，如果加载多个配置文件，有一个配置文件加载时出错，继续加载其他配置文件
     * 
     * @since 1.0
     */
    private void loadFromPropertyFiles()
    {

        // 加载各配置文件中的属性列表，如果有相同配置项，默认后面的覆盖前面配置项的值
        if ((propertyFiles != null) && (propertyFiles.size() > 0))
        {
            EncodedResource propertyResource = null;
            for (String propertyFilePath : propertyFiles)
            {

                // 属性文件使用UTF-8加载，解决属性文件中属性值为中文的配置项乱码问题
                propertyResource = new EncodedResource(new ClassPathResource(propertyFilePath), PROPERTY_FILE_ENCODING);
                
                try
                {
                    Properties props = PropertiesLoaderUtils.loadProperties(propertyResource);
                    for (Object key : props.keySet())
                    {
                        propertiesMap.put(key.toString(), props.getProperty(key.toString()));
                    }
                    
                }
                catch (IOException e)
                {
                    logger.error("加载配置文件异常... 文件名：" + propertyFilePath + "，异常原因：" + e.getMessage());
                }
                // 从配置管理中心主动获取配置文件 add by wangcan
                try
                {
                   logger.info("从配置中心加载配置刷新内存...");
                   PropertiesConfiguration config = PropertiesConfigurationFactoryBean.getPropertiesConfiguration();
                   logger.info("从配置中心加载配置更新配置文件...");
                   proUtil.operatorPropertiesFile("UPDATE", config.getPropertiesMap(), new ClassPathResource(propertyFilePath).getFile());
                   propertiesMap.putAll(config.getPropertiesMap());
                   
                }
                catch (Exception e)
                {
                    logger.error("从配置中心加载配置文件异常..." + e.getMessage());
                }

            }
        }
    }

    /**
     * 
     * getProperty(通过配置项的键取得对应的值)
     * 
     * @param key 键
     * @return String 配置项的值
     * @since 1.0
     */
    public String getProperty(String key)
    {
        // TODO 如果首次加载时间较长，未加载完成时该方法再次被调用，会出现重复加载的情况
        // if (!loadCompleteFlg) {
        // logger.debug("==================首次加载属性列表============");
        // // 从配置文件中加载属性值
        // loadFromPropertyFiles();
        // // 调用RPC加载属性值
        // loadFromRpcUrls();
        // // 加载结束，首次使用加载一次
        // loadCompleteFlg = true;
        // logger.debug("==================加载结束=============");
        // }
        if ((StringUtils.isEmpty(key)))
        {
            return null;
        }

        return propertiesMap.get(key);
    }

    /**
     * 获取整形数据，若为空返回默认值
     * @param key
     * @param defaultValue
     * @return
     * @author hangli2
     */
    public int getInteger(String key,int defaultValue){
        if ((StringUtils.isEmpty(key)))
        {
            return defaultValue;
        }
        String  v;
        return (v = propertiesMap.get(key)) == null ? defaultValue: Integer.parseInt(v);
    }

    /**
     * 
     * operatorProperty(操作配置文件)
     * 
     * @param opType UPDATE: 更新操作 ADD:增加操作 CLEAR:清除操作
     * @param key
     * @param value
     * @exception
     * @since 3.1
     * @author canwang2
     */
    public void operatorProperty(String opType, String key, String value)
    {
        switch (opType)
        {
            case "UPDATE":
                propertiesMap.put(key, value);
                break;
            case "ADD":
                propertiesMap.put(key, value);
                break;
            case "CLEAR":
                propertiesMap.remove(key);
                break;
            default:
                break;
        }
    }

    /**
     * 
     * getPropertyListByKeys(根据一组属性名获得所有对应的属性值)
     * 
     * @param keys 属性名列表
     * @return 属性名和属性值的对应关系（如果没有属性名传入时，返回空null）
     * @since 1.0
     * @author longzhao
     */
    public HashMap<String, String> getPropertyListByKeys(List<String> keys)
    {
        if ((keys == null) || (keys.size() < 1))
        {
            return null;
        }

        // 返回结果（属性名-属性值）
        HashMap<String, String> propertyMap = new HashMap<>();
        for (String propertyKey : keys)
        {
            // 对于属性名为空的不作处理
            if (StringUtils.isNotEmpty(propertyKey))
            {
                propertyMap.put(propertyKey, propertiesMap.get(propertyKey));
            }
        }

        return propertyMap;
    }
    /**
     * 
     * getPropertyFiles(get配置文件列表)
     * 
     * @return 
     * @exception 
     * @since 3.1
     * @author canwang2
     */
    public List<String> getPropertyFiles()
    {
        return propertyFiles;
    }

}
