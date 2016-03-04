/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.dao.woaker<br/>
 * <b>文件名：</b>WorkDao.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年2月1日-上午9:37:18<br/>
 * 
 */
package com.spark.cloud.coresvc.dao.woaker;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.spark.cloud.coresvc.pojo.woaker.WorkInfo;

/**
 * <b>类   名：</b>WorkDao<br/>
 * <b>类描述：</b>工作Dao层接口<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年2月1日 上午9:37:18<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年2月1日 上午9:37:18<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
public interface WorkDao
{
    /**
     * 
     * getWorkLogList(获取工作日志列表)
     * 
     * @param userId    用户ID
     * @param keyWord   关键字
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @param isDelete  是否删除
     * @param page      页码
     * @param limit     分页大小
     * @return 
     * @exception 
     * @since 1.0
     * @author rlliu
     */
    public List<WorkInfo> getWorkInfoList(String userId, String keyWord, String startDate, String endDate, boolean isDelete, int page, int limit);
    
    /**
     * 
     * getWorkInfo(获取工作信息、不传ID时，仅根据userId、和createDate创建。)
     * 
     * @param userId        用户ID
     * @param workInfoId    工作信息ID
     * @param planCreateDate    工作信息计划创建时间
     * @param isDelete      是否删除
     * @return 
     * @exception 
     * @since 1.0
     * @author rlliu
     */
    public List<WorkInfo> getWorkInfo(String userId, String workInfoId, String planCreateDate, boolean isDelete);
    
    /**
     * 
     * createWorkInfo(创建工作信息)
     * 
     * @param userId 用户ID
     * @param title 标题
     * @param planContent 计划内容
     * @param logContent 日志内容
     * @param planCreateDate 计划时间
     * @param logCreateDate 日志时间
     * @param createDate 创建时间
     * @return
     * @exception
     * @since 1.0
     * @author rlliu
     */
    public int createWorkInfo(String userId, String title, String planContent, String logContent, String planCreateDate, String logCreateDate,
            String createDate);

    /**
     * 
     * updateWorkInfo(更新工作信息)
     * 
     * @param userId 用户ID
     * @param title 标题
     * @param planContent 计划内容
     * @param logContent 日志内容
     * @param planCreateDate 计划时间
     * @param logCreateDate 日志时间
     * @param createDate 创建时间
     * @return
     * @exception
     * @since 1.0
     * @author rlliu
     */
    public int updateWorkInfo(String id, String userId, String title, String planContent, String logContent, String planCreateDate, String logCreateDate,
            String createDate);
    
    /**
     * 
     * checkWorkPlanExist(检测计划是否存在)
     * 
     * @param userId 用户ID
     * @param planCreateDate 计划的时间
     * @return 
     * @exception 
     * @since 1.0
     * @author rlliu
     */
    public int checkWorkPlanExist(String userId, String planCreateDate);
}
