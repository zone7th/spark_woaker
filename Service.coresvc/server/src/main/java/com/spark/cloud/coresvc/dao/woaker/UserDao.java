/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.dao.woaker<br/>
 * <b>文件名：</b>UserDao.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年2月1日-上午9:37:08<br/>
 * 
 */
package com.spark.cloud.coresvc.dao.woaker;

import java.util.List;

import com.spark.cloud.coresvc.pojo.woaker.UserInfo;

/**
 * <b>类   名：</b>UserDao<br/>
 * <b>类描述：</b>用户Dao层接口<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年2月1日 上午9:37:08<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年2月1日 上午9:37:08<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
public interface UserDao
{
    /**
     * 
     * getUserList(获取用户列表)
     * 
     * @param userId    用户ID
     * @param keyWord   关键字
     * @param startDate 开始日期
     * @param endDate   结束日期
     * @param isDelete  是否删除
     * @param page      页码
     * @param limit     分页大小
     * @return 
     * @exception 
     * @since 1.0
     * @author rlliu
     */
    public List<UserInfo> getUserList(String userId, String keyWord, String startDate, String endDate, boolean isDelete, int page, int limit);
}
