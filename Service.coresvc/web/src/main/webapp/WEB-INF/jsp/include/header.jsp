<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix= "c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>屌丝之路</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/include/main.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/include/header.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/js/bootstrap/css/bootstrap.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/js/bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css"/>">
    
    <script src="<c:url value="/resources/js/jquery/jquery-1.11.3.min.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap-datetimepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"/>"></script>
	<script src="<c:url value="/resources/js/index/index.js"/>"></script>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <div class="navbar-brand">
                <svg viewBox="0 0 960 300">
                    <symbol id="s-text">
                        <text text-anchor="middle" x="50%" y="80%">蜗壳</text>
                    </symbol>

                    <g class="g-ants">
                        <use xlink:href="#s-text" class="text-copy"></use>
                        <use xlink:href="#s-text" class="text-copy"></use>
                        <use xlink:href="#s-text" class="text-copy"></use>
                        <use xlink:href="#s-text" class="text-copy"></use>
                        <use xlink:href="#s-text" class="text-copy"></use>
                    </g>
                </svg>
            </div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li <c:if test="${current  == '01'}">class='active'</c:if>><a href="<c:url value='../index/index.do'/>">首页</a></li>
                <li <c:if test="${current  == '02'}">class='active'</c:if>><a href="<c:url value='../blog/blogIndex.do'/>">我的博客</a></li>
                <li <c:if test="${current  == '03'}">class='active'</c:if>><a href="<c:url value='../work/workIndex.do'/>">工作日志</a></li>
                <li <c:if test="${current  == '04'}">class='active'</c:if>><a href="<c:url value='../study/studyIndex.do'/>">学习计划</a></li>
                <li class="dropdown">
                    <a href="<c:url value='../index/index.do'/>" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">更多<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">更多1</a></li>
                        <li><a href="#">更多2</a></li>
                        <li><a href="#">更多3</a></li>
                        <li role="separator" class="divider"></li>
                        <li class="dropdown-header">Nav header</li>
                        <li><a href="#">Separated link</a></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="../navbar/">登录</a></li>
                <li><a href="../navbar/">注册</a></li>
                <li><a href="../navbar/">你好！</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">设置</a>
                    <ul class="dropdown-menu">
                        <li><a href="#">我的消息</a></li>
                        <li><a href="#">我的账号</a></li>
                        <li><a href="#">关于</a></li>
                        <li><a href="#">退出</a></li>
                    </ul>
                </li>
                <li><a href="./">关于<span class="sr-only">(current)</span></a></li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</nav>
