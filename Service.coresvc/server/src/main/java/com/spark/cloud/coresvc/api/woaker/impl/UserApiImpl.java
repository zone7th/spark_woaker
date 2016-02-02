/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.api.woaker.impl<br/>
 * <b>文件名：</b>UserApiImpl.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年2月1日-下午3:37:27<br/>
 * 
 */
package com.spark.cloud.coresvc.api.woaker.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.spark.cloud.coresvc.api.woaker.UserApi;
import com.spark.cloud.coresvc.pojo.woaker.StudyPlan;
import com.spark.cloud.coresvc.pojo.woaker.UserInfo;
import com.spark.cloud.coresvc.service.woaker.UserService;
import com.spark.cloud.coresvc.utils.CoresvcUtils;
import com.spark.cloud.coresvc.utils.ResultType;
import com.spark.cloud.coresvc.utils.StringUtils;
import com.spark.cloud.coresvc.utils.logger.LogUtil;
/**
 * <b>类   名：</b>UserApiImpl<br/>
 * <b>类描述：</b>描述这个类的功能<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年2月1日 下午3:37:27<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年2月1日 下午3:37:27<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
public class UserApiImpl implements UserApi.Iface
{
    @Autowired
    private UserService userService;
    
    @Override
    public String getUserList(String userId, String keyWord, String startDate, String endDate, boolean isDelete, int page, int limit)
            throws TException
    {
        LogUtil.info("woaker获取用户列表方法开始...方法名:getConfig,方法参数:[userId:" + userId + ", keyWord:" + keyWord + ", startDate:" + startDate + ", endDate:" + endDate
                + ", isDelete:" + isDelete + ", page:" + page + ", limit:" + limit + "]");
        // 接口最终返回结果
        JSONObject jsonObject = new JSONObject();
        String result = StringUtils.EMPTY_STRING;
        try
        {
            List<UserInfo> UserList = userService.getUserList(userId, keyWord, startDate, endDate, isDelete, page, limit);
            jsonObject.put("UserList", UserList);
            result = CoresvcUtils.createResultJson(ResultType.SimpleResultType.SUCCESS, jsonObject).toJSONString();
            LogUtil.info("woaker获取用户列表方法正常结束");
            LogUtil.debug("woaker获取用户列表方法返回结果:" + result);
        }
        catch (Exception e)
        {
            result = CoresvcUtils.createResultJson(ResultType.SimpleResultType.OPERATE_ERROR).toJSONString();
            LogUtil.info("woaker获取用户列表方法异常结束...返回结果:" + result);
            e.printStackTrace();
        }
        return result;
    }
    
}
