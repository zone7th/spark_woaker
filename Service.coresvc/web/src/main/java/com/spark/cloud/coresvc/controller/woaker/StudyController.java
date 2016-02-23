/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.controller.woaker<br/>
 * <b>文件名：</b>StudyController.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年2月23日-下午7:03:30<br/>
 * 
 */
package com.spark.cloud.coresvc.controller.woaker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spark.cloud.coresvc.constants.WoakerConstants;

/**
 * <b>类   名：</b>StudyController<br/>
 * <b>类描述：</b>学习计划控制层<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年2月23日 下午7:03:30<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年2月23日 下午7:03:30<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
@Controller
@RequestMapping("study")
public class StudyController
{   
    @RequestMapping("/studyIndex")
    public String studyIndex(Model model, String userId){
        model.addAttribute("current",WoakerConstants.STUDY_INDEX);
        //加载个人学习计划
        return "study/studyIndex";
    }
}
