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
</head>
<body>

	<%@ include file="/commons/navbar.jsp"%>
	
	<div class="container margin-top-40">
		<div class="row photo">
			<div class="col-md-12 photo-title">
				<h1>${album.name } <small>共 ${albumCount } 张 / 第 ${currentIndex+1 } 张</small></h1>
			</div>
		
			<div class="col-md-12">
				<div class="carousel slide" data-ride="carousel">
				  <div class="carousel-inner">
				    <div class="item active">
				      <div class="photo-div">
					      <img src="${photo.photoUri }">
				      </div>
				      <div class="carousel-caption">
				        <h1>${photo.title }</h1>
	              		<p>${photo.description }</p>
				      </div>
				    </div>
				  </div>
				  <s:if test="pre != null">
				  <a class="left carousel-control" href="${ctx }/photo/${album.id}/${pre.id}.html" data-slide="prev">
				    <span class="glyphicon glyphicon-chevron-left"></span>
				  </a>
				  </s:if>
				  <s:if test="next != null">
				  <a class="right carousel-control" href="${ctx }/photo/${album.id}/${next.id}.html" data-slide="next">
				    <span class="glyphicon glyphicon-chevron-right"></span>
				  </a>
				  </s:if>
				</div>
			</div>
		</div>
	</div>
	

	<%@ include file="/commons/footer.jsp"%>
</body>
</html>
<script src="${ctx}/js/photo/photo.js"></script>