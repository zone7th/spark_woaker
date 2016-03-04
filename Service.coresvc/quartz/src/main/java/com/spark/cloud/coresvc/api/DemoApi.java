/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.api<br/>
 * <b>文件名：</b>DemoApiImpl.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年1月27日-下午5:06:56<br/>
 * 
 */
package com.spark.cloud.coresvc.api;

import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

import com.spark.cloud.coresvc.api.DemoApi;
import com.spark.cloud.coresvc.utils.CoresvcUtils;
import com.spark.cloud.coresvc.utils.ResultType;
import com.spark.cloud.coresvc.utils.logger.LogUtil;

/**
 * <b>类   名：</b>DemoApiImpl<br/>
 * <b>类描述：</b>描述这个类的功能<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年1月27日 下午5:06:56<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年1月27日 下午5:06:56<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 * 
 */
@Service
public interface DemoApi
{
    public String getIndex(String count);
}
