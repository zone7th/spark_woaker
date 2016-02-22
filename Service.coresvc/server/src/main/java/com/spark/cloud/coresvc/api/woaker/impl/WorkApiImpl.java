/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.api.woaker<br/>
 * <b>文件名：</b>WorkApiImpl.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年1月30日-下午5:12:56<br/>
 * 
 */
package com.spark.cloud.coresvc.api.woaker.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.spark.cloud.coresvc.api.woaker.WorkApi;
import com.spark.cloud.coresvc.pojo.woaker.WorkInfo;
import com.spark.cloud.coresvc.service.woaker.WorkService;
import com.spark.cloud.coresvc.utils.CoresvcUtils;
import com.spark.cloud.coresvc.utils.ResultType;
import com.spark.cloud.coresvc.utils.StringUtils;
import com.spark.cloud.coresvc.utils.logger.LogUtil;

/**
 * <b>类 名：</b>WorkApiImpl<br/>
 * <b>类描述：</b>工作计划接口<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年1月30日 下午5:12:56<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年1月30日 下午5:12:56<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
@Service
public class WorkApiImpl implements WorkApi.Iface
{
    @Autowired
    private WorkService workService;

    @Override
    public String getWorkLogList(String userId, String keyWord, String startDate, String endDate, boolean isDelete, int page, int limit)
            throws TException
    {
        LogUtil.info("woaker获取工作日志方法开始...方法名:getWorkLogList,方法参数:[userId:" + userId + ", keyWord:" + keyWord + ", startDate:" + startDate + ", endDate:"
                + endDate + ", isDelete:" + isDelete + ", page:" + page + ", limit:" + limit + "]");
        // 接口最终返回结果
        JSONObject jsonObject = new JSONObject();
        String result = StringUtils.EMPTY_STRING;
        try
        {
            List<WorkInfo> workPlanList = workService.getWorkInfoList(userId, keyWord, startDate, endDate, isDelete, page, limit);
            jsonObject.put("workPlanList", workPlanList);
            result = CoresvcUtils.createResultJson(ResultType.SimpleResultType.SUCCESS, jsonObject).toJSONString();
            LogUtil.info("woaker获取工作日志方法正常结束");
            LogUtil.debug("woaker获取工作日志方法返回结果:" + result);
        }
        catch (Exception e)
        {
            result = CoresvcUtils.createResultJson(ResultType.SimpleResultType.OPERATE_ERROR).toJSONString();
            LogUtil.info("woaker获取工作日志方法异常结束...返回结果:" + result);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String getWorkIndex(String userId, String keyWord, String startDate, String endDate, boolean isDelete, int page, int limit)
            throws TException
    {
        LogUtil.info("woaker获取工作首页方法开始...方法名:getWorkIndex,方法参数:[userId:" + userId + ", keyWord:" + keyWord + ", startDate:" + startDate + ", endDate:"
                + endDate + ", isDelete:" + isDelete + ", page:" + page + ", limit:" + limit + "]");
        // 接口最终返回结果
        JSONObject jsonObject = new JSONObject();
        String result = StringUtils.EMPTY_STRING;
        try
        {   
            jsonObject = workService.getWorkIndex(userId);
            result = CoresvcUtils.createResultJson(ResultType.SimpleResultType.SUCCESS, jsonObject).toJSONString();
            LogUtil.info("woaker获取工作日志方法正常结束");
            LogUtil.debug("woaker获取工作日志方法返回结果:" + result);
        }
        catch (Exception e)
        {
            result = CoresvcUtils.createResultJson(ResultType.SimpleResultType.OPERATE_ERROR).toJSONString();
            LogUtil.info("woaker获取工作日志方法异常结束...返回结果:" + result);
            e.printStackTrace();
        }
        return result;
    }

}
