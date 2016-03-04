/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.service.woaker<br/>
 * <b>文件名：</b>getBlogList.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年2月1日-上午8:59:08<br/>
 * 
 */
package com.spark.cloud.coresvc.service.woaker;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.spark.cloud.coresvc.pojo.woaker.BlogInfo;

/**
 * <b>类 名：</b>getBlogList<br/>
 * <b>类描述：</b>博客Service层接口<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年2月1日 上午8:59:08<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年2月1日 上午8:59:08<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
public interface BlogService
{   
    /**
     * 
     * getIndex(获取首页)
     *  
     * @exception 
     * @since 1.0
     * @author rlliu
     */
    public JSONObject getIndex();
    
    /**
     * 
     * getBlogIndex(获取我的博客主页)
     * 
     * @param userId 用户ID
     * @param blogId 博客ID
     * @param keyWord 关键字
     * @param createType 创作类型（原创、转载、翻译）
     * @param createScope 创作范围（JAVA、WEB、前端）
     * @param customScope 自定义创作范围（实现接口）
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @param isPublic 是否公开（1：公开、0：不公开）
     * @param isDelete 是否删除（1：已删除、0：未删除）
     * @param page 页码
     * @param limit 分页大小
     * @return
     * @exception
     * @since 1.0
     * @author rlliu
     */
    public JSONObject getBlogIndex(String userId, String blogId, String keyWord, String createType, String createScope, String customScope,
            String startDate, String endDate, boolean isPublic, boolean isDelete, int page, int limit);
    
    /**
     * 
     * getBlogList(获取博客列表)
     * 
     * @param userId 用户ID
     * @param blogId 博客ID
     * @param keyWord 关键字
     * @param createType 创作类型（原创、转载、翻译）
     * @param createScope 创作范围（JAVA、WEB、前端）
     * @param customScope 自定义创作范围（实现接口）
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @param isPublic 是否公开（1：公开、0：不公开）
     * @param isDelete 是否删除（1：已删除、0：未删除）
     * @param page 页码
     * @param limit 分页大小
     * @return
     * @exception
     * @since 1.0
     * @author rlliu
     */
    public List<BlogInfo> getBlogList(String userId, String blogId, String keyWord, String createType, String createScope, String customScope,
            String startDate, String endDate, boolean isPublic, boolean isDelete, int page, int limit);
}
