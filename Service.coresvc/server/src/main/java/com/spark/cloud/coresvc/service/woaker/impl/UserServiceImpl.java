/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.service.woaker.impl<br/>
 * <b>文件名：</b>UserServiceImpl.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年2月1日-上午9:46:37<br/>
 * 
 */
package com.spark.cloud.coresvc.service.woaker.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spark.cloud.coresvc.dao.woaker.UserDao;
import com.spark.cloud.coresvc.pojo.woaker.UserInfo;
import com.spark.cloud.coresvc.pojo.woaker.WorkInfo;
import com.spark.cloud.coresvc.service.woaker.UserService;

/**
 * <b>类   名：</b>UserServiceImpl<br/>
 * <b>类描述：</b>用户Service层接口实现<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年2月1日 上午9:46:37<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年2月1日 上午9:46:37<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
@Service
public class UserServiceImpl implements UserService
{
    
    @Autowired
    private UserDao userDao;
    
    @Override
    public List<UserInfo> getUserList(String userId, String keyWord, String startDate, String endDate, boolean isDelete, int page, int limit)
    {
        List<UserInfo> userList = userDao.getUserList(userId, keyWord, startDate, endDate, isDelete, page, limit);
        
        return userList;
    }
    
}
