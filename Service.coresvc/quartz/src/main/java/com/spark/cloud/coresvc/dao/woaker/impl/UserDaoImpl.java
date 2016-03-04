/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.dao.woaker.impl<br/>
 * <b>文件名：</b>UserDaoImpl.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年2月1日-上午9:42:08<br/>
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
import com.spark.cloud.coresvc.dao.woaker.UserDao;
import com.spark.cloud.coresvc.pojo.woaker.UserInfo;

/**
 * <b>类 名：</b>UserDaoImpl<br/>
 * <b>类描述：</b>用户Dao层接口实现<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年2月1日 上午9:42:08<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年2月1日 上午9:42:08<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
@Repository
public class UserDaoImpl extends DataSourceSupport implements UserDao
{

    /*
     * (non-Javadoc)
     * 
     * @see com.spark.cloud.coresvc.dao.woaker.UserDao#getUserList(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean,
     * int, int)
     */
    @Override
    public List<UserInfo> getUserList(String userId, String keyWord, String startDate, String endDate, boolean isDelete, int page, int limit)
    {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("user_id", userId);
        paramMap.put("start_date", startDate);
        paramMap.put("end_date", endDate);
        paramMap.put("is_delete", isDelete);
        paramMap.put("page", page*limit);
        paramMap.put("limit", limit);
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT ui.id, ui.login, ui.password, ui.avatar_url, ui.age, ui.name, ui.sex, ui.id_card, ui.birthday, ui.province, ui.city, ui.district, ui.school_id, ui.personal_phone, ui.home_phone, ui.home_address, ui.present_address, ui.constellation, ui.integration, ui.follow, ui.blog_rank, ui.work_rank, ui.study_rank, ui.is_delete");
        sql.append(" FROM user_info ui");
        sql.append(" WHERE 1 = 1");
        sql.append(" LIMIT :page, :limit");
        @SuppressWarnings("unchecked")
        List<UserInfo> userInfoInfoList = (List<UserInfo>) this.queryForList(sql.toString(), paramMap, getUserInfoPo());
        return userInfoInfoList;
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
    private RowMapper<UserInfo> getUserInfoPo()
    {
        return new RowMapper<UserInfo>()
        {
            @Override
            public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                UserInfo userInfo = new UserInfo();
                userInfo.setId(rs.getInt("id"));
                userInfo.setLogin(rs.getString("login"));
                userInfo.setPassword(rs.getString("password"));
                userInfo.setAvatar_url(rs.getString("avatar_url"));
                userInfo.setAge(rs.getInt("age"));
                userInfo.setName(rs.getString("name"));
                userInfo.setSex(rs.getBoolean("sex"));
                userInfo.setId_card(rs.getString("id_card"));
                userInfo.setBirthday(rs.getString("birthday"));
                userInfo.setProvince(rs.getString("province"));
                userInfo.setCity(rs.getString("city"));
                userInfo.setDistrict(rs.getString("district"));
                userInfo.setSchool_id(rs.getString("school_id"));
                userInfo.setPersonal_phone(rs.getString("personal_phone"));
                userInfo.setHome_phone(rs.getString("home_phone"));
                userInfo.setHome_address(rs.getString("home_address"));
                userInfo.setPresent_address(rs.getString("present_address"));
                userInfo.setConstellation(rs.getString("constellation"));
                userInfo.setIntegration(rs.getInt("integration"));
                userInfo.setFollow(rs.getInt("follow"));
                userInfo.setBlog_rank(rs.getInt("blog_rank"));
                userInfo.setWork_rank(rs.getInt("work_rank"));
                userInfo.setStudy_rank(rs.getInt("study_rank"));
                userInfo.setIs_delete(rs.getBoolean("is_delete"));
                return userInfo;
            }
        };
    }

}
