$(function() {
	workPlanInfo.initDate();
})

var workPlanInfo = {
	initDate : function() {
		$("#workPlanDate").datetimepicker({
			format : 'yyyy-mm-dd',
			language : 'zh-CN', // 加载日历语言包，可自定义
			weekStart : 0,
			todayBtn : 1,
			autoclose : true,
			todayHighlight : 1,
			startView : 2,
			minView : 2,
			forceParse : 0,
			pickerPosition: "bottom-left",
			endDate : new Date()
		});
	}
}