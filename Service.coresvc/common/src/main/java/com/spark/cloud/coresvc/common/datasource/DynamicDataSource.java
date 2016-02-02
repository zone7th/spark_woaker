/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.common.datasource<br/>
 * <b>文件名：</b>DynamicDataSource.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年1月27日-上午10:49:43<br/>
 * 
 */
package com.spark.cloud.coresvc.common.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;


/**
 * <b>类   名：</b>DynamicDataSource<br/>
 * <b>类描述：</b>动态数据源<br/>
 * <b>创建人：</b>mhli2<br/>
 * <b>创建时间：</b>2015-8-19 下午1:59:09<br/>
 * <b>修改人：</b>mhli2<br/>
 * <b>修改时间：</b>2015-8-19 下午1:59:09<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
public class DynamicDataSource extends AbstractRoutingDataSource 
{

    @Override
    protected Object determineCurrentLookupKey()
    {
        return DataSourceHandle.getDataSouce().getDbName();
    }


}
