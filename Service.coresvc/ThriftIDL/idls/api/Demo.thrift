include "../dto/CommonDto.thrift"

namespace php com.spark.cloud.coresvc
namespace java com.spark.cloud.coresvc.api

service DemoApi
{
  string getIndex(1:string count);
}
