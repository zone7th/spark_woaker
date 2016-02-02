/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.pojo.woaker<br/>
 * <b>文件名：</b>CommentInfo.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年1月30日-下午2:16:19<br/>
 * 
 */
package com.spark.cloud.coresvc.pojo.woaker;

import java.io.Serializable;

import com.spark.cloud.coresvc.constants.WoakerConstants;

/**
 * <b>类 名：</b>CommentInfo<br/>
 * <b>类描述：</b>评论信息<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年1月30日 下午2:16:19<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年1月30日 下午2:16:19<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
public class CommentInfo implements Serializable
{

    /**
     * serialVersionUID:TODO（用一句话描述这个变量表示什么）
     *
     * @since 1.0
     */
    private static final long serialVersionUID = 1L;

    /**
     * 表名称
     */
    public static final String TABLE_NAME = WoakerConstants.WOAKER_COMMENT_INFO;

    /**
     * 主键
     */
    Integer id;
    
    /**
     * 博客id
     */
    String blog_id;
    
    /**
     * 评论标题
     */
    String title;
    
    /**
     * 评论者ID
     */
    String commentator_id;
    
    /**
     * 评论
     */
    String content;
    
    /**
     * 创建时间
     */
    String create_date;
    
    /**
     * 是否删除
     */
    String is_delete;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getBlog_id()
    {
        return blog_id;
    }

    public void setBlog_id(String blog_id)
    {
        this.blog_id = blog_id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getCommentator_id()
    {
        return commentator_id;
    }

    public void setCommentator_id(String commentator_id)
    {
        this.commentator_id = commentator_id;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getCreate_date()
    {
        return create_date;
    }

    public void setCreate_date(String create_date)
    {
        this.create_date = create_date;
    }

    public String getIs_delete()
    {
        return is_delete;
    }

    public void setIs_delete(String is_delete)
    {
        this.is_delete = is_delete;
    }

    @Override
    public String toString()
    {
        return "CommentInfo [id=" + id + ", blog_id=" + blog_id + ", title=" + title + ", commentator_id=" + commentator_id + ", content=" + content
                + ", create_date=" + create_date + ", is_delete=" + is_delete + "]";
    }
}
