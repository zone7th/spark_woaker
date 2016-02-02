@echo off

set GEN_SRC_DIR="%~dp0\gen-java"

if exist %GEN_SRC_DIR% rd /Q /S %GEN_SRC_DIR%

thrift.exe -version
thrift.exe -v --gen java idls/Error.thrift
thrift.exe -v --gen java idls/KEY.thrift
thrift.exe -v --gen java idls/entity.thrift
thrift.exe -v --gen java idls/areainfo_service.thrift
thrift.exe -v --gen java idls/userinfo_service.thrift
thrift.exe -v --gen java idls/school_service.thrift
thrift.exe -v --gen java idls/class_service.thrift
thrift.exe -v --gen java idls/role_service.thrift
thrift.exe -v --gen java idls/common_service.thrift
thrift.exe -v --gen java idls/statistics_service.thrift
thrift.exe -v --gen java idls/eduorg_service.thrift
thrift.exe -v --gen java idls/right_service.thrift
thrift.exe -v --gen java idls/access_service.thrift


if "%1"=="skipPause" goto finally
 
@pause

:finally
