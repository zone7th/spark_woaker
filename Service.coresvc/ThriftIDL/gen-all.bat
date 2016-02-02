@echo off

call gen-php.bat skipPause

call gen-java_app.bat skipPause

call gen-java_common.bat skipPause
 
@pause
