/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.dao<br/>
 * <b>文件名：</b>ParamHandle.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年2月1日-下午1:15:44<br/>
 * 
 */
package com.spark.cloud.coresvc.dao;

import java.util.HashMap;
import java.util.Map;

import com.spark.cloud.coresvc.base.dao.ParamHandle;

/**
 * <b>类   名：</b>ParamHandle<br/>
 * <b>类描述：</b>描述这个类的功能<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年2月1日 下午1:15:44<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年2月1日 下午1:15:44<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
public class ParamHandleTest
{
    @SuppressWarnings("unchecked")
    public static void main(String[] args)
    {
        @SuppressWarnings("rawtypes")
        ParamHandle paramHandle = new ParamHandle();
        Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> maponew = new HashMap<String, Object>();
        map.put("1231", "");
        map.put("1232", null);
        map.put("1233", null);
        map.put("234", "234");
        map.put("345", 345);
        maponew = paramHandle.keepEmptyParam(map);
        System.out.println(maponew);
        maponew = paramHandle.removeEmptyParam(map);
        System.out.println(maponew);
    }
}
