include "../../dto/CommonDto.thrift"

namespace php com.spark.cloud.coresvc
namespace java com.spark.cloud.coresvc.api.woaker

//工作
service WorkApi
{
  //获取工作信息列表
  string getWorkIndex(1: string userId);
  //获取工作信息列表
  string getWorkLogList(1: string userId, 2: string keyWord, 3: string startDate, 4: string endDate, 5: bool isDelete, 6: i32 page, 7:i32 limit );
  //创建工作信息列表
  string createWorkInfo(1: string userId, 2:string title, 3:string planContent, 4:string logContent, 5:string planCreateDate, 6:string logCreateDate, 7:string createDate);
  //更新工作信息列表
  string updateWorkInfo(1: string id, 2: string userId, 3:string title, 4:string planContent, 5:string logContent, 6:string planCreateDate, 7:string logCreateDate, 8:string createDate);
}
