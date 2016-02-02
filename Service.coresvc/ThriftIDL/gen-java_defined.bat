@echo off

set GEN_SRC_DIR="%~dp0..\api\src\main\java"

thrift.exe -version
thrift.exe -v -out %GEN_SRC_DIR% --gen java idls/KEY.thrift
 
if "%1"=="skipPause" goto finally
 
@pause

:finally
