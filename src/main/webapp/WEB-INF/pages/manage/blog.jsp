<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>

<%@ include file="/commons/metalibs.jsp"%>

</head>
<body>

	<%@ include file="/commons/manage/navbar.jsp"%>
	
	<div class="container">
	
		<div class="panel panel-default">
			<div class="panel-heading">博客管理</div>
			<div class="table-responsive">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>标题</th>
							<th>评论</th>
							<th>是否推荐</th>
							<th width="90"></th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="page.result">
							<tr>
								<td>${id }</td>
								<td>${title }</td>
								<td></td>
								<td>
									<s:if test="blogRecommend != null">是</s:if>
									<s:else>否</s:else>
								</td>
								<td>
								<a href="javascript:Table.edit('${id }', '/manage/blog!input.shtml?id=');">编辑</a>
								<a href="javascript:Table.remove('${id }', '/manage/blog!delete.shtml?id=');">删除</a>
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
			<div class="text-center"><s:property value="page.pageSource" escape="false" /></div>
			
			<div class="panel-footer">
				<a href="blog!input.shtml" class="btn btn-primary">新增</a>
			</div>
		</div>
		
	</div>
	
	<%@ include file="/commons/footer.jsp"%>
</body>
</html>
<script>
$(function() {
	Menu.active(1);
});
</script>