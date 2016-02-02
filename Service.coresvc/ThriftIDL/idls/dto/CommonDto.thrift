namespace php epdcloud.ercsvc.dto
namespace java com.pandora.sparkfamily.base.dto

/**
 * TObject
 */
union TObject {
	1: bool boolVal
	2: i32 intVal
	3: i64 longVal
	4: string strVal
}

/**
 * Page Dto
 */
struct PageDto
{
	1: optional i32 limit,
	2: optional i32 skip,
	3: optional bool needDataList,
	4: optional bool needTotal
}