/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.pojo.woaker<br/>
 * <b>文件名：</b>StudyPlan.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年1月30日-下午2:17:33<br/>
 * 
 */
package com.spark.cloud.coresvc.pojo.woaker;

import java.io.Serializable;

import com.spark.cloud.coresvc.constants.WoakerConstants;

/**
 * <b>类 名：</b>StudyPlan<br/>
 * <b>类描述：</b>学习计划信息<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年1月30日 下午2:17:33<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年1月30日 下午2:17:33<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
public class StudyPlan implements Serializable
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
    public static final String TABLE_NAME = WoakerConstants.WOAKER_WORK_PLAN;

    /**
     * 主键
     */
    Integer id;

    /**
     * 用户ID
     */
    String user_id;
    
    /**
     * 学习计划标题
     */
    String title;

    /**
     * 学习计划
     */
    String content;

    /**
     * 创建日期
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
        return "StudyPlan [id=" + id + ", user_id=" + user_id + ", title=" + title + ", content=" + content + ", create_date=" + create_date
                + ", is_delete=" + is_delete + "]";
    }
    
}
