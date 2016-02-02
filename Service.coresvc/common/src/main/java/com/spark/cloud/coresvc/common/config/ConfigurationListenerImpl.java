/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.common.config<br/>
 * <b>文件名：</b>ConfigurationListenerImpl.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年1月27日-上午10:49:43<br/>
 * 
 */
package com.spark.cloud.coresvc.common.config;

import com.github.diamond.client.event.ConfigurationEvent;
import com.github.diamond.client.event.ConfigurationListener;
import com.github.diamond.client.util.PropertiesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * <b>类   名：</b>ConfigurationListenerImpl<br/>
 * <b>类描述：</b>配置中心配置项更新监听类实现<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年1月7日 下午5:37:52<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年1月27日 下午5:37:52<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 *
 */
public class ConfigurationListenerImpl implements ConfigurationListener
{
    private Logger logger = LoggerFactory.getLogger(ConfigurationHolder.class);
    private ConfigurationHolder configurationHolder = ConfigurationHolder.getInstance();
    
    private PropertiesUtils proUtil = PropertiesUtils.getCommentedPropertiesInstance();
    
    @Override
    public void configurationChanged(ConfigurationEvent event)
    {
        File file = null;
        try
        {
            Map<String, String> proMap = new HashMap<String, String>();
            proMap.put(event.getPropertyName(), (String) event.getPropertyValue());
            file = new ClassPathResource(configurationHolder.getPropertyFiles().get(0)).getFile();
            // 更新配置文件
            proUtil.operatorPropertiesFile(event.getType().name(), proMap, file);
            // 刷新configurationHolder
            configurationHolder.operatorProperty(event.getType().name(), event.getPropertyName(), (String) event.getPropertyValue());
        }
        catch (IOException e)
        {
            logger.error("配置文件变更操作失败..." + " key=" + event.getPropertyName() + "  value=" + event.getPropertyValue() + "\r\n" + e.getMessage());
        }

        logger.info("配置中心操作配置  操作类型：" + event.getType().name() + "  key:" + event.getPropertyName() + "  value:" + event.getPropertyValue());

    }

}
