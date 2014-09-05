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
				<form class="form-horizontal" role="form" action="photo!save.shtml" method="post">
					<input type="hidden" id="id" name="entity.id" value="${entity.id }"/>
					<input type="hidden" id="albumId" name="entity.albumId" value="${entity.albumId }"/>
					<input type="hidden" id="photoUri" name="entity.photoUri" value="${entity.photoUri }"/>
					<input type="hidden" id="thumbnailUri" name="entity.thumbnailUri" value="${entity.thumbnailUri }"/>
					<input type="hidden" id="thumbnailWidth" name="entity.thumbnailWidth" value="${entity.thumbnailWidth }"/>
					<input type="hidden" id="thumbnailWidth" name="entity.thumbnailHeight" value="${entity.thumbnailHeight }"/>
					<input type="hidden" id="sequence" name="entity.sequence" value="${entity.sequence }"/>
					
					<div class="form-group">
					    <label class="col-sm-2 control-label">相片名称</label>
					    <div class="col-sm-8">
					        <input class="form-control" id="title" name="entity.title" value="${entity.title}" required autofocus>
					    	<span class="help-block"></span>
					    </div>
				    </div>
					
					<div class="form-group">
					    <label class="col-sm-2 control-label">相片名称</label>
					    <div class="col-sm-8">
					        <a class="thumbnail">
					        	<img src="${entity.thumbnailUri }">
					        </a>
					    </div>
				    </div>
					
					<div class="form-group">
					    <label class="col-sm-2 control-label">相片描述</label>
					    <div class="col-sm-8">
					        <textarea class="form-control" rows="5" id="description" name="entity.description">${entity.description}</textarea>
					    	<span class="help-block"></span>
					    </div>
				    </div>
					
					<div class="form-group">
					    <label class="col-sm-2 control-label">相机信息</label>
					    <div class="col-sm-8">
					        <input class="form-control" id="cameraInfo" name="entity.cameraInfo" value="${entity.cameraInfo}">
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
<script>
$(function() {
	Menu.active(2);
});
</script>