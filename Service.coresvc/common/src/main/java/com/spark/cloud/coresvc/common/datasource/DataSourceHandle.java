/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.common.datasource<br/>
 * <b>文件名：</b>DataSourceHandle.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年1月27日-上午10:49:43<br/>
 * 
 */
package com.spark.cloud.coresvc.common.datasource;

/**
 * <b>类   名：</b>DataSourceHandle<br/>
 * <b>类描述：</b>数据源切换类（切换数据源时使用）<br/>
 * <b>创建人：</b>longzhao<br/>
 * <b>创建时间：</b>2015-8-21 下午4:32:19<br/>
 * <b>修改人：</b>longzhao<br/>
 * <b>修改时间：</b>2015-8-21 下午4:32:19<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
public class DataSourceHandle
{
    /**
     * 保存当前连接的数据源的线程级变量
     */
    private static final ThreadLocal<DataSourceType> DATASOURCE_HOLDER = new ThreadLocal<DataSourceType>();

    /**
     * 
     * putDataSource(切换数据源)
     * 
     * @param dataSourceEnum 数据源类型
     * @since 1.0
     * @author mhli2
     */
    public static void putDataSource(DataSourceType dataSourceEnum)
    {
        DATASOURCE_HOLDER.set(dataSourceEnum);
    }

    /**
     * 
     * getDataSouce(获取当前连接的数据源)
     * 
     * @return DataSourceType 当前数据源
     * @since 1.0
     * @author mhli2
     */
    public static DataSourceType getDataSouce()
    {
        return DATASOURCE_HOLDER.get();
    }

}
