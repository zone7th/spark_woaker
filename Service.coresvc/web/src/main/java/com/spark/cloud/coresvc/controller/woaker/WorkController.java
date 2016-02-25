/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.controller.woaker<br/>
 * <b>文件名：</b>WorkController.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年2月23日-下午1:44:03<br/>
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
import com.spark.cloud.coresvc.utils.StringUtils;

/**
 * <b>类 名：</b>WorkController<br/>
 * <b>类描述：</b>工作信息控制层<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年2月23日 下午1:44:03<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年2月23日 下午1:44:03<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
@Controller
@RequestMapping("work")
public class WorkController
{   
    //空字符串
    public final static String NoString = StringUtils.EMPTY_STRING;

    @RequestMapping("/workIndex")
    public String workIndex(Model model)
    {   
        model.addAttribute("current",WoakerConstants.WORK_INDEX);
        //从session中取出userID
        /*try
        {
            String resultJson = WoakerClientFactory.createWorkApi().getWorkIndex("1234");
            JSONObject jsonObject = JSONObject.parseObject(resultJson);
            if (jsonObject.getIntValue("Code") == 0)
            {
                JSONObject json = jsonObject.getJSONObject("Data");
                //在model中添加数据源
                model.addAllAttributes(json);
            }
        }
        catch (TException e)
        {
            e.printStackTrace();
        }*/
        return "work/workIndex";
    }
    
    @RequestMapping("/createWorkInfo")
    public String createWorkInfo(Model model)
    {   
        //从session中取出userID
        /*try
        {
            String resultJson = WoakerClientFactory.createWorkApi().getWorkIndex("1234");
            JSONObject jsonObject = JSONObject.parseObject(resultJson);
            if (jsonObject.getIntValue("Code") == 0)
            {
                JSONObject json = jsonObject.getJSONObject("Data");
                //在model中添加数据源
                model.addAllAttributes(json);
            }
        }
        catch (TException e)
        {
            e.printStackTrace();
        }*/
        return "work/workPlanInfo";
    }
    
    @RequestMapping("/updateWorkInfo")
    public String updateWorkInfo(Model model,String id, String userId, String title, String planContent, String logContent, String planCreateDate, String logCreateDate, String createDate)
    {   
        //从session中取出userID
        try
        {
            String resultJson = WoakerClientFactory.createWorkApi().updateWorkInfo(id, userId, title, planContent, logContent, planCreateDate, logCreateDate, createDate);
            JSONObject jsonObject = JSONObject.parseObject(resultJson);
            if (jsonObject.getIntValue("Code") == 0)
            {
                JSONObject json = jsonObject.getJSONObject("Data");
                //在model中添加数据源
                model.addAllAttributes(json);
            }
        }
        catch (TException e)
        {
            e.printStackTrace();
        }
        return "work/workInfo";
    }
    
    @RequestMapping("/getWorkInfo")
    public String getWorkInfo(Model model)
    {   
        //从session中取出userID
        /*try
        {
            String resultJson = WoakerClientFactory.createWorkApi().getWorkIndex("1234");
            JSONObject jsonObject = JSONObject.parseObject(resultJson);
            if (jsonObject.getIntValue("Code") == 0)
            {
                JSONObject json = jsonObject.getJSONObject("Data");
                //在model中添加数据源
                model.addAllAttributes(json);
            }
        }
        catch (TException e)
        {
            e.printStackTrace();
        }*/
        return "work/workInfo";
    }
}
