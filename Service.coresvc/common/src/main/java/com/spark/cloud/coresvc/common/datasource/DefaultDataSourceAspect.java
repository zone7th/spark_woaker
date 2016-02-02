/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.common.datasource<br/>
 * <b>文件名：</b>DefaultDataSourceAspect.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年1月27日-上午10:49:43<br/>
 * 
 */
package com.spark.cloud.coresvc.common.datasource;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

import com.spark.cloud.coresvc.constants.CoresvcConstants;

/**
 * <b>类   名：</b>DefaultDataSourceAspect<br/>
 * <b>类描述：</b>重置数据源切面（数据源切换至默认数据源，接口方法调用之前）<br/>
 * <b>创建人：</b>longzhao<br/>
 * <b>创建时间：</b>2015-9-6 下午2:49:30<br/>
 * <b>修改人：</b>longzhao<br/>
 * <b>修改时间：</b>2015-9-6 下午2:49:30<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
@Component
public class DefaultDataSourceAspect implements MethodInterceptor
{
    /* (non-Javadoc)
     * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
     */
    @Override
    public Object invoke(MethodInvocation arg0) throws Throwable
    {
        // 数据源切换至默认数据源
        DataSourceHandle.putDataSource(CoresvcConstants.DEFAULT_DATASOURCE);
        // 方法执行
        Object obj;
        obj = arg0.proceed();
        return obj;
    }
}
