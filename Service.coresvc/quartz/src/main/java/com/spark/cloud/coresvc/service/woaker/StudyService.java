/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.service.woaker<br/>
 * <b>文件名：</b>StudyService.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年2月1日-上午9:07:21<br/>
 * 
 */
package com.spark.cloud.coresvc.service.woaker;

import java.util.List;

import com.spark.cloud.coresvc.pojo.woaker.StudyPlan;

/**
 * <b>类   名：</b>StudyService<br/>
 * <b>类描述：</b>学习Service层接口<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年2月1日 上午9:07:21<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年2月1日 上午9:07:21<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
public interface StudyService
{
    /**
     * 
     * getStudyPlanList(获取学习计划列表)
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
    public List<StudyPlan> getStudyPlanList(String userId, String keyWord, String startDate, String endDate, boolean isDelete, int page, int limit);
}
