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

import com.spark.cloud.coresvc.dao.woaker.BlogDao;
import com.spark.cloud.coresvc.pojo.woaker.BlogInfo;
import com.spark.cloud.coresvc.service.woaker.BlogService;

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

    @Autowired
    private BlogDao blogDao;

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
