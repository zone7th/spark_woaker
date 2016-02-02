/**
 * <b>项目名：</b>基线产品<br/>
 * <b>包   名：</b>com.iflytek.epdcloud.epsp.utils<br/>
 * <b>文件名：</b>ResultType.java<br/>
 * <b>版本信息：</b>1.0<br/>
 * <b>日期：</b>2015-8-11-下午3:44:12<br/>
 * 
 */
package com.spark.cloud.coresvc.utils;

/**
 * 
 * <b>类   名：</b>ResultType<br/>
 * <b>类描述：</b>api接口实现类中返回类型枚举组织接口，可以根据应用各自定制自己的枚举类<br/>
 * <b>创建人：</b>rlliu<br/>
 * <b>创建时间：</b>2016年2月1日 下午4:04:55<br/>
 * <b>修改人：</b>rlliu<br/>
 * <b>修改时间：</b>2016年2月1日 下午4:04:55<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 *
 */
public interface ResultType {
	/**
	 * 
	 * getResultCode(取得返回结果值)
	 * 
	 * @return 返回结果值
	 * @since  1.0
	 * @author rlliu
	 */
	public int getResultCode();
	
	/**
	 * 
	 * getResultMsg(取得返回结果消息内容)
	 * 
	 * @return 返回结果消息内容
	 * @since  1.0
	 * @author rlliu
	 */
	public String getResultMsg();
	
	/**
	 * 
	 * <b>类   名：</b>SimpleResultType<br/>
	 * <b>类描述：</b>简单的返回结果定义（0:成功；-1:操作失败）<br/>
	 * <b>创建人：</b>rlliu<br/>
	 * <b>创建时间：</b>2016年2月1日 下午4:04:33<br/>
	 * <b>修改人：</b>rlliu<br/>
	 * <b>修改时间：</b>2016年2月1日 下午4:04:33<br/>
	 * <b>修改备注：</b><br/>
	 *
	 * @version 1.0<br/>
	 *
	 */
	public static enum SimpleResultType implements ResultType {
		/**
		 * 成功
		 */
		SUCCESS(0, "成功"),
		/**
		 * 操作失败
		 */
		OPERATE_ERROR(-1, "操作失败");
		
		// 返回结果值
		private int resultCode;
		// 返回结果消息内容
		private String resultMsg;
		
		/**
		 * 
		 * 创建一个新的实例 SimpleResultType.
		 *
		 * @param resultCode 返回结果值
		 * @param resultMsg 返回结果消息内容
		 */
		private SimpleResultType(int resultCode, String resultMsg) {
			this.resultCode = resultCode;
			this.resultMsg = resultMsg;
		}
		
		/* (non-Javadoc)
		 * @see com.iflytek.epdcloud.epsp.utils.ResultType#getResultCode()
		 */
		@Override
		public int getResultCode() {
			return this.resultCode;
		}
		
		/* (non-Javadoc)
		 * @see com.iflytek.epdcloud.epsp.utils.ResultType#getResultMsg()
		 */
		@Override
		public String getResultMsg() {
			return this.resultMsg;
		}
	}
}
