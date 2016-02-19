include "../../dto/CommonDto.thrift"

namespace php com.spark.cloud.coresvc
namespace java com.spark.cloud.coresvc.api.woaker

// 博客接口
service BlogApi
{
	  
  //获取首页
  string getIndex();

  //获取博客	
  string getBlogList(1: string userId, 2: string blogId, 3: string keyWord, 4: string createType, 5: string createScope, 6: string customScope, 7: string startDate, 8: string endDate, 9: bool isPublic, 10: bool isDelete, 11: i32 page, 12:i32 limit );

  //获取我的Blog
  string getBlogIndex(1: string userId, 2: string blogId, 3: string keyWord, 4: string createType, 5: string createScope, 6: string customScope, 7: string startDate, 8: string endDate, 9: bool isPublic, 10: bool isDelete, 11: i32 page, 12:i32 limit );
  
}
