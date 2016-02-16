/**
 * Created by admin on 2016/1/26.
 */

//获取时间并格式化输出
function getformat(date){
    var year =  date.getFullYear();
    var month =  date.getMonth() + 1; //月份从0开始
    var day = date.getDate();
    if(month < 10){
        month = "0"+month;
    }
    if(day < 10){
        day = "0"+ day;
    }
    var date =year + "-"+ month+"-" + day;
    return date;
}

function getCurrentDate(){
    var curDate = new Date();
    var currentDate = new Date(curDate.getTime());  //获取当前日期
    return getformat(currentDate);
}

function getYesterday(){
    var curDate = new Date();
    var yesterday = new Date(curDate.getTime() - 24*60*60*1000);  //昨天的日期
    return getformat(yesterday);
}

function getLastMonthDate()
{
    var curDate = new Date();
    var lastMonthDate = new Date(curDate.getTime() - 30*24*60*60*1000);  //前一个月
    return getformat(lastMonthDate);
}

function getLastWeekDate()
{
    var curDate = new Date();
    var lastWeekDate = new Date(curDate.getTime() - 7*24*60*60*1000);  //前一个星期
    return getformat(lastWeekDate);
}
