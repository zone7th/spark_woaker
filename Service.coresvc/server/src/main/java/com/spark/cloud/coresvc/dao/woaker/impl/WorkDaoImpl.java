/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.dao.woaker.impl<br/>
 * <b>文件名：</b>WorkDaoImpl.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年2月1日-上午9:42:27<br/>
 * 
 */
package com.spark.cloud.coresvc.dao.woaker.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spark.cloud.coresvc.base.dao.DataSourceSupport;
import com.spark.cloud.coresvc.dao.woaker.WorkDao;
import com.spark.cloud.coresvc.pojo.woaker.WorkPlan;
import com.spark.cloud.coresvc.pojo.woaker.WorkPlan;

/**
 * <b>类   名：</b>WorkDaoImpl<br/>
 * <b>类描述：</b>工作Dao层接口实现<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年2月1日 上午9:42:27<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年2月1日 上午9:42:27<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
@Repository
public class WorkDaoImpl extends DataSourceSupport implements WorkDao
{

    /* (non-Javadoc)
     * @see com.spark.cloud.coresvc.dao.woaker.WorkDao#getWorkLogList(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, int, int)
     */
    @Override
    public List<WorkPlan> getWorkLogList(String userId, String keyWord, String startDate, String endDate, boolean isDelete, int page, int limit)
    {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("user_id", userId);
        paramMap.put("title", keyWord);
        paramMap.put("start_date", startDate);
        paramMap.put("end_date", endDate);
        paramMap.put("is_delete", isDelete);
        paramMap.put("page", page);
        paramMap.put("limit", limit);
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT wp.id, wp.user_id, wp.title, wp.content, wp.create_date, wp.is_delete");
        sql.append(" FROM work_plan wp");
        sql.append(" WHERE ");
        @SuppressWarnings("unchecked")
        List<WorkPlan> workPlanInfoList = (List<WorkPlan>) this.queryForList(sql.toString(), paramMap, getWorkPlanPo());
        return workPlanInfoList;
    }

    /**
     * 
     * getRowMapperPo(获取博客信息)
     * 
     * @return
     * @exception
     * @since 1.0
     * @author rlliu
     */
    private RowMapper<WorkPlan> getWorkPlanPo()
    {
        return new RowMapper<WorkPlan>()
        {
            @Override
            public WorkPlan mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                WorkPlan workPlan = new WorkPlan();
                workPlan.setId(rs.getInt("id"));
                workPlan.setUser_id(rs.getString("user_id"));
                workPlan.setTitle(rs.getString("title"));
                workPlan.setCreate_date(rs.getString("create_date"));
                workPlan.setContent(rs.getString("content"));
                workPlan.setIs_delete(rs.getBoolean("is_delete"));
                return workPlan;
            }
        };
    }

}
