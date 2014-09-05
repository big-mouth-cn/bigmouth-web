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
				<form class="form-horizontal" role="form" action="album!save.shtml" method="post">
					<input type="hidden" id="id" name="entity.id" value="${entity.id }"/>
					<input type="hidden" id="tileImg" name="entity.tileImg" value="${entity.tileImg }"/>
					
					<div class="form-group">
					    <label class="col-sm-2 control-label">相册名称</label>
					    <div class="col-sm-8">
					        <input class="form-control" id="name" name="entity.name" value="${entity.name}" required autofocus>
					    	<span class="help-block"></span>
					    </div>
				    </div>
					
					<div class="form-group">
					    <label class="col-sm-2 control-label">相册描述</label>
					    <div class="col-sm-8">
					        <textarea class="form-control" id="description" name="entity.description" rows="5">${entity.description}</textarea>
					    	<span class="help-block"></span>
					    </div>
				    </div>
				    
				    <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					      <button id="btnSave" type="submit" class="btn btn-primary">保存</button>
					      <button id="btnCancel" type="button" class="btn btn-link" onclick="history.back();">返回</button>
					    </div>
					</div>
				</form>
			</div>
		</div>
	</div>
	

	<%@ include file="/commons/footer.jsp"%>
</body>
</html>