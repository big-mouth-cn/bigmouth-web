<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<title>${entity.title } - 胡大嘴的小站</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="${entity.title }">
	<meta name="keyworkds" content="胡大嘴,大嘴,Allen Hu,Big mouth,Big-mouth,Java,Memcached,ZooKeeper,MongoDB,博客,摄影,书法,烹饪">
	<meta name="author" content="Allen Hu, 胡大嘴">
	<%@ include file="/commons/metalibs.jsp"%>
	<link type="text/css" rel="stylesheet" href="${ctx }/js/syntax/styles/shCoreEclipse.css"/>
	<script type="text/javascript" src="${ctx }/js/syntax/scripts/shCore.js"></script>
</head>
<body>

	<%@ include file="/commons/navbar.jsp"%>
	
	<div class="container">
		<div class="row">
		
			<!-- Left -->
			<div class="col-md-12">
				<div class="body">
					<div class="blog-detail">
						<input type="hidden" id="id" value="${entity.id }">
						<div class="title"><h1 class="effect blog-title">${entity.title }</h1></div>
						<div class="row">
							<div class="timestamp col-md-6">
								<p><span class="glyphicon glyphicon-time"></span> <fmt:formatDate value="${entity.createTime}" pattern="yyyy 年 M 月 d 日 H:m"/></p>
							</div>
							<div class="col-md-6">
								<div class="clearfix">
									<ul class="tags right">
										<s:iterator value="entity.tags">
										<li><a href="${ctx }/tag/${name}">${name }</a></li>
										</s:iterator>
									</ul>
								</div>
							</div>
						</div>
						<div class="content">
							${entity.content }
						</div>
					
						<div class="share">
							<div class="bdsharebuttonbox right"><a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a><a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a><a href="#" class="bds_more" data-cmd="more"></a></div> 
							<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"1","bdSize":"24"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
						</div>
					
						<hr class="margin-40">
						
						<div>
							<ul class="pager">
							<s:if test="entity.pre == null">
							  <li class="previous disabled"><a href="javascript:;">&larr; 上一篇 没有了</a></li>
							</s:if>
							<s:else>
							  <li class="previous"><a href="${ctx }/blog/${entity.pre.id}.html">&larr; 上一篇 《${entity.pre.title }》</a></li>
							</s:else>
							
							<s:if test="entity.next == null">
							  <li class="next disabled"><a href="javascript:;">下一篇 没有了 &rarr;</a></li>
							</s:if>
							<s:else>
							  <li class="next"><a href="${ctx }/blog/${entity.next.id}.html">下一篇 《${entity.next.title }》&rarr;</a></li>
							</s:else>
							</ul>
						</div>
					</div>
				</div>
				
				<!-- Comments -->
				<div class="body">
					<h2 class="effect margin-bottom-40">网友评论 <small class="commentTotal">(<span>0</span>)</small></h2>
					
					<!-- Comment list start -->
					<div id="comment-container"></div>
					<!-- Comment list end -->
					
					<hr class="margin-40">
					
					<%@ include file="/commons/comment/append.jsp" %>
				</div>
				
				<!-- Tags -->
				<div class="margin-top-60">
					<div class="clearfix">
						<ul class="tags">
							<s:iterator value="allTags">
							<li><a href="${ctx }/tag/${name}">${name }</a></li>
							</s:iterator>
						</ul>
					</div>
				</div>
			</div>
			
		</div>
	</div>
	

	<%@ include file="/commons/footer.jsp"%>
</body>
</html>
<script src="${ctx}/js/common/big-mouth.common.comment.js"></script>
<script src="${ctx}/js/blog/blog-thread.js"></script>
<script src="${ctx}/js/syntax/loader.js"></script>