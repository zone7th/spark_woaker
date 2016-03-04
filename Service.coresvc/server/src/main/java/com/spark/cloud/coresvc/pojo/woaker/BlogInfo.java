/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.pojo.woaker<br/>
 * <b>文件名：</b>BlogInfo.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年1月30日-下午2:16:02<br/>
 * 
 */
package com.spark.cloud.coresvc.pojo.woaker;

import java.io.Serializable;

import com.spark.cloud.coresvc.constants.WoakerConstants;

/**
 * <b>类 名：</b>BlogInfo<br/>
 * <b>类描述：</b>博客信息<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年1月30日 下午2:16:02<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年1月30日 下午2:16:02<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
public class BlogInfo implements Serializable   
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
    public static final String TABLE_NAME = WoakerConstants.WOAKER_BLOG_INFO;

    /**
     * 主键
     */
    Integer id;

    /**
     * 作者id
     */
    String user_id;

    /**
     * 标题
     */
    String title;

    /**
     * 创作类型（原创，转载，翻译）
     */
    String create_type;

    /**
     * 创作范围（WEB、前端、java等等）
     */
    String create_scope;

    /**
     * 自定义范围（随便、杂集等等）
     */
    String custom_scope;

    /**
     * 创建日期
     */
    String create_date;
    
    /**
     * 转载地址
     */
    String reprint_url;
    
    /**
     * 内容
     */
    String content;
    
    /**
     * 图片链接
     */
    String picture_url;
    
    /**
     * 点赞数量
     */
    Integer upvote_count;
    
    /**
     * 浏览量
     */
    Integer view_count;
    
    /**
     * 收藏量
     */
    Integer collection_count;
    
    /**
     * 是否公开（1：公开 ， 0：不公开）
     */
    boolean is_public;
    
    /**
     * 是否删除（0：未删除，1：已删除）
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

    public String getUser_id()
    {
        return user_id;
    }

    public void setUser_id(String user_id)
    {
        this.user_id = user_id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getCreate_type()
    {
        return create_type;
    }

    public void setCreate_type(String create_type)
    {
        this.create_type = create_type;
    }

    public String getCreate_scope()
    {
        return create_scope;
    }

    public void setCreate_scope(String create_scope)
    {
        this.create_scope = create_scope;
    }

    public String getCustom_scope()
    {
        return custom_scope;
    }

    public void setCustom_scope(String custom_scope)
    {
        this.custom_scope = custom_scope;
    }

    public String getCreate_date()
    {
        return create_date;
    }

    public void setCreate_date(String create_date)
    {
        this.create_date = create_date;
    }

    public String getReprint_url()
    {
        return reprint_url;
    }

    public void setReprint_url(String reprint_url)
    {
        this.reprint_url = reprint_url;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getPicture_url()
    {
        return picture_url;
    }

    public void setPicture_url(String picture_url)
    {
        this.picture_url = picture_url;
    }

    public Integer getUpvote_count()
    {
        return upvote_count;
    }

    public void setUpvote_count(Integer upvote_count)
    {
        this.upvote_count = upvote_count;
    }

    public Integer getView_count()
    {
        return view_count;
    }

    public void setView_count(Integer view_count)
    {
        this.view_count = view_count;
    }

    public Integer getCollection_count()
    {
        return collection_count;
    }

    public void setCollection_count(Integer collection_count)
    {
        this.collection_count = collection_count;
    }

    public boolean isIs_public()
    {
        return is_public;
    }

    public void setIs_public(boolean is_public)
    {
        this.is_public = is_public;
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
        return "BlogInfo [id=" + id + ", user_id=" + user_id + ", title=" + title + ", create_type=" + create_type + ", create_scope="
                + create_scope + ", custom_scope=" + custom_scope + ", create_date=" + create_date + ", reprint_url=" + reprint_url + ", content="
                + content + ", picture_url=" + picture_url + ", upvote_count=" + upvote_count + ", view_count=" + view_count + ", collection_count="
                + collection_count + ", is_public=" + is_public + ", is_delete=" + is_delete + "]";
    }
    
}
