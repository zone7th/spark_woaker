/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.service.woaker<br/>
 * <b>文件名：</b>WorkService.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年2月1日-上午9:07:48<br/>
 * 
 */
package com.spark.cloud.coresvc.service.woaker;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.spark.cloud.coresvc.pojo.woaker.WorkInfo;

/**
 * <b>类   名：</b>WorkService<br/>
 * <b>类描述：</b>工作Service层接口<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年2月1日 上午9:07:48<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年2月1日 上午9:07:48<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
public interface WorkService
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
     * getWorkIndex(获取工作计划首页)
     * 
     * @param userId    用户ID
     * @return 
     * @exception 
     * @since 1.0
     * @author rlliu
     */
    public JSONObject getWorkIndex(String userId);
}
