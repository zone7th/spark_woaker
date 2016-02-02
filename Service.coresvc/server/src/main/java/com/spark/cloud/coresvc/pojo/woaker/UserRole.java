/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.pojo.woaker<br/>
 * <b>文件名：</b>UserRole.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年1月30日-下午2:15:49<br/>
 * 
 */
package com.spark.cloud.coresvc.pojo.woaker;

import java.io.Serializable;

import com.spark.cloud.coresvc.constants.WoakerConstants;

/**
 * <b>类 名：</b>UserRole<br/>
 * <b>类描述：</b>用户角色信息<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年1月30日 下午2:15:49<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年1月30日 下午2:15:49<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
public class UserRole implements Serializable
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
    public static final String TABLE_NAME = WoakerConstants.WOAKER_USER_ROLE;

    /**
     * 主键
     */
    Integer id;

    /**
     * 用户ID
     */
    String user_id;

    /**
     * 角色ID
     */
    String role_id;

    /**
     * 角色类型
     */
    String role_type;

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

    public String getRole_id()
    {
        return role_id;
    }

    public void setRole_id(String role_id)
    {
        this.role_id = role_id;
    }

    public String getRole_type()
    {
        return role_type;
    }

    public void setRole_type(String role_type)
    {
        this.role_type = role_type;
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
        return "UserRole [id=" + id + ", user_id=" + user_id + ", role_id=" + role_id + ", role_type=" + role_type + ", is_delete=" + is_delete
                + "]";
    }

}
