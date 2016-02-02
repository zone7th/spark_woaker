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

import com.spark.cloud.coresvc.dao.woaker.BlogDao;
import com.spark.cloud.coresvc.dao.woaker.WorkDao;
import com.spark.cloud.coresvc.pojo.woaker.WorkPlan;
import com.spark.cloud.coresvc.service.woaker.WorkService;

/**
 * <b>类   名：</b>WorksServiceImpl<br/>
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
    
    /* (non-Javadoc)
     * @see com.spark.cloud.coresvc.service.woaker.WorkService#getWorkLogList(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, int, int)
     */
    @Override
    public List<WorkPlan> getWorkLogList(String userId, String keyWord, String startDate, String endDate, boolean isDelete, int page, int limit)
    {
        List<WorkPlan> workPlanList = workDao.getWorkLogList(userId, keyWord, startDate, endDate, isDelete, page, limit);
        
        return workPlanList;
    }

}
