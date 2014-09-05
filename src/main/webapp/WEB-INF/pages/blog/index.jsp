<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>

	<s:if test="tagName == null">
	<title>博客 - 胡大嘴的小站</title>
	</s:if>
	<s:else>
	<title>${tagName } - 胡大嘴的小站</title>
	</s:else>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="胡大嘴的小站（www.big-mouth.cn）是一个个人综合网站，包含各类技术文章、摄影等方面内容。">
	<meta name="keyworkds" content="胡大嘴,大嘴,Allen Hu,Big mouth,Big-mouth">
	<meta name="author" content="Allen Hu, 胡大嘴">
	<%@ include file="/commons/metalibs.jsp"%>

<link type="text/css" rel="stylesheet" href="${ctx }/js/syntax/styles/shCoreEclipse.css"/>
<script type="text/javascript" src="${ctx }/js/syntax/scripts/shCore.js"></script>

<style type="text/css">
.blog-item .content {
margin-bottom: 20px;
}
</style>
</head>
<body>

	<%@ include file="/commons/navbar.jsp"%>
	
	<div class="container">
		<div class="row">
		
			<!-- Top -->
			<!-- Tags -->
			<div class="col-md-12">
				<div class="margin-top-60">
					<div class="clearfix">
						<ul class="tags">
						<s:iterator value="allTags">
							<li><a href="${ctx }/tag/${name}" <s:if test="tagName == name">class="active"</s:if>>${name }</a></li>
						</s:iterator>
						</ul>
					</div>
				</div>
			</div>
		
			<!-- Left -->
			<div class="col-md-8">
			<div class="body">
				
				<s:iterator value="page.result">
					<div class="blog-item">
						<div class="title"><h1 class="effect blog-title"><a href="${ctx }/blog/${id}.html">${title }</a></h1></div>
						<div class="content">
						  ${content }
						</div>
						<a href="${ctx }/blog/${id}.html" class="btn btn-info">阅读全文 &raquo;</a>
					</div>
					<hr class="margin-40">
				</s:iterator>
			
				<s:property value="page.pageSource" escape="false" />
			</div>
			</div>
			
			<!-- Right -->
			<div class="col-md-4">
				
				<div class="body">
					<h2 class="effect margin-bottom-40">推荐文章</h2>
					<ul class="list list-group">
					<s:iterator value="recommend">
						<li><a href="${ctx }/blog/${id}.html" title="${title }">${title }</a></li>
					</s:iterator>
					</ul>
				</div>
				
				<%--
				<div class="body">
					<h2 class="effect margin-bottom-40">最新评论</h2>
					<ul class="media-list">
					  <li class="media">
					    <a class="pull-left" href="#">
					      <img class="media-object thumbnail" src="${ctx }/images/100.jpg">
					    </a>
					    <div class="media-body">
					      <h4 class="media-heading">胡大嘴</h4>
					      <p>列表组是灵活又强大的组件，不仅仅用于显示简单的成列表的元素，还用于复杂的定制的内容。</p>
					    </div>
					  </li>
					  <li class="media">
					    <a class="pull-left" href="#">
					      <img class="media-object thumbnail" src="${ctx }/images/101.jpg">
					    </a>
					    <div class="media-body">
					      <h4 class="media-heading">吕小唇</h4>
					      <p>虽然不总是必须，但是某些时候你可能需要将某些内容放到一个盒子里。对于这种情况，可以试试面板组件。</p>
					    </div>
					  </li>
					</ul>
				</div>
				 --%>
			</div>
		</div>
	</div>
	

	<%@ include file="/commons/footer.jsp"%>
</body>
</html>
<script src="${ctx}/js/blog/blog.js"></script>
<script src="${ctx}/js/syntax/loader.js"></script>