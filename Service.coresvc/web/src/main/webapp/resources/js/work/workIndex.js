$(function() {
	workIndex.initDate();
	workIndex.initBind();
})

var workIndex = {
	initBind : function() {
		$("#createWorkPlan").bind("click", function() {
			workIndex.createWorkPlan();
		})
		
		$("#updateWorkInfo").bind("click", function() {
			workIndex.updateWorkInfo();
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
	},
	
	createWorkPlan : function(){
		$.ajax({
			url : "createWorkPlan.ajax",
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
					// 初始化绑定时间
					workPlanInfo.initDate();
					workPlanInfo.initBind();
				} catch (e) {
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				if (XMLHttpRequest.status == 500) {
				}
			}
		})
	},

	getWorkInfo : function(id) {
		$.ajax({
			url : "getWorkInfo.ajax",
			data : {
				"id" : id
			},
			dataType : "text",
			type : 'post',
			cache : false,
			success : function(data, textStatus, XMLHttpRequest) {
				try {
					$("#content_right").html(data);
					workIndex.initBind();
				} catch (e) {
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				if (XMLHttpRequest.status == 500) {
				}
			}
		})
	},

	updateWorkInfo : function() {
		$.ajax({
			url : "updateWorkInfo.ajax",
			data : {
				"id" : $("#workIndoId").val(),
				"planContent" : $("#planContent").val(),
				"planCreateDate" : $("#planCreateDate").val(),
				"logContent" : $("#logContent").val(),
				"logCreateDate" : $("#logCreateDate").val(),
				"createDate" : $("#createDate").val(),
				"title" : $("#title").val(),
				"userId" : $("#userId").val()
			},
			dataType : "json",
			type : 'post',
			cache : false,
			success : function(data, textStatus, XMLHttpRequest) {
				try {
					//更新之后的结果返回
					if (data.success > 0) {
						alert("日志更新成功");
						window.location.href = "../work/workIndex.do";
					} else {
							alert("日志更新失败");
					}
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

var workPlanInfo = {
	initBind : function() {
		$("#saveWorkPlan").bind("click", function() {
			workPlanInfo.saveWorkPlan();
		})
	},

	initDate : function() {
		$("#planCreateDate").datetimepicker({
			format : 'yyyy-mm-dd',
			language : 'zh-CN', // 加载日历语言包，可自定义
			weekStart : 0,
//			todayBtn : 1,
			autoclose : true,
			todayHighlight : 1,
			startView : 2,
			minView : 2,
			forceParse : 0,
			startDate : new Date()
		});

	},

	saveWorkPlan : function() {
		$.ajax({
			url : "saveWorkPlan.ajax",
			data : {
				planCreateDate : $.trim($("#planCreateDate").val()),
				planContent : $.trim($("#planContent").val()),
			},
			dataType : "json",
			type : 'post',
			cache : false,
			success : function(data, textStatus, XMLHttpRequest) {
				try {
					// 返回提示信息
					if (data.success > 0) {
						alert("计划保存成功");
						window.location.href = "../work/workIndex.do";
					} else {
						if (data.exist == 1) {
							alert("计划已存在,创建失败！");
						} else {
							alert("计划创建失败！");
						}
					}

				} catch (e) {
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				if (XMLHttpRequest.status == 500) {
				}
			}
		})
	}

}
