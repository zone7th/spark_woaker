/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.iflytek.epdcloud.epsp.utils<br/>
 * <b>文件名：</b>EpspUtils.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年1月30日-下午5:11:36<br/>
 * 
 */
package com.spark.cloud.coresvc.utils;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;

/**
 * 
 * <b>类   名：</b>CoresvcUtils<br/>
 * <b>类描述：</b>星火核心工具类<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年1月27日 上午11:38:51<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年1月27日 上午11:38:51<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 *
 */
public class CoresvcUtils
{

    /**
     * 获取用户IP地址.
     * 
     * @param request http请求
     * @return String IP地址
     * @since 1.0
     */
    public static String getRemoteAddr(HttpServletRequest request)
    {
        String remoteAddr = request.getHeader("X-Real-IP");
        if (StringUtils.isNotBlank(remoteAddr))
        {
            remoteAddr = request.getHeader("X-Forwarded-For");
        }
        else if (StringUtils.isNotBlank(remoteAddr))
        {
            remoteAddr = request.getHeader("Proxy-Client-IP");
        }
        else if (StringUtils.isNotBlank(remoteAddr))
        {
            remoteAddr = request.getHeader("WL-Proxy-Client-IP");
        }
        return remoteAddr != null ? remoteAddr : request.getRemoteAddr();
    }

    /**
     * 
     * createResultJson(生成满足接口定义标准的API返回的最终结果对象，返回的消息内容可以单独设置)
     * 
     * @param resultType 返回结果
     * @param msg 自定义业务相关的消息内容
     * @param data 返回数据内容（只有在返回结果为成功的时候需要，如果返回结果为失败并且需要重新设定返回的消息时，调用此方法时该项可以设为null）
     * @return 封装之后的api返回对象
     * @since 1.0
     * @author rlliu
     */
    public static JSONObject createResultJson(ResultType resultType, String msg, Object data)
    {
        JSONObject resultJson = new JSONObject();
        if (resultType != null)
        {
            // Code
            resultJson.put("Code", resultType.getResultCode());
            // Msg(如果没有特别设置消息内容，默认使用定义枚举型的内容字符串)
            if (StringUtils.isNullOrEmpty(msg))
            {
                resultJson.put("Msg", resultType.getResultMsg());
            }
            else
            {
                resultJson.put("Msg", msg);
            }
            // 对于操作成功的结果，需要设置Data项
            if (ResultType.SimpleResultType.SUCCESS.getResultCode() == resultType.getResultCode())
            {
                resultJson.put("Data", data);
            }
        }

        return resultJson;
    }

    /**
     * 
     * createResultJson(生成满足接口定义标准的API返回的最终结果对象)
     * 
     * @param resultType 返回结果
     * @param data 返回内容（只有在返回结果为成功的时候需要）
     * @return 封装之后的api返回对象
     * @since 1.0
     * @author rlliu
     */
    public static JSONObject createResultJson(ResultType resultType, Object data)
    {
        return createResultJson(resultType, null, data);
    }

    /**
     * 
     * createResultJson(生成满足接口定义标准的API返回的最终结果对象)
     * 
     * @param resultType 返回结果
     * @return 封装之后的api返回对象
     * @since 1.0
     * @author rlliu
     */
    public static JSONObject createResultJson(ResultType resultType)
    {
        return createResultJson(resultType, null, null);
    }
}
