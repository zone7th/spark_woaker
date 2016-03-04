/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.quartz.woaker.thread<br/>
 * <b>文件名：</b>CreateWorkPlanThread.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年3月3日-下午5:19:06<br/>
 * 
 */
package com.spark.cloud.coresvc.quartz.woaker.thread;

import org.apache.log4j.Logger;

import com.spark.cloud.coresvc.service.woaker.UserService;
import com.spark.cloud.coresvc.service.woaker.WorkService;

/**
 * <b>类 名：</b>CreateWorkPlanThread<br/>
 * <b>类描述：</b>描述这个类的功能<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年3月3日 下午5:19:06<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年3月3日 下午5:19:06<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
public class CreateWorkPlanThread implements Runnable
{
    Logger logger = Logger.getLogger(CreateWorkPlanThread.class);
    
    /**
     * 工作服务
     */
    private WorkService workService;
    
    /**
     * 用户ID
     */
    private String userId;
    
    /**
     * 计划日期
     */
    private String planCreateDate;

    /**
     * 创建一个新的实例 CreateWorkPlanThread.
     *
     */
    public CreateWorkPlanThread(WorkService workService, String userId, String planCreateDate)
    {
        this.workService = workService;
        this.userId = userId;
        this.planCreateDate = planCreateDate;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    @Override
    public void run()
    {
        workService.createWorkInfo(userId, null, planCreateDate);
    }

}
