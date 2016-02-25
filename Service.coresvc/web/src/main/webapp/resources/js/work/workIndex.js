$(function() {
	workIndex.initDate();
	workIndex.initBind();
})

var workIndex = {
	initBind : function(){
		$("#createWorkPlan").bind("click",function(){
			$.ajax({
				url : "createWorkInfo.ajax",
				data : {
					subjectcode : 0,
					phasecode : 0,
					areaCode : 0
				},
				dataType : "text",
				type : 'post',
				cache : false,
				success : function(data, textStatus, XMLHttpRequest) {
					try {
						$("#content_right").html(data);
					} catch (e) {
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					if (XMLHttpRequest.status == 500) {
					}
				}
			})
		})
	},
	
	initDate : function() {
		$("#startDate").datetimepicker({
			format : 'yyyy-mm-dd',
			language : 'zh-CN', // 加载日历语言包，可自定义
			weekStart : 0,
			todayBtn : 1,
			autoclose : true,
			todayHighlight : 1,
			startView : 2,
			minView : 2,
			forceParse : 0,
			endDate : new Date()

		});

		$("#endDate").datetimepicker({
			format : 'yyyy-mm-dd',
			language : 'zh-CN', // 加载日历语言包，可自定义
			weekStart : 0,
			todayBtn : 1,
			autoclose : true,
			todayHighlight : 1,
			startView : 2,
			minView : 2,
			forceParse : 0,
			endDate : new Date()
		});
		
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
	},
	
	getWorkInfo : function() {
		$.ajax({
			url : "getWorkInfo.ajax",
			data : {
				subjectcode : 0,
				phasecode : 0,
				areaCode : 0
			},
			dataType : "text",
			type : 'post',
			cache : false,
			success : function(data, textStatus, XMLHttpRequest) {
				try {
					$("#content_right").html(data);
				} catch (e) {
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				if (XMLHttpRequest.status == 500) {
				}
			}
		})
	},

	saveWorkInfo : function() {
		$.ajax({
			url : "getWorkInfo.ajax",
			data : {
				subjectcode : 0,
				phasecode : 0,
				areaCode : 0
			},
			dataType : "text",
			type : 'post',
			cache : false,
			success : function(data, textStatus, XMLHttpRequest) {
				try {
					$("#content_right").html(data);
				} catch (e) {
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				if (XMLHttpRequest.status == 500) {
				}
			}
		})
	}

};
