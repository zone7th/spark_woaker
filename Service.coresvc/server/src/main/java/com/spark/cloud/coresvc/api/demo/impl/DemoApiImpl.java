/**
 * <b>项目名：</b>区域教育信息化综合解决方案<br/>
 * <b>包   名：</b>com.pandora.sparkfamily.base.api<br/>
 * <b>文件名：</b>DemoApiImpl.java<br/>
 * <b>版本信息：</b>3.1<br/>
 * <b>日期：</b>2016年1月8日-下午2:29:31<br/>
 * 
 */
package com.spark.cloud.coresvc.api.demo.impl;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spark.cloud.coresvc.api.demo.DemoApi;
import com.spark.cloud.coresvc.common.config.ConfigurationHolder;
import com.spark.cloud.coresvc.utils.CoresvcUtils;
import com.spark.cloud.coresvc.utils.ResultType;
import com.spark.cloud.coresvc.utils.logger.LogUtil;

/**
 * 
 * <b>类   名：</b>DemoApiImpl<br/>
 * <b>类描述：</b>描述这个类的功能<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年1月27日 上午11:17:52<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年1月27日 上午11:17:52<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 *
 */
@Service
public class DemoApiImpl implements DemoApi.Iface
{   
    // 配置管理中心
    @Autowired
    private ConfigurationHolder configurationHolder;
    
    /* (non-Javadoc)
     * @see com.pandora.sparkfamily.base.api.DemoApi.Iface#getIndex(java.lang.String)
     */
    @Override
    public String getIndex(String count) throws TException
    {
        LogUtil.info("获取单个配置项方法开始...方法名:getConfig,方法参数:[count:" + count + "]");
        // 接口最终返回结果
        String result;
        try
        {
            String value = configurationHolder.getProperty(count);
            // 生成最终正确返回的结果（包含返回结果值和相关数据）
            result = CoresvcUtils.createResultJson(ResultType.SimpleResultType.SUCCESS, count).toJSONString();
            LogUtil.info("获取单个配置项方法正常结束...返回结果:" + result);
        }
        catch (Exception e)
        {
            result = CoresvcUtils.createResultJson(ResultType.SimpleResultType.OPERATE_ERROR).toJSONString();
            LogUtil.info("获取单个配置项方法异常结束...返回结果:" + result);
            e.printStackTrace();
        }
        return result;
    }
    
}
