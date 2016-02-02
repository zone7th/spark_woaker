/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.api<br/>
 * <b>文件名：</b>DemoApiImpl.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年1月27日-下午5:06:56<br/>
 * 
 */
package com.spark.cloud.coresvc.api;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.spark.cloud.coresvc.api.Demo0Api;
import com.spark.cloud.coresvc.utils.CoresvcUtils;
import com.spark.cloud.coresvc.utils.ResultType;
import com.spark.cloud.coresvc.utils.logger.LogUtil;

/**
 * <b>类   名：</b>DemoApiImpl<br/>
 * <b>类描述：</b>描述这个类的功能<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年1月27日 下午5:06:56<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年1月27日 下午5:06:56<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
@Service
public class Demo0ApiImpl implements Demo0Api.Iface
{

    /* (non-Javadoc)
     * @see com.spark.cloud.coresvc.api.DemoApi.Iface#getIndex(java.lang.String)
     */
    @Override
    public String getIndex(String count) throws TException
    {
        LogUtil.info("获取单个配置项方法开始...方法名:getConfig,方法参数:[count:" + count + "]");
        // 接口最终返回结果
        String result;
        try
        {
//            String value = configurationHolder.getProperty(count);
            // 生成最终正确返回的结果（包含返回结果值和相关数据）
            result = CoresvcUtils.createResultJson(ResultType.SimpleResultType.SUCCESS, "222222").toJSONString();
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
