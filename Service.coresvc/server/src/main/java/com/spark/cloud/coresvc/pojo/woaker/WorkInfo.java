/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.pojo.woaker<br/>
 * <b>文件名：</b>WorkPlan.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年1月30日-下午2:17:05<br/>
 * 
 */
package com.spark.cloud.coresvc.pojo.woaker;

import java.io.Serializable;

import com.spark.cloud.coresvc.constants.WoakerConstants;

/**
 * <b>类 名：</b>WorkPlan<br/>
 * <b>类描述：</b>工作计划<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年1月30日 下午2:17:05<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年1月30日 下午2:17:05<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
public class WorkInfo implements Serializable
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
    public static final String TABLE_NAME = WoakerConstants.WOAKER_WORK_INFO;

    /**
     * 主键
     */
    Integer id;

    /**
     * 用户ID
     */
    String user_id;
    
    /**
     * 工作计划标题
     */
    String title;

    /**
     * 工作计划
     */
    String plan_content;
    
    /**
     * 工作日志
     */
    String log_content;
    
    /**
     * 工作计划创建日期
     */
    String plan_create_date;
    
    /**
     * 工作日志创建日期
     */
    String log_create_date;

    /**
     * 创建日期
     */
    String create_date;

    /**
     * 是否删除
     */
    boolean is_delete;

    /**
     * 取得 id
     *
     * @return id
     */
    public Integer getId()
    {
        return id;
    }

    /**
     * 设置 id
     *
     * @param id
     */
    public void setId(Integer id)
    {
        this.id = id;
    }

    /**
     * 取得 user_id
     *
     * @return user_id
     */
    public String getUser_id()
    {
        return user_id;
    }

    /**
     * 设置 user_id
     *
     * @param user_id
     */
    public void setUser_id(String user_id)
    {
        this.user_id = user_id;
    }

    /**
     * 取得 title
     *
     * @return title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * 设置 title
     *
     * @param title
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * 取得 plan_content
     *
     * @return plan_content
     */
    public String getPlan_content()
    {
        return plan_content;
    }

    /**
     * 设置 plan_content
     *
     * @param plan_content
     */
    public void setPlan_content(String plan_content)
    {
        this.plan_content = plan_content;
    }

    /**
     * 取得 log_content
     *
     * @return log_content
     */
    public String getLog_content()
    {
        return log_content;
    }

    /**
     * 设置 log_content
     *
     * @param log_content
     */
    public void setLog_content(String log_content)
    {
        this.log_content = log_content;
    }

    /**
     * 取得 plan_create_date
     *
     * @return plan_create_date
     */
    public String getPlan_create_date()
    {
        return plan_create_date;
    }

    /**
     * 设置 plan_create_date
     *
     * @param plan_create_date
     */
    public void setPlan_create_date(String plan_create_date)
    {
        this.plan_create_date = plan_create_date;
    }

    /**
     * 取得 log_create_date
     *
     * @return log_create_date
     */
    public String getLog_create_date()
    {
        return log_create_date;
    }

    /**
     * 设置 log_create_date
     *
     * @param log_create_date
     */
    public void setLog_create_date(String log_create_date)
    {
        this.log_create_date = log_create_date;
    }

    /**
     * 取得 create_date
     *
     * @return create_date
     */
    public String getCreate_date()
    {
        return create_date;
    }

    /**
     * 设置 create_date
     *
     * @param create_date
     */
    public void setCreate_date(String create_date)
    {
        this.create_date = create_date;
    }

    /**
     * 取得 is_delete
     *
     * @return is_delete
     */
    public boolean isIs_delete()
    {
        return is_delete;
    }

    /**
     * 设置 is_delete
     *
     * @param is_delete
     */
    public void setIs_delete(boolean is_delete)
    {
        this.is_delete = is_delete;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "WorkInfo [id=" + id + ", user_id=" + user_id + ", title=" + title + ", plan_content=" + plan_content + ", log_content="
                + log_content + ", plan_create_date=" + plan_create_date + ", log_create_date=" + log_create_date + ", create_date=" + create_date
                + ", is_delete=" + is_delete + "]";
    }
    
}
