$(function () {
	//初始化日期空间
	index.initDate();
    
})


var index = {
	
	initDate : function(){
		$('.form_date').datetimepicker({
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


