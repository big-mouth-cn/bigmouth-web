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
			<div class="panel-heading">新增/编辑博客</div>
			<div class="panel-body">
				<form class="form-horizontal" role="form" action="blog!save.shtml" method="post">
					<input type="hidden" id="id" name="entity.id" value="${entity.id }"/>
					
					<div class="form-group">
					    <label class="col-sm-2 control-label">博文名称</label>
					    <div class="col-sm-8">
					        <input class="form-control" id="title" name="entity.title" value="${entity.title}" required autofocus>
					    	<span class="help-block"></span>
					    </div>
				    </div>
					
					<div class="form-group">
					    <label class="col-sm-2 control-label">博文内容</label>
					    <div class="col-sm-8">
					        <textarea rows="20" class="form-control" id="content" name="entity.content">${entity.content }</textarea>
					    	<span class="help-block"></span>
					    </div>
				    </div>
					
					<div class="form-group">
					    <label class="col-sm-2 control-label">博文分类</label>
					    <div class="col-sm-8">
					    	<s:checkboxlist name="chkTags" list="allTags" listKey="id" listValue="name"></s:checkboxlist>
					    </div>
				    </div>
				    
				    <div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					    	<div class="checkbox">
					    		<label><input type="checkbox" id="isRecommend" name="isRecommend" value="true" <s:if test="entity.blogRecommend != null">checked="checked"</s:if>> 设置为推荐博文</label>
					    	</div>
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
<script src="${ctx }/js/kindeditor/kindeditor-min.js"></script>
<script src="${ctx }/js/manager/blog-input.js"></script>