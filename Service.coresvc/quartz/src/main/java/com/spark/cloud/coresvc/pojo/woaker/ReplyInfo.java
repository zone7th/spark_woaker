/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.pojo.woaker<br/>
 * <b>文件名：</b>ReplyInfo.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年1月30日-下午2:16:35<br/>
 * 
 */
package com.spark.cloud.coresvc.pojo.woaker;

import java.io.Serializable;

import com.spark.cloud.coresvc.constants.WoakerConstants;

/**
 * <b>类   名：</b>ReplyInfo<br/>
 * <b>类描述：</b>评论回复列表信息<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年1月30日 下午2:16:35<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年1月30日 下午2:16:35<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
public class ReplyInfo implements Serializable
{

    /**
     * 
     *
     * @since 1.0
     */
    private static final long serialVersionUID = 1L;
    
    /**
     * 表名称
     */
    public static final String TABLE_NAME = WoakerConstants.WOAKER_REPLY_INFO;
    
    /**
     * 主键
     */
    Integer id;
    
    /**
     * 评论ID
     */
    String comment_id;
    
    /**
     * 评论title
     */
    String title;
    
    /**
     * 回复者ID
     */
    String responder_id;
    
    /**
     * 回复内容
     */
    String content;
    
    /**
     * 创建时间
     */
    String create_date;
    
    /**
     * 是否删除
     */
    boolean is_delete;

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getComment_id()
    {
        return comment_id;
    }

    public void setComment_id(String comment_id)
    {
        this.comment_id = comment_id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getResponder_id()
    {
        return responder_id;
    }

    public void setResponder_id(String responder_id)
    {
        this.responder_id = responder_id;
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

    public boolean isIs_delete()
    {
        return is_delete;
    }

    public void setIs_delete(boolean is_delete)
    {
        this.is_delete = is_delete;
    }

    @Override
    public String toString()
    {
        return "ReplyInfo [id=" + id + ", comment_id=" + comment_id + ", title=" + title + ", responder_id=" + responder_id + ", content=" + content
                + ", create_date=" + create_date + ", is_delete=" + is_delete + "]";
    }
    
}
