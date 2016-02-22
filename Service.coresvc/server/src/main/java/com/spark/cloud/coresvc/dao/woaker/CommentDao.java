/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.dao.woaker<br/>
 * <b>文件名：</b>CommentDao.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年2月22日-下午3:17:56<br/>
 * 
 */
package com.spark.cloud.coresvc.dao.woaker;

import java.util.List;

import com.spark.cloud.coresvc.pojo.woaker.CommentInfo;

/**
 * <b>类   名：</b>CommentDao<br/>
 * <b>类描述：</b>评论Dao层接口<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年2月22日 下午3:17:56<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年2月22日 下午3:17:56<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
public interface CommentDao
{   
    /**
     * 
     * getCommentRank(获取博客评论排行列表)
     * 
     * @return 
     * @exception 
     * @since 1.0
     * @author rlliu
     */
    public  List<CommentInfo> getCommentRank(String userId);
}
