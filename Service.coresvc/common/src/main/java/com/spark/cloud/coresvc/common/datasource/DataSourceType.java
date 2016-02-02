/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.common.datasource<br/>
 * <b>文件名：</b>DataSourceType.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年1月27日-上午10:49:43<br/>
 * 
 */
package com.spark.cloud.coresvc.common.datasource;

import com.spark.cloud.coresvc.utils.StringUtils;

/**
 * <b>类 名：</b>DataSourceType<br/>
 * <b>类描述：</b>数据库名称定义类（对应动态数据源中各数据源名称）<br/>
 * <b>创建人：</b>longzhao<br/>
 * <b>创建时间：</b>2015-8-21 下午3:02:14<br/>
 * <b>修改人：</b>longzhao<br/>
 * <b>修改时间：</b>2015-8-21 下午3:02:14<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0<br/>
 * 
 */
public enum DataSourceType
{
    /**
     * 个人空间数据库（主）
     */
    SNS_DB("changyan_sns"),
    /**
     * 个人空间数据库（从）
     */
    SNS_DB_SLAVE("changyan_sns_slave"),
    /**
     * cycore数据库
     */
    CY_CORE_DB("cycore"),
    /**
     * 资源数据库
     */
    RESOURCE_DB("changyan_resource"),
    /**
     * 资源超市数据库
     */
    MARKET_DB("changyan_market"),

    /**
     * 资源中心
     */
    ERCSE_DB("ercse"),

    
    /**
     * 安全监管
     */
    SAFETY_DB("safety");
    
    
    // 数据库名称
    private String dbName;

    /**
     * 
     * 创建一个新的实例 DataSourceType.
     * 
     * @param dbName 数据库名称
     */
    private DataSourceType(String dbName)
    {
        this.dbName = dbName;
    }

    /**
     * 
     * getDbName(取得数据库名称)
     * 
     * @return 数据库名称
     * @since 1.0
     * @author longzhao
     */
    public String getDbName()
    {
        return this.dbName;
    }

    /**
     * 
     * getValueByName(根据数据库名称取得数据库类型)
     * 
     * @param dbName 数据库名称
     * @return 数据库类型
     * @since 1.0
     * @author longzhao
     */
    public static DataSourceType getValueByName(String dbName)
    {
        if (StringUtils.isBlank(dbName))
        {
            return null;
        }

        for (DataSourceType dataSourceType : DataSourceType.values())
        {
            if (StringUtils.equalsIgnoreCase(dbName, dataSourceType.name()))
            {
                return dataSourceType;
            }
        }

        return null;
    }
}
