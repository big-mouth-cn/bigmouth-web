<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>

	<title>联系我 - 胡大嘴的小站</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="胡大嘴的小站（www.big-mouth.cn）是一个个人综合网站，包含各类技术文章、摄影等方面内容。">
	<meta name="keyworkds" content="胡大嘴,大嘴,Allen Hu,Big mouth,Big-mouth,Java,Memcached,ZooKeeper,MongoDB,博客,摄影,书法,烹饪">
	<meta name="author" content="Allen Hu, 胡大嘴">
	<%@ include file="/commons/metalibs.jsp"%>
</head>
<body>

	<%@ include file="/commons/navbar.jsp"%>
	
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="body">
					<div class="text-center margin-60">
						<img class="img-responsive" src="${ctx}/images/qrcode_weixin.jpg" style="width: 300px; display: inline;">
						<p>关注《胡大嘴》公众号，即时收取最新动态。快用微信扫我！</p>
						<p>您也可以Email我：<a href="mailto:huxiao.mail@qq.com">huxiao.mail@qq.com</a>
					</div>
					
				</div>
			</div>
		</div>
	</div>
	

	<%@ include file="/commons/footer.jsp"%>
</body>
</html>
<script src="${ctx}/js/contact/contact.js"></script>