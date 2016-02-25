<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/jsp/include/header.jsp"%>
<script src="<c:url value="/resources/js/work/workIndex.js"/>"></script>
<!--content-->
<div class="content_body">
	<div class="container-fluid content_header">
		<div class="row-fluid">
			<div class="col-xs-3 col-xs-offset-1 content_left">
				
				<div class="content_left_container">
					<div class="content_left_inner">
						<div class="content_left_line">
							<a>日期时间</a>
						</div>
						<div class="input-group date form_date col-md-5 date_position" data-date="" data-date-format="" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd"></div>
					</div>
				</div>
				
				<div class="content_left_container">
					<div class="content_left_inner">
						<a class="content_left_line" style="cursor: pointer;" id="createWorkPlan">创建计划</a>
					</div>
				</div>
				
				<div class="content_left_container">
					<div class="content_left_inner">
						<a class="content_left_line">今日计划</a>
						<ul>
							<li><a href="javascript:;">前端开发</a></li>
							<li><a href="javascript:;">后端开发</a></li>
							<li><a href="javascript:;">WEB</a></li>
							<li><a href="javascript:;">嵌入式</a></li>
							<li><a href="javascript:;">FPGA</a></li>
							<li><a href="javascript:;">游戏开发</a></li>
							<li><a href="javascript:;">服务运营</a></li>
						</ul>
					</div>
				</div>

				<div class="content_left_container">
					<div class="content_left_inner">
						<a class="content_left_line">明日计划</a>
						<ul>
							<li><a href="javascript:;">前端开发</a></li>
							<li><a href="javascript:;">后端开发</a></li>
							<li><a href="javascript:;">WEB</a></li>
							<li><a href="javascript:;">嵌入式</a></li>
							<li><a href="javascript:;">FPGA</a></li>
							<li><a href="javascript:;">游戏开发</a></li>
							<li><a href="javascript:;">服务运营</a></li>
						</ul>
					</div>
				</div>

				<div class="content_left_container">
					<div class="content_left_inner">
						<a class="content_left_line">昨天日志</a>
						<ul>
							<li><a href="javascript:;">前端开发</a></li>
							<li><a href="javascript:;">后端开发</a></li>
							<li><a href="javascript:;">WEB</a></li>
							<li><a href="javascript:;">嵌入式</a></li>
							<li><a href="javascript:;">FPGA</a></li>
							<li><a href="javascript:;">游戏开发</a></li>
							<li><a href="javascript:;">服务运营</a></li>
						</ul>
					</div>
				</div>

			</div>
			<div class="col-xs-7 content_right" id="content_right">
				<div style="margin-top: 20px;">
					<!-- 查询 -->
					日期： <input size="12" type="text" value="" readonly class="startDate" id="startDate">--<input size="12" type="text" value="" readonly class="endDate" id="endDate">
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 
					日报状态：
					<select>
						<option value="00">全部</option>
						<option value="01">按时填写</option>
						<option value="02">补填</option>
						<option value="03">未填写</option>
					</select>
					<div style="float: right;">
						<input class="" style="" type="text" value=""> <a style="margin-left: 5px; text-decoration: none;" href="#">查询</a>
					</div>
				</div>
				<!-- 列表 -->
				<div class="col-xs-12 workInfoTable" id="workInfoTable" style="margin-top: 10px;">
					<table>
						<thead>
							<tr>
								<td width="10%">序号</td>
								<td width="15%">日报日期</td>
								<td width="15%">填写人</td>
								<td width="20%">计划</td>
								<td width="20%">日志</td>
								<td width="20%">日报状态</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td><a href="javascript:;" onclick="workIndex.getWorkInfo()">2016-2-16</a></td>
								<td>威兹曼</td>
								<td>编码代码</td>
								<td>完成工作</td>
								<td>按时填写</td>
							</tr>
							<tr>
								<td>1</td>
								<td><a href="#">2016-2-16</a></td>
								<td>威兹曼</td>
								<td>编码代码</td>
								<td>完成工作</td>
								<td>按时填写</td>
							</tr>
							<tr>
								<td>1</td>
								<td><a href="#">2016-2-16</a></td>
								<td>威兹曼</td>
								<td>编码代码</td>
								<td>完成工作</td>
								<td>按时填写</td>
							</tr>
							<tr>
								<td>1</td>
								<td><a href="#">2016-2-16</a></td>
								<td>威兹曼</td>
								<td>编码代码</td>
								<td>完成工作</td>
								<td>按时填写</td>
							</tr>
							<tr>
								<td>1</td>
								<td><a href="#">2016-2-16</a></td>
								<td>威兹曼</td>
								<td>编码代码</td>
								<td>完成工作</td>
								<td>按时填写</td>
							</tr>
							<tr>
								<td>1</td>
								<td><a href="#">2016-2-16</a></td>
								<td>威兹曼</td>
								<td>编码代码</td>
								<td>完成工作</td>
								<td>按时填写</td>
							</tr>
							<tr>
								<td>1</td>
								<td><a href="#">2016-2-16</a></td>
								<td>威兹曼</td>
								<td>编码代码</td>
								<td>完成工作</td>
								<td>按时填写</td>
							</tr>
							<tr>
								<td>1</td>
								<td><a href="#">2016-2-16</a></td>
								<td>威兹曼</td>
								<td>编码代码</td>
								<td>完成工作</td>
								<td>按时填写</td>
							</tr>
							<tr>
								<td>1</td>
								<td><a href="#">2016-2-16</a></td>
								<td>威兹曼</td>
								<td>编码代码</td>
								<td>完成工作</td>
								<td>按时填写</td>
							</tr>
							<tr>
								<td>1</td>
								<td><a href="#">2016-2-16</a></td>
								<td>威兹曼</td>
								<td>编码代码</td>
								<td>完成工作</td>
								<td>按时填写</td>
							</tr>
							<tr>
								<td>1</td>
								<td><a href="#">2016-2-16</a></td>
								<td>威兹曼</td>
								<td>编码代码</td>
								<td>完成工作</td>
								<td>按时填写</td>
							</tr>
							<tr>
								<td>1</td>
								<td><a href="#">2016-2-16</a></td>
								<td>威兹曼</td>
								<td>编码代码</td>
								<td>完成工作</td>
								<td>按时填写</td>
							</tr>
							<tr>
								<td>1</td>
								<td><a href="#">2016-2-16</a></td>
								<td>威兹曼</td>
								<td>编码代码</td>
								<td>完成工作</td>
								<td>按时填写</td>
							</tr>
							<tr>
								<td>1</td>
								<td><a href="#">2016-2-16</a></td>
								<td>威兹曼</td>
								<td>编码代码</td>
								<td>完成工作</td>
								<td>按时填写</td>
							</tr>
							<tr>
								<td>1</td>
								<td><a href="#">2016-2-16</a></td>
								<td>威兹曼</td>
								<td>编码代码</td>
								<td>完成工作</td>
								<td>按时填写</td>
							</tr>
							<tr>
								<td>1</td>
								<td><a href="#">2016-2-16</a></td>
								<td>威兹曼</td>
								<td>编码代码</td>
								<td>完成工作</td>
								<td>按时填写</td>
							</tr>
							<tr>
								<td>1</td>
								<td><a href="#">2016-2-16</a></td>
								<td>威兹曼</td>
								<td>编码代码</td>
								<td>完成工作</td>
								<td>按时填写</td>
							</tr>
							<tr>
								<td>1</td>
								<td><a href="#">2016-2-16</a></td>
								<td>威兹曼</td>
								<td>编码代码</td>
								<td>完成工作</td>
								<td>按时填写</td>
							</tr>
							<tr>
								<td>1</td>
								<td><a href="#">2016-2-16</a></td>
								<td>威兹曼</td>
								<td>编码代码</td>
								<td>完成工作</td>
								<td>按时填写</td>
							</tr>
							<tr>
								<td>1</td>
								<td><a href="#">2016-2-16</a></td>
								<td>威兹曼</td>
								<td>编码代码</td>
								<td>完成工作</td>
								<td>按时填写</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/jsp/include/footer.jsp"%>