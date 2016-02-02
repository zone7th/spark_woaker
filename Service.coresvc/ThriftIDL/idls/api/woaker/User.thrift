include "../../dto/CommonDto.thrift"

namespace php com.spark.cloud.coresvc
namespace java com.spark.cloud.coresvc.api.woaker

//用户信息
service UserApi
{	
	//获取用户列表
	string getUserList(1: string userId, 2: string keyWord, 3: string startDate, 4: string endDate, 5: bool isDelete, 6: i32 page, 7:i32 limit )  
}
