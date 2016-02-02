/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.dao.woaker.impl<br/>
 * <b>文件名：</b>StudyDaoImpl.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年2月1日-上午9:41:39<br/>
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
import com.spark.cloud.coresvc.dao.woaker.StudyDao;
import com.spark.cloud.coresvc.pojo.woaker.StudyPlan;

/**
 * <b>类   名：</b>StudyDaoImpl<br/>
 * <b>类描述：</b>学习Dao层接口实现<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年2月1日 上午9:41:39<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年2月1日 上午9:41:39<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
@Repository
public class StudyDaoImpl extends DataSourceSupport implements StudyDao
{

    /* (non-Javadoc)
     * @see com.spark.cloud.coresvc.dao.woaker.StudyDao#getStudyPlanList(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, int, int)
     */
    @Override
    public List<StudyPlan> getStudyPlanList(String userId, String keyWord, String startDate, String endDate, boolean isDelete, int page, int limit)
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
        sql.append(" SELECT sp.id, sp.user_id, sp.title, sp.content, sp.create_date, sp.is_delete");
        sql.append(" FROM study_plan sp");
        sql.append(" WHERE ");
        @SuppressWarnings("unchecked")
        List<StudyPlan> studyPlanInfoList = (List<StudyPlan>) this.queryForList(sql.toString(), paramMap, getStudyPlanPo());
        return studyPlanInfoList;
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
    private RowMapper<StudyPlan> getStudyPlanPo()
    {
        return new RowMapper<StudyPlan>()
        {
            @Override
            public StudyPlan mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                StudyPlan studyPlan = new StudyPlan();
                studyPlan.setId(rs.getInt("id"));
                studyPlan.setUser_id(rs.getString("user_id"));
                studyPlan.setTitle(rs.getString("title"));
                studyPlan.setContent(rs.getString("content"));
                studyPlan.setCreate_date(rs.getString("create_date"));
                studyPlan.setIs_delete(rs.getBoolean("is_delete"));
                return studyPlan;
            }
        };
    }

}
