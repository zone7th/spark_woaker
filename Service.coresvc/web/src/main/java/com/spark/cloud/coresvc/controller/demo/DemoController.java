/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.controller.demo<br/>
 * <b>文件名：</b>DemoController.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年1月27日-上午11:19:53<br/>
 * 
 */
package com.spark.cloud.coresvc.controller.demo;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.thrift.TException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spark.cloud.coresvc.client.DemoClient;
import com.spark.cloud.coresvc.client.EpspClientFactory;

/**
 * <b>类   名：</b>DemoController<br/>
 * <b>类描述：</b>描述这个类的功能<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年1月27日 上午11:19:53<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年1月27日 上午11:19:53<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
@Controller
@RequestMapping("demo")
public class DemoController
{
    @RequestMapping("/getMsg")
    public String getMsg(HttpServletRequest request, Model model){
        String result = StringUtils.EMPTY;
        try
        {
            result = EpspClientFactory.createDemoApi().getIndex("1");
        }
        catch (TException e)
        {
            e.printStackTrace();
        }
        return "demo/index";
    } 
    
    @RequestMapping("/getMsg0")
    public String getMsg0(HttpServletRequest request, Model model){
        String result = StringUtils.EMPTY;
        try
        {
            result = EpspClientFactory.createDemo0Api().getIndex("1");
        }
        catch (TException e)
        {
            e.printStackTrace();
        }
        return "demo/index";
    } 
}
