/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.service.woaker.impl<br/>
 * <b>文件名：</b>WorksServiceImpl.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年2月1日-上午9:50:43<br/>
 * 
 */
package com.spark.cloud.coresvc.service.woaker.impl;

import java.util.Date;
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
        List<WorkInfo> workInfoList = workDao.getWorkInfoList(userId, null, null, null, false, 0, 20);
        // 获取今日工作
        String today = DateUtils.getDate();
        List<WorkInfo> todayInfoList = workDao.getWorkInfo(userId, null, today, false);
        WorkInfo todayInfo = todayInfoList.size() > 0 ? todayInfoList.get(0) : null;
        // 明天的任务
        String tomorrow = DateUtils.formatDate(DateUtils.nextDay(1), "yyyy-MM-dd");
        List<WorkInfo> tomorrowInfoList = workDao.getWorkInfo(userId, null, tomorrow, false);
        WorkInfo tomorrowInfo = tomorrowInfoList.size() > 0 ? tomorrowInfoList.get(0) : null;
        // 昨天的工作日志
        String yesterday = DateUtils.formatDate(DateUtils.nextDay(-1), "yyyy-MM-dd");
        List<WorkInfo> yesterdayInfoList = workDao.getWorkInfo(userId, null, yesterday, false);
        WorkInfo yesterdayInfo = yesterdayInfoList.size() > 0 ? yesterdayInfoList.get(0) : null;

        jsonObject.put("workInfoList", workInfoList);
        jsonObject.put("todayInfo", todayInfo);
        jsonObject.put("tomorrowInfo", tomorrowInfo);
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
    public JSONObject createWorkInfo(String userId, String planContent, String planCreateDate)
    {
        JSONObject jsonObject = new JSONObject();
        // 查询计划是否已经存在
        int exist = workDao.checkWorkPlanExist(userId, planCreateDate);
        if (exist > 0)
        {
            jsonObject.put("exist", 1);
            jsonObject.put("success", -1);
            return jsonObject;
        }
        int success = workDao.createWorkInfo(userId, null, planContent, null, planCreateDate, null, DateUtils.getDate());
        jsonObject.put("exist", 0);
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
        // 根据是否有时间和内容，来覆盖原来的时间
        if (StringUtils.isBlank(planCreateDate))
        {
            planCreateDate = DateUtils.formatDate(new Date(), "yyyy-MM-dd");
        }
        if (StringUtils.isBlank(logCreateDate))
        {
            logCreateDate = DateUtils.formatDate(new Date(), "yyyy-MM-dd");
        }
        if (StringUtils.isBlank(createDate))
        {
            createDate = DateUtils.formatDate(new Date(), "yyyy-MM-dd");
        }
        int success = workDao.updateWorkInfo(id, userId, title, planContent, logContent, planCreateDate, logCreateDate, createDate);
        jsonObject.put("success", success);
        return jsonObject;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.spark.cloud.coresvc.service.woaker.WorkService#getWorkInfo(java.lang.String)
     */
    @Override
    public JSONObject getWorkInfo(String id)
    {
        JSONObject jsonObject = new JSONObject();
        WorkInfo workInfo = workDao.getWorkInfo(null, id, null, false).get(0);
        jsonObject.put("workInfo", workInfo);
        return jsonObject;
    }
}
