/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.pojo.woaker<br/>
 * <b>文件名：</b>UserInfo.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年1月30日-下午2:15:15<br/>
 * 
 */
package com.spark.cloud.coresvc.pojo.woaker;

import java.io.Serializable;

import com.spark.cloud.coresvc.constants.WoakerConstants;

/**
 * <b>类 名：</b>UserInfo<br/>
 * <b>类描述：</b>用户信息<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年1月30日 下午2:15:15<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年1月30日 下午2:15:15<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
public class UserInfo implements Serializable
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
    public static final String TABLE_NAME = WoakerConstants.WOAKER_USER_INFO;

    /**
     * 主键
     */
    Integer id;

    /**
     * 登录账号
     */
    String login;

    /**
     * 密码
     */
    String password;

    /**
     * 头像链接
     */
    String avatar_url;

    /**
     * 年龄
     */
    Integer age;

    /**
     * 姓名
     */
    String name;

    /**
     * 性别
     */
    boolean sex;

    /**
     * 身份证
     */
    String id_card;

    /**
     * 生日
     */
    String birthday;

    /**
     * 省份code
     */
    String province;

    /**
     * 市code
     */
    String city;

    /**
     * 县code
     */
    String district;

    /**
     * 学校ID
     */
    String school_id;

    /**
     * 手机号码
     */
    String personal_phone;

    /**
     * 家庭电话
     */
    String home_phone;

    /**
     * 家庭住址
     */
    String home_address;

    /**
     * 现在居住地
     */
    String present_address;

    /**
     * 星座
     */
    String constellation;

    /**
     * 用户积分
     */
    Integer integration;

    /**
     * 关注数量
     */
    Integer follow;

    /**
     * 博客积分
     */
    Integer blog_rank;

    /**
     * 工作日志积分
     */
    Integer work_rank;

    /**
     * 学习计划积分
     */
    Integer study_rank;

    /**
     * 是否删除（1：已删除，0：未删除）
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

    public String getLogin()
    {
        return login;
    }

    public void setLogin(String login)
    {
        this.login = login;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getAvatar_url()
    {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url)
    {
        this.avatar_url = avatar_url;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public boolean isSex()
    {
        return sex;
    }

    public void setSex(boolean sex)
    {
        this.sex = sex;
    }

    public String getId_card()
    {
        return id_card;
    }

    public void setId_card(String id_card)
    {
        this.id_card = id_card;
    }

    public String getBirthday()
    {
        return birthday;
    }

    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }

    public String getProvince()
    {
        return province;
    }

    public void setProvince(String province)
    {
        this.province = province;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getDistrict()
    {
        return district;
    }

    public void setDistrict(String district)
    {
        this.district = district;
    }

    public String getSchool_id()
    {
        return school_id;
    }

    public void setSchool_id(String school_id)
    {
        this.school_id = school_id;
    }

    public String getPersonal_phone()
    {
        return personal_phone;
    }

    public void setPersonal_phone(String personal_phone)
    {
        this.personal_phone = personal_phone;
    }

    public String getHome_phone()
    {
        return home_phone;
    }

    public void setHome_phone(String home_phone)
    {
        this.home_phone = home_phone;
    }

    public String getHome_address()
    {
        return home_address;
    }

    public void setHome_address(String home_address)
    {
        this.home_address = home_address;
    }

    public String getPresent_address()
    {
        return present_address;
    }

    public void setPresent_address(String present_address)
    {
        this.present_address = present_address;
    }

    public String getConstellation()
    {
        return constellation;
    }

    public void setConstellation(String constellation)
    {
        this.constellation = constellation;
    }

    public Integer getIntegration()
    {
        return integration;
    }

    public void setIntegration(Integer integration)
    {
        this.integration = integration;
    }

    public Integer getFollow()
    {
        return follow;
    }

    public void setFollow(Integer follow)
    {
        this.follow = follow;
    }

    public Integer getBlog_rank()
    {
        return blog_rank;
    }

    public void setBlog_rank(Integer blog_rank)
    {
        this.blog_rank = blog_rank;
    }

    public Integer getWork_rank()
    {
        return work_rank;
    }

    public void setWork_rank(Integer work_rank)
    {
        this.work_rank = work_rank;
    }

    public Integer getStudy_rank()
    {
        return study_rank;
    }

    public void setStudy_rank(Integer study_rank)
    {
        this.study_rank = study_rank;
    }

    public boolean isIs_delete()
    {
        return is_delete;
    }

    public void setIs_delete(boolean is_delete)
    {
        this.is_delete = is_delete;
    }

    public static String getTableName()
    {
        return TABLE_NAME;
    }

    @Override
    public String toString()
    {
        return "UserInfo [id=" + id + ", login=" + login + ", password=" + password + ", avatar_url=" + avatar_url + ", age=" + age + ", name="
                + name + ", sex=" + sex + ", id_card=" + id_card + ", birthday=" + birthday + ", province=" + province + ", city=" + city
                + ", district=" + district + ", school_id=" + school_id + ", personal_phone=" + personal_phone + ", home_phone=" + home_phone
                + ", home_address=" + home_address + ", present_address=" + present_address + ", constellation=" + constellation + ", integration="
                + integration + ", follow=" + follow + ", blog_rank=" + blog_rank + ", work_rank=" + work_rank + ", study_rank=" + study_rank
                + ", is_delete=" + is_delete + "]";
    }

}
