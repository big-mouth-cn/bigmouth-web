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