/**
 * <b>项目名：</b>星火燎原个人博客<br/>
 * <b>包   名：</b>com.spark.cloud.coresvc.utils.serializer<br/>
 * <b>文件名：</b>Serializ.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2016年2月1日 下午4:42:13<br/>
 * 
 */
package com.spark.cloud.coresvc.utils.serializer;

/**
 * 
 * <b>类   名：</b>Serializ<br/>
 * <b>类描述：</b>描述这个类的功能<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年2月1日 下午4:42:13<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年2月1日 下午4:42:13<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 *
 */
public interface Serializ
{
    byte[] serialize();
    void unserialize(byte[] ss);
}
