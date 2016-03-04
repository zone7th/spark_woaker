$(function () {
	//初始化日期空间
	index.initDate();
	

	$("#share_body").on('keyup', function() {
		wordLimit(jQuery(this), 140);
	});

	$("#share_body").on('keydown', function() {
		wordLimit(jQuery(this), 140);
	});	
    
})


var index = {
	
	initDate : function(){
		$('.form_date').datetimepicker({
			format : 'yyyy-mm-dd',
	        language: 'zh-CN', /* 加载日历语言包，可自定义 */
	        weekStart: 0,
	        todayBtn: 1,
	        autoclose: 0,
	        todayHighlight: 1,
	        startView: 2,
	        minView: 2,
	        forceParse: 0
	    });
	    $('.form_date').datetimepicker('show');
	},
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


