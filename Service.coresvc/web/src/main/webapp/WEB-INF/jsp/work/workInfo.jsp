<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="margin-top:20px; margin-bottom:20px;">
	今日计划：
	<textarea style="width:100%; height:200px;resize: none;spellcheck:false;" id="planContent"></textarea>
	今日日志：
	<textarea style="width:100%; height:200px;resize: none;spellcheck:false;" id="logContent"></textarea>	
	<input type="button" value="保存" id="saveWorkInfo"/>
	<input type="button" value="返回" onclick="window.location.href='../work/workIndex.do'"/>
</div>