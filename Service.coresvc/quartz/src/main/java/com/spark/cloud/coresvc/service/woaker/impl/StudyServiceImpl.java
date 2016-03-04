/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.service.woaker.impl<br/>
 * <b>文件名：</b>StudyServiceImpl.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年2月1日-上午9:44:33<br/>
 * 
 */
package com.spark.cloud.coresvc.service.woaker.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spark.cloud.coresvc.dao.woaker.StudyDao;
import com.spark.cloud.coresvc.pojo.woaker.StudyPlan;
import com.spark.cloud.coresvc.service.woaker.StudyService;

/**
 * <b>类   名：</b>StudyServiceImpl<br/>
 * <b>类描述：</b>学习Service层接口实现<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年2月1日 上午9:44:33<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年2月1日 上午9:44:33<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
@Service
public class StudyServiceImpl implements StudyService
{
    
    @Autowired
    private StudyDao studyDao;
    
    /* (non-Javadoc)
     * @see com.spark.cloud.coresvc.service.woaker.StudyService#getStudyPlanList(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, int, int)
     */
    @Override
    public List<StudyPlan> getStudyPlanList(String userId, String keyWord, String startDate, String endDate, boolean isDelete, int page, int limit)
    {
        List<StudyPlan> studyPlanList = studyDao.getStudyPlanList(userId, keyWord, startDate, endDate, isDelete, page, limit);
        
        return studyPlanList;
    }

}
