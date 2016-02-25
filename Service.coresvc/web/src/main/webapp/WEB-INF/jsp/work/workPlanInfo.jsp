<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="<c:url value="/resources/js/work/workPlanInfo.js"/>"></script>
<div style="margin-top: 20px; margin-bottom: 20px;">
	计划时间：<div class="input-append date workPlanDate">
    <input size="16" type="text" value="" readonly>
    <span class="add-on"><i class="icon-th"></i></span>
</div>
	<textarea style="width: 100%; height: 200px; resize: none; spellcheck: false;" id="planContent"></textarea>
	<input type="button" value="保存" id="saveWorkInfo" /> <input type="button" value="返回" onclick="window.location.href='../work/workIndex.do'" />
</div>