<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="margin-top: 20px; margin-bottom: 20px;">
	<div>
		计划时间： <input size="12" type="text" value="" readonly class="planCreateDate" id="planCreateDate" />
	</div>
	<div>
		计划内容：
		<textarea style="width: 100%; height: 200px; resize: none; spellcheck: false;" id="planContent"></textarea>
		<input type="button" value="保存" id="saveWorkPlan" /> <input type="button" value="返回" onclick="window.location.href='../work/workIndex.do'" />
	</div>
</div>
