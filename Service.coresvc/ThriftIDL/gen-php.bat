@echo off

set GEN_SRC_PARENT_DIR="%~dp0\..\..\Clients\PHPClient\UserCenterClient"
set GEN_SRC_DIR="%GEN_SRC_PARENT_DIR%\gen-php"
if exist %GEN_SRC_DIR% rd /Q /S %GEN_SRC_DIR%

thrift.exe -version

thrift.exe -v -o %GEN_SRC_PARENT_DIR% --gen php idls/Error.thrift
thrift.exe -v -o %GEN_SRC_PARENT_DIR% --gen php idls/KEY.thrift
thrift.exe -v -o %GEN_SRC_PARENT_DIR% --gen php idls/areainfo_service.thrift
thrift.exe -v -o %GEN_SRC_PARENT_DIR% --gen php idls/userinfo_service.thrift
thrift.exe -v -o %GEN_SRC_PARENT_DIR% --gen php idls/school_service.thrift
thrift.exe -v -o %GEN_SRC_PARENT_DIR% --gen php idls/class_service.thrift
thrift.exe -v -o %GEN_SRC_PARENT_DIR% --gen php idls/common_service.thrift
thrift.exe -v -o %GEN_SRC_PARENT_DIR% --gen php idls/role_service.thrift
thrift.exe -v -o %GEN_SRC_PARENT_DIR% --gen php idls/statistics_service.thrift
thrift.exe -v -o %GEN_SRC_PARENT_DIR% --gen php idls/eduorg_service.thrift
thrift.exe -v -o %GEN_SRC_PARENT_DIR% --gen php idls/right_service.thrift
thrift.exe -v -o %GEN_SRC_PARENT_DIR% --gen php idls/access_service.thrift
:: entity 要放在最后
thrift.exe -v -o %GEN_SRC_PARENT_DIR% --gen php idls/entity.thrift

if "%1"=="skipPause" goto finally
 
@pause

:finally
