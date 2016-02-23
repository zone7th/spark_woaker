/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.utils<br/>
 * <b>文件名：</b>IdUtils.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年2月23日-上午10:45:17<br/>
 * 
 */
package com.spark.cloud.coresvc.utils;

import java.util.UUID;

/**
 * <b>类 名：</b>IdUtils<br/>
 * <b>类描述：</b>id生成工具类<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年2月23日 上午10:45:17<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年2月23日 上午10:45:17<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
public class IdUtils
{
    /**
     * 空字符串.
     */
    public static String id = "";
    
    /**
     * 
     * uuid(生成UUID)
     * 
     * @return 
     * @exception 
     * @since 1.0
     * @author rlliu
     */
    public static String uuid()
    {   
        id = UUID.randomUUID().toString();
        return id;
    }
}
