/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.common.datasource<br/>
 * <b>文件名：</b>SlaveSwitchAspect.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年1月27日-上午10:49:43<br/>
 * 
 */
package com.spark.cloud.coresvc.common.datasource;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.spark.cloud.coresvc.constants.CoresvcConstants;

/**
 * <b>类 名：</b>SlaveSwitchAspect<br/>
 * <b>类描述：</b>读写分离切面（实现数据库读操作的从库自动切换）<br/>
 * <b>创建人：</b>mhli2<br/>
 * <b>创建时间：</b>2015-8-19 下午2:41:32<br/>
 * <b>修改人：</b>mhli2<br/>
 * <b>修改时间：</b>2015-8-25 下午2:41:32<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0<br/>
 * 
 */
public class SlaveSwitchAspect implements MethodInterceptor
{

    /**
     * 新增、修改、删除等写数据库方法匹配字符串.
     */
    @SuppressWarnings("unused")
    private static final String[] WRITE_PREFIXS = { "insert", "add", "create", "update", "edit", "modify", "save", "delete", "remove" };

    /**
     * 查询方法匹配字符串.
     */
    private static final String[] READ_PREFIXS = { "get", "query", "find", "select" };

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable
    {
        Object obj;
        // 获取当前设置的数据源，若未设置数据源则默认数据源
        DataSourceType currentDatasource = DataSourceHandle.getDataSouce();
        DataSourceType masterDataSource;
        if (currentDatasource == null)
        {
            masterDataSource = CoresvcConstants.DEFAULT_DATASOURCE;
        }
        else
        {
            masterDataSource = currentDatasource;
        }
        // 获取执行的方法名称，判断是否为读操作，读操作连从库，写操作必须写入主库
        String methodName = invocation.getMethod().getName();
        boolean isRead = false;
        for (String readPrefix : READ_PREFIXS)
        {
            if (methodName.startsWith(readPrefix))
            {
                isRead = true;
                // 判断设置的数据源从库是否存在，不存在则使用主库
                DataSourceType slaveDataSource = DataSourceType.getValueByName(masterDataSource.name() + "_SLAVE");
                if (null != slaveDataSource)
                {
                    DataSourceHandle.putDataSource(slaveDataSource);
                }
                else
                {
                    DataSourceHandle.putDataSource(masterDataSource);
                }
                break;
            }
        }
        // 不是读操作，切换到当前数据源对应的主库
        if (!isRead)
        {
            DataSourceHandle.putDataSource(masterDataSource);
        }
        obj = invocation.proceed();
        return obj;
    }
}
