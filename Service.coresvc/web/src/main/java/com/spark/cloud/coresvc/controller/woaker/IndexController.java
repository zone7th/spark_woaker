/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.controller.woaker<br/>
 * <b>文件名：</b>IndexController.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年2月18日-上午11:20:59<br/>
 * 
 */
package com.spark.cloud.coresvc.controller.woaker;

import org.apache.thrift.TException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.spark.cloud.coresvc.client.WoakerClientFactory;
import com.spark.cloud.coresvc.constants.WoakerConstants;

/**
 * <b>类 名：</b>IndexController<br/>
 * <b>类描述：</b>woaker首页控制器<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年2月18日 上午11:20:59<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年2月18日 上午11:20:59<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
@Controller
@RequestMapping("index")
public class IndexController
{
    // String userId, String blogId, String keyWord, String createType, String createScope, String customScope, String startDate, String endDate,
    // boolean isPublic, boolean isDelete, int page, int limit
    // userId, blogId, keyWord, createType, createScope, customScope, startDate, endDate, isPublic, isDelete, page, limit
    @RequestMapping("/index")
    public String index(Model model)
    {   
        model.addAttribute("current",WoakerConstants.INDEX);
        /*try
        {
            String resultJson = WoakerClientFactory.createBlogApi().getIndex();
            JSONObject jsonObject = JSONObject.parseObject(resultJson);
            if (jsonObject.getIntValue("Code") == 0)
            {
                JSONObject json = jsonObject.getJSONObject("Data");
                model.addAllAttributes(json);
            }
        }
        catch (TException e)
        {
            e.printStackTrace();
        }*/
        return "index/index";
    }

    @RequestMapping("/register")
    public String register()
    {
        // 跳转到注册页面
        return "index/register";
    }

    @RequestMapping("/login")
    public String login()
    {
        // 跳转到登陆页面
        return "index/login";
    }
    
    @RequestMapping("/logininto")
    public String logininto()
    {
        // 登陆成功跳转到主界面
        return "index/index.do";
    }

    @RequestMapping("/logout")
    public String logout()
    {
        // 清除session退出系统
        return "index/logout";
    }
}
