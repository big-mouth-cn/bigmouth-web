<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>

	<title>${album.name } - 胡大嘴的小站</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="${album.description }">
	<meta name="keyworkds" content="胡大嘴,大嘴,Allen Hu,Big mouth,Big-mouth,Java,Memcached,ZooKeeper,MongoDB,博客,摄影,书法,烹饪">
	<meta name="author" content="Allen Hu, 胡大嘴">
	<%@ include file="/commons/metalibs.jsp"%>
<style type="text/css">
#photos {height: 600px; margin-bottom: 50px;}
.photo-title { margin-bottom: 0px; background: #000; box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.5);}
.galleria-container {box-shadow: 0px 0px 20px rgba(0, 0, 0, 0.5);}
</style>
</head>
<body>

	<%@ include file="/commons/navbar.jsp"%>
	
	<div id="crt" class="container margin-top-40">
		<form id="mainForm" action="${ctx }/p.shtml">
		<input type="hidden" id="albumId" name="albumId" value="${albumId }">
		<input type="hidden" id="pageNo" name="page.pageNo" value="${page.pageNo }">
		<input type="hidden" id="pageSize" name="page.pageSize" value="${page.pageSize }">
		
		<div class="row photos">
			<div class="col-md-12 photo-title">
				<h1>${album.name } <small>${albumCount } 张</small></h1>
				<p style="text-indent: 2em; color: #666;">${album.description }</p>
			</div>
		
			<div id="photos">
				<s:iterator value="page.result">
				<a href="${photoUri}">
		        	<img src="${thumbnailUri }" data-title="${title }" data-description="${description }">
		        </a>
				</s:iterator>
			</div>
		</div>
		</form>
	</div>
	<%@ include file="/commons/footer.jsp"%>
</body>
</html>
<script src="${ctx}/js/galleria/galleria-1.3.6.min.js"></script>
<script src="${ctx}/js/photo/photo.js"></script>
<script>
$(function() {
	Galleria.loadTheme(window.baseUrl + '/js/galleria/themes/classic/galleria.classic.js');
    Galleria.run('#photos');
});
</script>