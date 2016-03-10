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

function getTomorrow(){
    var curDate = new Date();
    var tomorrow = new Date(curDate.getTime() + 24*60*60*1000);  //昨天的日期
    return getformat(tomorrow);
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

/**
 * 限制字数
 */
function bindWordLimit(obj){
	$("#obj").on('keyup', function() {
		wordLimit(jQuery(this), 140);
	});

	$("#obj").on('keydown', function() {
		wordLimit(jQuery(this), 140);
	});	
}

/**
 * 限制输入字数
 *
 * @param jQuery_obj
 *            jquery对象
 * @param length
 *            输入框限制的长度
 */
function wordLimit(jQuery_obj, length) {
	var str = jQuery.trim(jQuery_obj.val());
	// 字符串中英文等字符的总长度
	var sum_english = 0;
	// 字符串中汉字等字符的总长度
	var sum_chinese = 0;
	// 在页面中输入的最后一个字符在字符串中的实际位置
	var cursor = 0;
	for (var i = 0; i < str.length; i++) {
		// 英文字母等数字的长度为0.5,汉字等字符的长度为1
		if ((str.charCodeAt(i) >= 0) && (str.charCodeAt(i) <= 255)) {
			sum_english = sum_english + 0.5;
		} else {
			sum_chinese = sum_chinese + 1;
		}
		if ((sum_chinese + sum_english) > length && cursor == 0) {
			cursor = i;
		}
	}
	if (cursor == 0) {
		// 在页面上显示的字符串的总长度(向上取整)
		var sum = sum_chinese + Math.ceil(sum_english);
		// 改变显示的长度
		jQuery_obj.next().find("b").text(sum);
	}
	// 改变显示的字符数的字体颜色
	if ((sum_chinese + sum_english) >= length) {
		jQuery_obj.next().find("b").css("color", "red");
	} else {
		jQuery_obj.next().find("b").css("color", "#333");
	}
	// 截取字符串
	if (cursor != 0) {
		jQuery_obj.val(str.substring(0, cursor));
	}
}
