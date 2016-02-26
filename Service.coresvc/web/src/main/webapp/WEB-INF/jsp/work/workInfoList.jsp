<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach var="workInfo" items="${workInfoList }" varStatus="status">
	<tr>
	<td>${status.count}</td>
	<td><a href="javascript:;" onclick="workIndex.getWorkInfo(${workInfo.id})">${workInfo.plan_create_date}</a></td>
	<td>${workInfo.user_id}</td>
	<td>${workInfo.plan_content}</td>
	<td>${workInfo.log_content}</td>
	<td>按时填写</td>
</tr>
</c:forEach>
