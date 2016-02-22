/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.dao.woaker.impl<br/>
 * <b>文件名：</b>CommentDaoImpl.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年2月22日-下午3:28:07<br/>
 * 
 */
package com.spark.cloud.coresvc.dao.woaker.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import com.alibaba.fastjson.JSONObject;
import com.spark.cloud.coresvc.base.dao.DataSourceSupport;
import com.spark.cloud.coresvc.constants.NumberConstants;
import com.spark.cloud.coresvc.dao.woaker.CommentDao;
import com.spark.cloud.coresvc.pojo.woaker.CommentInfo;

/**
 * <b>类   名：</b>CommentDaoImpl<br/>
 * <b>类描述：</b>描述这个类的功能<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年2月22日 下午3:28:07<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年2月22日 下午3:28:07<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
public class CommentDaoImpl extends DataSourceSupport implements CommentDao
{

    /* (non-Javadoc)
     * @see com.spark.cloud.coresvc.dao.woaker.CommentDao#getCommentRank()
     */
    @Override
    public List<CommentInfo> getCommentRank(String userId)
    {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("page", NumberConstants.ZERO);
        paramMap.put("limit", NumberConstants.FIVE);
        paramMap.put("is_delete", false);
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT count(distinct(ci.blog_id)) AS comment_count, ci.id, ci.blog_id, ci.title");
        sql.append(" FROM comment_info ci");
        sql.append(" WHERE userId = :userId");
        sql.append(" AND is_delete = :is_delete");
        sql.append(" ORDER BY ci.comment_count");
        sql.append(" LIMIT :limit, :page");
        @SuppressWarnings("unchecked")
        List<CommentInfo> commentRankList = (List<CommentInfo>) this.queryForList(sql.toString(), paramMap, getCommentRankPo());
        return commentRankList;
    }
    
    /**
     * 
     * getCommentInfoPo(获取评论列表排行信息)
     * 
     * @return
     * @exception
     * @since 1.0
     * @author rlliu
     */
    private RowMapper<JSONObject> getCommentRankPo()
    {
        return new RowMapper<JSONObject>()
        {
            @Override
            public JSONObject mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                JSONObject commentRank = new JSONObject();
                commentRank.put("id", rs.getInt("id"));
                commentRank.put("blog_id", rs.getString("blog_id"));
                commentRank.put("title", rs.getString("title"));
//                commentRank.put("commentator_id", rs.getString("commentator_id"));
//                commentRank.put("content", rs.getString("content"));
//                commentRank.put("create_date", rs.getString("create_date"));
//                commentRank.put("is_delete", rs.getBoolean("is_delete"));
                commentRank.put("comment_count", rs.getInt("comment_count"));
                return commentRank;
            }
        };
    }
    
    /**
     * 
     * getCommentInfoPo(获取评论信息)
     * 
     * @return
     * @exception
     * @since 1.0
     * @author rlliu
     */
    private RowMapper<CommentInfo> getCommentInfoPo()
    {
        return new RowMapper<CommentInfo>()
        {
            @Override
            public CommentInfo mapRow(ResultSet rs, int rowNum) throws SQLException
            {
                CommentInfo comment = new CommentInfo();
                comment.setId(rs.getInt("id"));
                comment.setBlog_id(rs.getString("blog_id"));
                comment.setTitle(rs.getString("title"));
                comment.setCommentator_id(rs.getString("commentator_id"));
                comment.setContent(rs.getString("content"));
                comment.setCreate_date(rs.getString("create_date"));
                comment.setIs_delete(rs.getBoolean("is_delete"));
                return comment;
            }
        };
    }

}
