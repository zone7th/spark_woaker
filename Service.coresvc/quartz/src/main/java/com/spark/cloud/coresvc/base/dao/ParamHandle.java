/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.base.dao<br/>
 * <b>文件名：</b>ParamHandle.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年2月1日-下午12:00:18<br/>
 * 
 */
package com.spark.cloud.coresvc.base.dao;

import java.util.HashMap;
import java.util.Map;

import com.spark.cloud.coresvc.utils.StringUtils;

/**
 * <b>类 名：</b>ParamHandle<br/>
 * <b>类描述：</b>描述这个类的功能<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年2月1日 下午12:00:18<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年2月1日 下午12:00:18<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
public class ParamHandle<T>
{
    /**
     * 
     * removeEmptyPara(保留的参数)
     * 
     * @param param 查询参数
     * @return
     * @exception
     * @since 1.0
     * @author rlliu
     */
    public Map<T, T> keepEmptyParam(Map<T, T> param)
    {
        Map<T, T> map = this.coreHandle(param, "keepEmptyParam");
        return map;
    }

    /**
     * 
     * removeEmptyParam(去除为空值的值)
     * 
     * @param param 查询参数
     * @return
     * @exception
     * @since 1.0
     * @author rlliu
     */
    public Map<T, T> removeEmptyParam(Map<T, T> param)
    {
        Map<T, T> map = this.coreHandle(param, "removeEmptyParam");
        return map;
    }

    /**
     * 
     * coreHandle(Map参数处理)
     * 
     * @param param 查询参数
     * @param method 数理方法
     * @return
     * @exception
     * @since 1.0
     * @author rlliu
     */
    public Map<T, T> coreHandle(Map<T, T> param, String method)
    {
        Map<T, T> map = new HashMap<T, T>();
        switch (method)
        {
        // 保留空值
            case "keepEmptyParam":
            {
                for (T key : param.keySet())
                {
                    T value = param.get(key);
                    if (value instanceof Object)
                    {
                        map.put(key, value);
                    }else{
                        map.put(key, null);
                    }
                }
            }
                ;
                break;
            // 去除空值
            case "removeEmptyParam":
            {
                for (T key : param.keySet())
                {
                    T value = param.get(key);
                    if (value instanceof String)
                    {
                        if (StringUtils.isNotBlank((String) value))
                        {
                            map.put(key, value);
                        }
                    }
                    else if (value instanceof Object)
                    {
                        if (value != null)
                        {
                            map.put(key, value);
                        }
                    }
                }
            }
                ;
                break;
            // 默认不去除空值
            default:
            {
                for (T key : param.keySet())
                {
                    T value = param.get(key);
                    if (value instanceof String)
                    {
                        map.put(key, value);
                    }
                    else if (value instanceof Object)
                    {
                        map.put(key, value);
                    }
                }
            }
                ;
                break;
        }
        return map;
    }
}
