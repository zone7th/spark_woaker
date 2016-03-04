/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.service<br/>
 * <b>文件名：</b>TestSubList.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年3月3日-下午6:55:54<br/>
 * 
 */
package com.spark.cloud.coresvc.service;

import java.util.ArrayList;
import java.util.List;

/**
 * <b>类 名：</b>TestSubList<br/>
 * <b>类描述：</b>描述这个类的功能<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年3月3日 下午6:55:54<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年3月3日 下午6:55:54<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
public class TestSubList
{
    public static void main(final String[] args)
    {
        List<Object> lists = new ArrayList<Object>();
        List<Object> tempLists = new ArrayList<Object>();
        
        lists.add("1");
        lists.add("2");
        lists.add("3");
        lists.add("4");

        // List<Object> tempList = lists.subList(2, lists.size());
        tempLists.addAll(lists.subList(0, lists.size()));

/*        tempList.add("6");

        System.out.println(tempList); // 1

        System.out.println(lists); // 2

        tempLists.addAll(resList.subList(0, count));
        taskExecutor.execute(new CSSPThread(csspService, tempList, resourceVoiceService));
        resList.removeAll(tempList);*/
    }
}
