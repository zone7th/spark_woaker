/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.base.dao<br/>
 * <b>文件名：</b>SqlSupport.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年2月1日-上午11:35:41<br/>
 * 
 */
package com.spark.cloud.coresvc.base.dao;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <b>类 名：</b>SqlSupport<br/>
 * <b>类描述：</b>描述这个类的功能<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年2月1日 上午11:35:41<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年2月1日 上午11:35:41<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
public class SqlSupport
{
    // 日志类
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    // sql语句
    StringBuilder sql = new StringBuilder();

    // 参数
    Map<String, Object> paramObject = new HashMap<String, Object>();

    // 参数
    Map<String, String> paramString = new HashMap<String, String>();
    
}
