<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="margin-top: 20px; margin-bottom: 20px;">
	<div>
		<input type="hidden" value="${workInfo.id }" id="workIndoId">
		<input type="hidden" value="${workInfo.plan_create_date }" id="planCreateDate">
		<input type="hidden" value="${workInfo.log_create_date }" id="logCreateDate">
		<input type="hidden" value="${workInfo.create_date }" id="createDate">
		<input type="hidden" value="${workInfo.title }" id="title">
		<input type="hidden" value="${workInfo.user_id }" id="userId">
		今日计划：
		<textarea style="width: 100%; height: 200px; resize: none; spellcheck: false;" id="planContent"> ${workInfo.plan_content }</textarea><label><b>0</b>/140</label>
		今日日志：
		<textarea style="width: 100%; height: 200px; resize: none; spellcheck: false;" id="logContent">${workInfo.log_content }</textarea><label><b>0</b>/140</label>
		<input type="button" value="保存" id="updateWorkInfo" /> <input type="button" value="返回" onclick="window.location.href='../work/workIndex.do'" />
	</div>
</div>