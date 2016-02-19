/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.api.woaker<br/>
 * <b>文件名：</b>BlogApiImpl.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年1月30日-下午5:11:36<br/>
 * 
 */
package com.spark.cloud.coresvc.api.woaker.impl;

import java.util.List;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.spark.cloud.coresvc.api.woaker.BlogApi;
import com.spark.cloud.coresvc.pojo.woaker.BlogInfo;
import com.spark.cloud.coresvc.service.woaker.BlogService;
import com.spark.cloud.coresvc.utils.CoresvcUtils;
import com.spark.cloud.coresvc.utils.ResultType;
import com.spark.cloud.coresvc.utils.StringUtils;
import com.spark.cloud.coresvc.utils.logger.LogUtil;

/**
 * <b>类 名：</b>BlogApiImpl<br/>
 * <b>类描述：</b>博客相关接口<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年1月30日 下午5:11:36<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年1月30日 下午5:11:36<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
@Service
public class BlogApiImpl implements BlogApi.Iface
{   
    public final static String NoString = StringUtils.EMPTY_STRING; 
    
    @Autowired
    private BlogService blogService;

    @Override
    public String getBlogList(String userId, String blogId, String keyWord, String createType, String createScope, String customScope,
            String startDate, String endDate, boolean isPublic, boolean isDelete, int page, int limit) throws TException
    {
        LogUtil.info("woaker获取博客列表方法开始...方法名:getConfig,方法参数:[userId:" + userId + ", blogId:" + blogId + ", keyWord:" + keyWord + ", createType:"
                + createType + ", createScope:" + createScope + ", customScope:" + customScope + ", startDate:" + startDate + ", endDate:" + endDate
                + ", isPublic:" + isPublic + ", isDelete:" + isDelete + ", page:" + page + ", limit:" + limit + "]");
        // 接口最终返回结果
        JSONObject jsonObject = new JSONObject();
        String result = StringUtils.EMPTY_STRING;
        try
        {
            List<BlogInfo> blogList = blogService.getBlogList(userId, blogId, keyWord, createType, createScope, customScope, startDate, endDate, isPublic, isDelete, page, limit);
            jsonObject.put("blogList", blogList);
            result = CoresvcUtils.createResultJson(ResultType.SimpleResultType.SUCCESS, jsonObject).toJSONString();
            LogUtil.info("woaker获取博客列表方法正常结束");
            LogUtil.debug("woaker获取博客列表方法返回结果:" + result);
        }
        catch (Exception e)
        {
            result = CoresvcUtils.createResultJson(ResultType.SimpleResultType.OPERATE_ERROR).toJSONString();
            LogUtil.info("woaker获取博客列表方法异常结束...返回结果:" + result);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String getIndex() throws TException
    {
     // 接口最终返回结果
        JSONObject jsonObject = new JSONObject();
        String result = StringUtils.EMPTY_STRING;
        try
        {   
            //获取博客列表（时间排序，分页大小为10）
            List<BlogInfo> blogList = blogService.getBlogList(NoString, NoString, NoString, NoString, NoString, NoString, NoString, NoString, true, false, 0, 10);
            //获取分类数量列表
            List<BlogInfo> blogList = blogService.getBlogList(NoString, NoString, NoString, NoString, NoString, NoString, NoString, NoString, true, false, 0, 10);
            //获取浏览量排行列表
            List<BlogInfo> blogList = blogService.getBlogList(userId, blogId, keyWord, createType, createScope, customScope, startDate, endDate, isPublic, isDelete, page, limit);
            jsonObject.put("blogList", blogList);
            result = CoresvcUtils.createResultJson(ResultType.SimpleResultType.SUCCESS, jsonObject).toJSONString();
            LogUtil.info("woaker获取首页方法正常结束");
            LogUtil.debug("woaker获取首页方法返回结果:" + result);
        }
        catch (Exception e)
        {
            result = CoresvcUtils.createResultJson(ResultType.SimpleResultType.OPERATE_ERROR).toJSONString();
            LogUtil.info("woaker获取首页方法异常结束...返回结果:" + result);
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String getBlogIndex(String userId, String blogId, String keyWord, String createType, String createScope, String customScope,
            String startDate, String endDate, boolean isPublic, boolean isDelete, int page, int limit) throws TException
    {
        LogUtil.info("woaker获取博客主页方法开始...方法名:getConfig,方法参数:[userId:" + userId + ", blogId:" + blogId + ", keyWord:" + keyWord + ", createType:"
                + createType + ", createScope:" + createScope + ", customScope:" + customScope + ", startDate:" + startDate + ", endDate:" + endDate
                + ", isPublic:" + isPublic + ", isDelete:" + isDelete + ", page:" + page + ", limit:" + limit + "]");
        // 接口最终返回结果
        JSONObject jsonObject = new JSONObject();
        String result = StringUtils.EMPTY_STRING;
        try
        {
            List<BlogInfo> blogList = blogService.getBlogList(userId, blogId, keyWord, createType, createScope, customScope, startDate, endDate, isPublic, isDelete, page, limit);
            jsonObject.put("blogList", blogList);
            result = CoresvcUtils.createResultJson(ResultType.SimpleResultType.SUCCESS, jsonObject).toJSONString();
            LogUtil.info("woaker获取博客主页方法正常结束");
            LogUtil.debug("woaker获取博客主页方法返回结果:" + result);
        }
        catch (Exception e)
        {
            result = CoresvcUtils.createResultJson(ResultType.SimpleResultType.OPERATE_ERROR).toJSONString();
            LogUtil.info("woaker获取博客主页方法异常结束...返回结果:" + result);
            e.printStackTrace();
        }
        return result;
    }
    
    
}
