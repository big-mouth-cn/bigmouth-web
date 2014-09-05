<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>

<%@ include file="/commons/metalibs.jsp"%>
</head>
<body>

	<%@ include file="/commons/navbar.jsp"%>
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="body">
					<div class="text-center margin-60">
						<img class="img-responsive" src="${ctx}/images/logo/Logo_NoneFont_Black_Full.png" style="width: 256px; display: inline;">
					</div>
					
					<p>胡大嘴的小站（<a href="http://www.big-mouth.cn">www.big-mouth.cn</a>）是一个个人综合网站，包含各类文章、摄影等方面内容。网站所有原创内容遵循 CC BY 3.0 协议发布。</p>
					<p>它是使用Java语言开发的网站，采用Tomcat部署，阿里云服务器，万网域名。程序后台采用开源框架Spring、MyBatis和Struts2，并且使用了Memcached缓存，搜索引擎使用的是开源框架Luence。前端在Bootstrap框架的基础上开发的，采用栅格化<a href="http://www.responsinator.com/?url=www.big-mouth.cn" target="_blank">响应式</a>布局，使用了大量的HTML5和CSS3，因此建议使用支持HTML5的浏览器进行访问。</p>
					
					<%--
					<div class="row product">
					  <div class="col-xs-3 col-md-2">
					    <a href="#" class="thumbnail">
					      <img src="${ctx}/images/product/java.gif">
					    </a>
					  </div>
					  <div class="col-xs-3 col-md-2">
					    <a href="#" class="thumbnail">
					      <img src="${ctx}/images/product/tomcat.png">
					    </a>
					  </div>
					  <div class="col-xs-3 col-md-2">
					    <a href="#" class="thumbnail">
					      <img src="${ctx}/images/product/html5.png">
					    </a>
					  </div>
					  <div class="col-xs-3 col-md-2">
					    <a href="#" class="thumbnail">
					      <img src="${ctx}/images/product/css3.png">
					    </a>
					  </div>
					  <div class="col-xs-3 col-md-2">
					    <a href="#" class="thumbnail">
					      <img src="${ctx}/images/product/struts.gif">
					    </a>
					  </div>
					  <div class="col-xs-3 col-md-2">
					    <a href="#" class="thumbnail">
					      <img src="${ctx}/images/product/spring.jpg">
					    </a>
					  </div>
					  <div class="col-xs-3 col-md-2">
					    <a href="#" class="thumbnail">
					      <img src="${ctx}/images/product/mybatis.png">
					    </a>
					  </div>
					</div>
					 --%>
				</div>
			</div>
		</div>
	</div>
	

	<%@ include file="/commons/footer.jsp"%>
</body>
</html>
<script src="${ctx}/js/about/about.js"></script>