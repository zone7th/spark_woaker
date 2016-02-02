/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.dao.woaker.impl<br/>
 * <b>文件名：</b>BlogDaoImpl.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年2月1日-上午9:40:41<br/>
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

import com.alibaba.fastjson.JSONObject;
import com.spark.cloud.coresvc.base.dao.DataSourceSupport;
import com.spark.cloud.coresvc.dao.woaker.BlogDao;
import com.spark.cloud.coresvc.pojo.woaker.BlogInfo;

/**
 * <b>类 名：</b>BlogDaoImpl<br/>
 * <b>类描述：</b>博客Dao层接口实现<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年2月1日 上午9:40:41<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年2月1日 上午9:40:41<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
@Repository
public class BlogDaoImpl extends DataSourceSupport implements BlogDao
{
    /*
     * (non-Javadoc)
     * 
     * @see com.spark.cloud.coresvc.dao.woaker.BlogDao#getBlogList(java.lang.String, java.lang.String, java.lang.String, java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, int, int)
     */
    @Override
    public List<BlogInfo> getBlogList(String userId, String blogId, String keyWord, String createType, String createScope, String customScope,
            String startDate, String endDate, boolean isPublic, boolean isDelete, int page, int limit)
    {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("user_id", userId);
        paramMap.put("blog_id", blogId);
        paramMap.put("title", keyWord);
        paramMap.put("create_type", createType);
        paramMap.put("create_type", createScope);
        paramMap.put("create_type", customScope);
        paramMap.put("start_date", startDate);
        paramMap.put("end_date", endDate);
        paramMap.put("is_public", isPublic);
        paramMap.put("is_delete", isDelete);
        paramMap.put("page", page);
        paramMap.put("limit", limit);
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT bi.id, bi.user_id, bi.title, bi.create_type, bi.create_scope, bi.custom_scope, bi.create_date, bi.reprint_url, bi.content, bi.picture_url, bi.upvote_count, bi.view_count, bi.collection_count, bi.is_public, bi.is_delete");
        sql.append(" FROM blog_info bi");
        sql.append(" WHERE ");
        @SuppressWarnings("unchecked")
        List<BlogInfo> blogInfoList = (List<BlogInfo>) this.queryForList(sql.toString(), paramMap, getBlogInfoPo());
        return blogInfoList;
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
    private RowMapper<BlogInfo> getBlogInfoPo()
    {
        return new RowMapper<BlogInfo>()
        {
            @Override
            public BlogInfo mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                BlogInfo blog = new BlogInfo();
                blog.setId(rs.getInt("id"));
                blog.setUser_id(rs.getString("user_id"));
                blog.setTitle(rs.getString("title"));
                blog.setCreate_type(rs.getString("create_type"));
                blog.setCreate_scope(rs.getString("create_scope"));
                blog.setCustom_scope(rs.getString("custom_scope"));
                blog.setCreate_date(rs.getString("create_date"));
                blog.setReprint_url(rs.getString("reprint_url"));
                blog.setContent(rs.getString("content"));
                blog.setPicture_url(rs.getString("picture_url"));
                blog.setUpvote_count(rs.getInt("upvote_count"));
                blog.setView_count(rs.getInt("view_count"));
                blog.setCollection_count(rs.getInt("collection_count"));
                blog.setIs_public(rs.getBoolean("is_public"));
                blog.setIs_delete(rs.getBoolean("is_delete"));
                return blog;
            }
        };
    }

}
