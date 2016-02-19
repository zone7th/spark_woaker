include "../../dto/CommonDto.thrift"

namespace php com.spark.cloud.coresvc
namespace java com.spark.cloud.coresvc.api.woaker

//工作
service WorkApi
{
  //获取工作日志列表
  string getWorkIndex(1: string userId, 2: string keyWord, 3: string startDate, 4: string endDate, 5: bool isDelete, 6: i32 page, 7:i32 limit );
  //获取工作日志列表
  string getWorkLogList(1: string userId, 2: string keyWord, 3: string startDate, 4: string endDate, 5: bool isDelete, 6: i32 page, 7:i32 limit );
}
