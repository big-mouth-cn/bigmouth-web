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
			<div class="panel-heading">相册管理</div>
			<div class="panel-body">
				<div class="row">
				<s:iterator value="list">
				  <div class="col-xs-6 col-md-3">
				  <div class="thumbnail">
				    <a href="${ctx }/manage/photo.shtml?albumId=${id }" class="thumbnail">
				      <img src="${tileImg }">
				    </a>
				    <div class="caption">
				    	<p>${name }</p>
				    	<p><a href="javascript:Table.edit('${id }', '/manage/album!input.shtml?id=');">编辑</a>
						<a href="javascript:Table.remove('${id }', '/manage/album!delete.shtml?id=');">删除</a>
						</p>
				    </div>
				    </div>
				  </div>
				</s:iterator>
				</div>
			</div>
			<div class="panel-footer">
				<a href="album!input.shtml" class="btn btn-primary">新增</a>
			</div>
		</div>
	</div>
	

	<%@ include file="/commons/footer.jsp"%>
</body>
</html>
<script>
$(function() {
	Menu.active(2);
});
</script>