<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>

<%@ include file="/commons/metalibs.jsp"%>

<link href="${ctx }/js/uploadify/uploadify.css" rel="stylesheet">
<script src="${ctx }/js/uploadify/jquery.tmpl.min.js"></script>
<script src="${ctx }/js/uploadify/jquery.uploadify.js"></script>

<style type="text/css">
.photo a {overflow: hidden;}
.thumbnail {padding: 0px; margin: 4px;}
.thumbnail > img, .thumbnail a > img {max-width: none; }
.thumbnail:hover,
.thumbnail:focus,
.thumbnail.active {
  border-color: #428bca;
}
a.thumbnail:hover,
a.thumbnail:focus,
a.thumbnail.active {
  border-color: transparent;
}
#btnSelect {position: relative;}
#SWFUpload_0 {position: absolute; top: 0;left: 0;}
#btnSelect-button {position: absolute;left: 0;top: 0;font-family: 微软雅黑;font-size: 14px;}
</style>
</head>
<body>

	<%@ include file="/commons/manage/navbar.jsp"%>
	
	<div class="container margin-top-40">
				<div>
					<button id="btnSelect" class="btn btn-primary">选择相片</button>
					<button id="btnStartUpload" class="btn btn-primary">开始上传</button>
				</div>
				<div id="upload-queue"></div>
	
				<input type="hidden" id="albumId" value="${albumId }">
			
				<div class="row photos">
					<div class="col-md-12 photo-title">
						<h1>${album.name } <small><s:property value="page.result.size"/> 张</small></h1>
					</div>
					
					<s:if test="page.result.size == 0">
					<p class="text-center">暂时还没有照片，赶快上传吧~</p>
					</s:if>
					<s:iterator value="page.result">
					<div class="photo col-xs-4 col-sm-3 col-md-2" data-primary="${id }">
						<a class="thumbnail">
					      <img src="${thumbnailUri }" data-width="${thumbnailWidth }" data-height="${thumbnailHeight }">
					      <span>${title }</span>
					      <p>
						  <a class="pageCover" href="${ctx }/manage/photo!setPageCover.shtml?tileImg=${thumbnailUri}&albumId=${albumId}">设为封面</a>
					      <a class="edit" href="javascript:Table.edit('${id }', '/manage/photo!input.shtml?id=');">编辑</a>
						  <a class="delete" data-primary="${id }" href="javascript:;">删除</a>
						  </p>
					    </a>
					</div>
					</s:iterator>
				</div>
				<!-- 
				<div class="row">
				<s:iterator value="page.result">
				  <div class="photo col-xs-3" data-primary="${id }">
				  	<div class="thumbnail">
					    <a class="thumbnail">
					      <img src="${thumbnailUri }" data-width="${thumbnailWidth }" data-height="${thumbnailHeight }">
					    </a>
					    <div class="caption">
					    	<p>${title }</p>
					    	<p><a class="edit" href="javascript:Table.edit('${id }', '/manage/photo!input.shtml?id=');">编辑</a>
							<a class="delete" data-primary="${id }" href="javascript:;">删除</a>
							</p>
					    </div>
				    </div>
				  </div>
				</s:iterator>
				</div>
				 -->
	</div>
	

	<%@ include file="/commons/footer.jsp"%>
</body>
</html>
<script src="${ctx }/js/manager/photo.js"></script>
<script type="text/javascript">
var jsessionid = "${jsessionid}";
</script>