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
import com.spark.cloud.coresvc.pojo.woaker.WorkInfo;
import com.spark.cloud.coresvc.pojo.woaker.WorkInfo;

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
    public List<WorkInfo> getWorkInfoList(String userId, String keyWord, String startDate, String endDate, boolean isDelete, int page, int limit)
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
        sql.append(" SELECT wi.id, wi.user_id, wi.title, wi.plan_content, wi.log_content, wi.plan_create_date, wi.log_create_date, wi.create_date, wi.is_delete");
        sql.append(" FROM work_info wi");
        sql.append(" WHERE ");
        @SuppressWarnings("unchecked")
        List<WorkInfo> workPlanInfoList = (List<WorkInfo>) this.queryForList(sql.toString(), paramMap, getWorkInfoPo());
        return workPlanInfoList;
    }
    
    /* (non-Javadoc)
     * @see com.spark.cloud.coresvc.dao.woaker.WorkDao#getWorkInfo(java.lang.String, java.lang.String, java.lang.String, boolean)
     */
    @Override
    public WorkInfo getWorkInfo(String userId, String workInfoId, String createDate, boolean isDelete)
    {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("user_id", userId);
        paramMap.put("workInfoId", workInfoId);
        paramMap.put("createDate", createDate);
        paramMap.put("is_delete", isDelete);
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT wi.id, wi.user_id, wi.title, wi.plan_content, wi.log_content, wi.plan_create_date, wi.log_create_date, wi.create_date, wi.is_delete");
        sql.append(" FROM work_info wi");
        sql.append(" WHERE wi.createDate = :createDate");
        WorkInfo workPlanInfo = (WorkInfo) this.queryForObject(sql.toString(), paramMap, getWorkInfoPo());
        return workPlanInfo;
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
    private RowMapper<WorkInfo> getWorkInfoPo()
    {
        return new RowMapper<WorkInfo>()
        {
            @Override
            public WorkInfo mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                WorkInfo workInfo = new WorkInfo();
                workInfo.setId(rs.getInt("id"));
                workInfo.setUser_id(rs.getString("user_id"));
                workInfo.setTitle(rs.getString("title"));
                workInfo.setCreate_date(rs.getString("create_date"));
                workInfo.setPlan_content(rs.getString("plan_content"));
                workInfo.setLog_content(rs.getString("log_content"));
                workInfo.setPlan_create_date(rs.getString("plan_create_date"));
                workInfo.setLog_create_date(rs.getString("log_create_date"));
                workInfo.setIs_delete(rs.getBoolean("is_delete"));
                return workInfo;
            }
        };
    }

}
