/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.service.woaker.impl<br/>
 * <b>文件名：</b>WorksServiceImpl.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年2月1日-上午9:50:43<br/>
 * 
 */
package com.spark.cloud.coresvc.service.woaker.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.spark.cloud.coresvc.dao.woaker.WorkDao;
import com.spark.cloud.coresvc.pojo.woaker.WorkInfo;
import com.spark.cloud.coresvc.service.woaker.WorkService;
import com.spark.cloud.coresvc.utils.DateUtils;
import com.spark.cloud.coresvc.utils.StringUtils;

/**
 * <b>类 名：</b>WorksServiceImpl<br/>
 * <b>类描述：</b>工作Service层接口<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年2月1日 上午9:50:43<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年2月1日 上午9:50:43<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
@Service
public class WorkServiceImpl implements WorkService
{
    public final static String NoString = StringUtils.EMPTY_STRING;

    @Autowired
    private WorkDao workDao;

    /*
     * (non-Javadoc)
     * 
     * @see com.spark.cloud.coresvc.service.woaker.WorkService#getWorkLogList(java.lang.String, java.lang.String, java.lang.String, java.lang.String,
     * boolean, int, int)
     */
    @Override
    public List<WorkInfo> getWorkInfoList(String userId, String keyWord, String startDate, String endDate, boolean isDelete, int page, int limit)
    {
        List<WorkInfo> workPlanList = workDao.getWorkInfoList(userId, keyWord, startDate, endDate, isDelete, page, limit);

        return workPlanList;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.spark.cloud.coresvc.service.woaker.WorkService#getWorkIndex(java.lang.String)
     */
    @Override
    public JSONObject getWorkIndex(String userId)
    {
        JSONObject jsonObject = new JSONObject();
        // 获取工作日志列表
        List<WorkInfo> workInfoList = workDao.getWorkInfoList(userId, NoString, NoString, NoString, false, 0, 10);
        // 获取今日工作
        String today = DateUtils.getDate();
        WorkInfo todayInfo = workDao.getWorkInfo(userId, NoString, today, false);
        // 明天的任务
        String tommorrow = DateUtils.nextDay(1).toString();
        WorkInfo tommorrowInfo = workDao.getWorkInfo(userId, NoString, tommorrow, false);
        // 昨天的工作日志
        String yesterday = DateUtils.nextDay(-1).toString();
        WorkInfo yesterdayInfo = workDao.getWorkInfo(userId, NoString, yesterday, false);

        jsonObject.put("workInfoList", workInfoList);
        jsonObject.put("todayInfo", todayInfo);
        jsonObject.put("tommorrowInfo", tommorrowInfo);
        jsonObject.put("yesterdayInfo", yesterdayInfo);
        return jsonObject;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.spark.cloud.coresvc.service.woaker.WorkService#createWorkInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public JSONObject createWorkInfo(String userId, String title, String planContent, String logContent, String planCreateDate,
            String logCreateDate, String createDate)
    {
        JSONObject jsonObject = new JSONObject();
        int success = workDao.createWorkInfo(userId, title, planContent, logContent, planCreateDate, logCreateDate, createDate);
        jsonObject.put("success", success);
        return jsonObject;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see com.spark.cloud.coresvc.service.woaker.WorkService#updateWorkInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public JSONObject updateWorkInfo(String id, String userId, String title, String planContent, String logContent, String planCreateDate,
            String logCreateDate, String createDate)
    {
        JSONObject jsonObject = new JSONObject();
        int success = workDao.updateWorkInfo(id, userId, title, planContent, logContent, planCreateDate, logCreateDate, createDate);
        jsonObject.put("success", success);
        return jsonObject;
    }

}
