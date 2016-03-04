/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.quartz.woaker<br/>
 * <b>文件名：</b>CreateWorkPlanQuartz.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年3月3日-下午5:17:35<br/>
 * 
 */
package com.spark.cloud.coresvc.quartz.woaker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.spark.cloud.coresvc.pojo.woaker.UserInfo;
import com.spark.cloud.coresvc.quartz.woaker.thread.CreateWorkPlanThread;
import com.spark.cloud.coresvc.service.woaker.UserService;
import com.spark.cloud.coresvc.service.woaker.WorkService;
import com.spark.cloud.coresvc.utils.DateUtils;

/**
 * <b>类 名：</b>CreateWorkPlanQuartz<br/>
 * <b>类描述：</b>创建工作计划定时任务<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年3月3日 下午5:17:35<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年3月3日 下午5:17:35<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
@Service
public class CreateWorkPlanQuartz
{
    // 日志
    Logger logger = LoggerFactory.getLogger(CreateWorkPlanQuartz.class);

    @Autowired
    private UserService userService;

    @Autowired
    private WorkService workService;

    private static final int THREADCOUNT = 10;

    private int page = 0;

    // 查询所有用户ID(此步奏也可以使用多线程)
    public void execute()
    {
        ExecutorService executorService = Executors.newFixedThreadPool(THREADCOUNT);
        logger.info("创建工作计划服务start:*******************" + DateUtils.formatDate(new Date(), DateUtils.DATETIME_FORMAT) + "************************");
        List<String> userIds = this.getUserIds(page);
        String nextDay = DateUtils.formatDate(DateUtils.nextDay(1), "yyyy-MM-dd");
        while (userIds.size() > 0)
        {
            for (int i = 0; i < userIds.size(); i++)
            {
                executorService.execute(new CreateWorkPlanThread(workService, userIds.get(i), nextDay));
            }
            page++;
            userIds = this.getUserIds(page);
        }
        executorService.shutdown();
        try
        {
            // 任务过多处理机制
            executorService.awaitTermination(1, TimeUnit.DAYS);
            while (true)
            {
                if (executorService.isTerminated())
                {
                    logger.info("创建工作计划服务End:*******************" + DateUtils.formatDate(new Date(), DateUtils.DATETIME_FORMAT) + "************************");
                    break;
                }
                Thread.sleep(200);
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 
     * getUserIds(获取所有用户ID)
     * 
     * @return
     * @exception
     * @since 1.0
     * @author rlliu
     */
    public List<String> getUserIds(int page)
    {
        List<String> userIds = new ArrayList<String>();
        List<UserInfo> userList = userService.getUserList(null, null, null, null, false, page, 1000);
        for (UserInfo userInfo : userList)
        {
            userIds.add(userInfo.getId().toString());
        }
        return userIds;
    }
}
