/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.service.woaker.impl<br/>
 * <b>文件名：</b>BlogServiceImpl.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年2月1日-上午9:44:12<br/>
 * 
 */
package com.spark.cloud.coresvc.service.woaker.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.spark.cloud.coresvc.dao.woaker.BlogDao;
import com.spark.cloud.coresvc.dao.woaker.CommentDao;
import com.spark.cloud.coresvc.pojo.woaker.BlogInfo;
import com.spark.cloud.coresvc.pojo.woaker.CommentInfo;
import com.spark.cloud.coresvc.service.woaker.BlogService;
import com.spark.cloud.coresvc.utils.StringUtils;

/**
 * <b>类 名：</b>BlogServiceImpl<br/>
 * <b>类描述：</b>博客Service层接口实现<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年2月1日 上午9:44:12<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年2月1日 上午9:44:12<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
@Service
public class BlogServiceImpl implements BlogService
{
    public final static String NoString = StringUtils.EMPTY_STRING;
    
    @Autowired
    private BlogDao blogDao;
    
    @Autowired
    private CommentDao commentDao;

    /* (non-Javadoc)
     * @see com.spark.cloud.coresvc.service.woaker.BlogService#getIndex()
     */
    @Override
    public JSONObject getIndex()
    {   
        JSONObject jsonObject = new JSONObject(); 
        //获取博客列表（时间排序，分页大小为10）
        List<BlogInfo> blogListObDate = blogDao.getBlogListOrderByDate(NoString, NoString, NoString, NoString, NoString, NoString, NoString, NoString, true, false, 0, 10);
        
        //获取分类数量列表（因涉及到统计的处理方法暂时推迟）
        
        //获取浏览量排行列表
        List<BlogInfo> blogListObViewCount = blogDao.getBlogListOrderByViewCount(NoString, NoString, NoString, NoString, NoString, NoString, NoString, NoString, true, false, 0, 10);
        jsonObject.put("blogListObDate", blogListObDate);
        jsonObject.put("blogListObViewCount", blogListObViewCount);
        return jsonObject;
    }
    
    /* (non-Javadoc)
     * @see com.spark.cloud.coresvc.service.woaker.BlogService#getBlogIndex(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, int, int)
     */
    @Override
    public JSONObject getBlogIndex(String userId, String blogId, String keyWord, String createType, String createScope, String customScope,
            String startDate, String endDate, boolean isPublic, boolean isDelete, int page, int limit)
    {
        JSONObject jsonObject = new JSONObject(); 
        //获取博客列表（时间排序，分页大小为10）
        List<BlogInfo> blogListObDate = blogDao.getBlogListOrderByDate(userId, NoString, NoString, NoString, NoString, NoString, NoString, NoString, true, false, 0, 10);
        
        //获取分类数量列表（因涉及到统计的处理方法暂时推迟）
        
        //评论数量排行列表（直接评论数量、暂时回复不算进评论数量）
        List<CommentInfo> commentRankList = commentDao.getCommentRank(userId);
        
        //阅读数量排行列表（浏览量）
        List<BlogInfo> blogListObViewCount = blogDao.getBlogListOrderByViewCount(userId, NoString, NoString, NoString, NoString, NoString, NoString, NoString, true, false, 0, 5);
        
        //最新评论排行列表
        jsonObject.put("blogListObDate", blogListObDate);
        jsonObject.put("blogListObViewCount", blogListObViewCount);
        jsonObject.put("commentRankList", commentRankList);
        return jsonObject;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.spark.cloud.coresvc.service.woaker.BlogService#getBlogList(java.lang.String, java.lang.String, java.lang.String, java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, boolean, int, int)
     */
    @Override
    public List<BlogInfo> getBlogList(String userId, String blogId, String keyWord, String createType, String createScope, String customScope,
            String startDate, String endDate, boolean isPublic, boolean isDelete, int page, int limit)
    {
        List<BlogInfo> blogList = blogDao.getBlogList(userId, blogId, keyWord, createType, createScope, customScope, startDate, endDate, isPublic, isDelete, page, limit);
        
        return blogList;
    }

}
