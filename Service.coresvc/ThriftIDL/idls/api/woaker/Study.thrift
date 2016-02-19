include "../../dto/CommonDto.thrift"

namespace php com.spark.cloud.coresvc
namespace java com.spark.cloud.coresvc.api.woaker

//学习计划
service StudyApi
{
  //获取学习计划首页
  string getStudyIndex(1: string userId, 2: string keyWord, 3: string startDate, 4: string endDate, 5: bool isDelete, 6: i32 page, 7:i32 limit );
  //获取学习计划列表
  string getStudyPlanList(1: string userId, 2: string keyWord, 3: string startDate, 4: string endDate, 5: bool isDelete, 6: i32 page, 7:i32 limit );
}
