@echo off

set GEN_SRC_DIR="%~dp0..\api\src\main\java"

thrift.exe -version
thrift.exe -v -out %GEN_SRC_DIR% --gen java idls/api/Demo.thrift
thrift.exe -v -out %GEN_SRC_DIR% --gen java idls/api/woaker/Blog.thrift
thrift.exe -v -out %GEN_SRC_DIR% --gen java idls/api/woaker/Study.thrift
thrift.exe -v -out %GEN_SRC_DIR% --gen java idls/api/woaker/User.thrift
thrift.exe -v -out %GEN_SRC_DIR% --gen java idls/api/woaker/Work.thrift


 
if "%1"=="skipPause" goto finally
 
@pause

:finally
