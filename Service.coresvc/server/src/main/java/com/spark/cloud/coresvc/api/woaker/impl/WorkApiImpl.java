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
    public final static String NoString = StringUtils.EMPTY_STRING; 
    
    @Autowired
    private WorkService workService;

    @Override
    public String getWorkLogList(String userId, String keyWord, String startDate, String endDate, boolean isDelete, int page, int limit)
            throws TException
    {
        LogUtil.info("woaker获取工作日志方法开始...方法名:getWorkLogList,方法参数:[userId:" + userId + ", keyWord:" + keyWord + ", startDate:" + startDate
                + ", endDate:" + endDate + ", isDelete:" + isDelete + ", page:" + page + ", limit:" + limit + "]");
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
    public String getWorkIndex(String userId) throws TException
    {
        LogUtil.info("woaker获取工作首页方法开始...方法名:getWorkIndex,方法参数:[userId:" + userId + "]");
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

    /*
     * (non-Javadoc)
     * 
     * @see com.spark.cloud.coresvc.api.woaker.WorkApi.Iface#createWorkInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public String createWorkInfo(String userId, String planContent, String planCreateDate) throws TException
    {
        LogUtil.info("woaker创建工作信息方法开始...方法名:createWorkInfo,方法参数:[userId:" + userId + ", planContent:" + planContent + ", planCreateDate:"
                + planCreateDate + "]");
        // 接口最终返回结果
        JSONObject jsonObject = new JSONObject();
        String result = StringUtils.EMPTY_STRING;
        try
        {
            jsonObject = workService.createWorkInfo(userId, planContent, planCreateDate);
            result = CoresvcUtils.createResultJson(ResultType.SimpleResultType.SUCCESS, jsonObject).toJSONString();
            LogUtil.info("woaker创建工作信息方法正常结束");
            LogUtil.debug("woaker创建工作信息方法返回结果:" + result);
        }
        catch (Exception e)
        {
            result = CoresvcUtils.createResultJson(ResultType.SimpleResultType.OPERATE_ERROR).toJSONString();
            LogUtil.info("woaker创建工作信息方法异常结束...返回结果:" + result);
            e.printStackTrace();
        }
        return result;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.spark.cloud.coresvc.api.woaker.WorkApi.Iface#updateWorkInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public String updateWorkInfo(String id, String userId, String title, String planContent, String logContent, String planCreateDate,
            String logCreateDate, String createDate) throws TException
    {
        LogUtil.info("woaker更新工作信息方法开始...方法名:createWorkInfo,方法参数:[id:" + id + ", userId:" + userId + ", title:" + title + ", planContent:"
                + planContent + ", logContent:" + logContent + ", planCreateDate:" + planCreateDate + ", logCreateDate:" + logCreateDate
                + ", createDate:" + createDate + "]");
        // 接口最终返回结果
        JSONObject jsonObject = new JSONObject();
        String result = StringUtils.EMPTY_STRING;
        try
        {
            jsonObject = workService.updateWorkInfo(id, userId, title, planContent, logContent, planCreateDate, logCreateDate, createDate);
            result = CoresvcUtils.createResultJson(ResultType.SimpleResultType.SUCCESS, jsonObject).toJSONString();
            LogUtil.info("woaker更新工作信息方法正常结束");
            LogUtil.debug("woaker更新工作信息方法返回结果:" + result);
        }
        catch (Exception e)
        {
            result = CoresvcUtils.createResultJson(ResultType.SimpleResultType.OPERATE_ERROR).toJSONString();
            LogUtil.info("woaker更新工作信息方法异常结束...返回结果:" + result);
            e.printStackTrace();
        }
        return result;
    }

    /* (non-Javadoc)
     * @see com.spark.cloud.coresvc.api.woaker.WorkApi.Iface#getWorkInfo(java.lang.String)
     */
    @Override
    public String getWorkInfo(String id) throws TException
    {
        LogUtil.info("woaker获取工作信息方法开始...方法名:createWorkInfo,方法参数:[id:" + id + "]");
        // 接口最终返回结果
        JSONObject jsonObject = new JSONObject();
        String result = StringUtils.EMPTY_STRING;
        try
        {
            jsonObject = workService.getWorkInfo(id);
            result = CoresvcUtils.createResultJson(ResultType.SimpleResultType.SUCCESS, jsonObject).toJSONString();
            LogUtil.info("woaker获取工作信息方法正常结束");
            LogUtil.debug("woaker获取工作信息方法返回结果:" + result);
        }
        catch (Exception e)
        {
            result = CoresvcUtils.createResultJson(ResultType.SimpleResultType.OPERATE_ERROR).toJSONString();
            LogUtil.info("woaker获取工作信息方法异常结束...返回结果:" + result);
            e.printStackTrace();
        }
        return result;
    }
}
