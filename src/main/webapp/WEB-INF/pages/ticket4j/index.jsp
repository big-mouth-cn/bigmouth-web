<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<title>东皇钟 - 胡大嘴的小站</title>
	<%@ page contentType="text/html; charset=UTF-8" language="java"%>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="东皇钟(原大嘴购票程序)，是一款火车票购买的辅助程序，它的主要目的是减少人机交互来达到购票的目的。">
	<meta name="keyworkds" content="东皇钟,大嘴抢票,抢票软件,胡大嘴,大嘴,Allen Hu,Big mouth,Big-mouth,Java,Memcached,ZooKeeper,MongoDB,博客,摄影,书法,烹饪">
	<meta name="author" content="Allen Hu, 胡大嘴">
	<link rel="shortcut icon" href="${ctx }/images/logo/favicon.png">
	<!-- Bootstrap core CSS -->
	<link href="${ctx }/css/custom-theme/jquery-ui-1.9.2.custom.css" rel="stylesheet">
	<link href="${ctx }/css/bootstrap.css" rel="stylesheet">
	<link href="${ctx }/css/navbar-static-top.css" rel="stylesheet">
	<link href="${ctx }/css/big-mouth.common.css" rel="stylesheet">
	<link href="${ctx }/css/ticket4j.css" rel="stylesheet">
	<% request.setCharacterEncoding("UTF-8"); %>
	<!-- Javascript -->
	<script src="${ctx }/js/jquery-1.8.0.min.js"></script>
	<script src="${ctx }/js/jquery-ui-1.9.2.custom.min.js"></script>
	<script src="${ctx }/js/bootstrap.min.js"></script>
	<script src="${ctx }/js/jquery.cookie.js"></script>
	<script src="${ctx }/js/jquery.pjax.js"></script>
	<script src="${ctx }/js/big-mouth.common.js"></script>
	<script src="${ctx }/js/big-mouth.web.common.js"></script>
	<script>window.baseUrl = "${ctx}";</script>
</head>
<body>

	<%@ include file="/commons/navbar.jsp"%>
	
		<header class="mainbanner">
			<div class="mainbanner-inner container text-center">
			<h1 class="mainbanner-title">&nbsp;&nbsp;回家，是我们共同的愿望！</h1>
			<div class="mainbanner-action">
				<a id="download" data-os="pc" class="btn-download-pc text-hide" href="http://pan.baidu.com/s/1pJjtgLX" target="_blank">立即下载东皇钟 1.0.3</a>
			</div>
			<div class="mainbanner-intro"><span>最新版本：1.0.3 (2014-08-30)</span></div>
			<div class="text-center">
				<div class="inline-block text-left github" style="height: 55px;">
					<a href="https://github.com/big-mouth-cn/ticket4j" target="_blank">https://github.com/big-mouth-cn/ticket4j</a>
				</div>
			</div>
			</div>
		</header>
		<div class="showcase-list container">
			<h2 class="heading-second">关键特征</h2>
			<ul class="showcase">
				<li class="showcase-item showcase-easy">
					<strong class="showcase-title">极致的简单</strong>
					<p class="showcase-intro">无界面胜有界面，我们注重的是效率。延续上季大嘴购票程序的设计，让复杂繁琐的界面站一边。我们要的仅仅是那张能回家的票。</p>
				</li>
				<li class="showcase-item showcase-recogn">
					<strong class="showcase-title">验证码识别</strong>
					<p class="showcase-intro">为了能够更方便快捷的购买到车票，我们最大化减少人机交互。在高峰期，抢先一步提交订单。你之所以选择东皇钟，也一定是因为它够智能。</p>
				</li>
				<li class="showcase-item showcase-github">
					<strong class="showcase-title">为开源重新打造</strong>
					<p class="showcase-intro">开源，意味着真正免费。为了维护合理的购票秩序，我们呼吁大家参与进来，发挥东皇钟最大的能力来抵制扰乱公共秩序的非法份子。</p>
				</li>
			</ul>
			<p class="showcase-note"></p>
		</div>
		<section class="changelog-list container">
			<h2 class="heading-second">更新日志</h2>
			<div class="whiteboard">
				<article class="changelog">
					<h3 class="changelog-title"><span class="float-left">东皇钟 1.0.3<span class="font-normal font-italic color-red">(New)</span></span><span class="changelog-date">2014-08-30</span></h3>
					<div class="changelog-detail-outer">
						<ol class="changelog-detail">
							<li>新增：订票前检查乘车人身份是否满足购票条件，防止在订单提交后无法出票</li>
							<li>新增：购票成功后保存订单信息到云端</li>
							<li>优化：提升验证码识别准确率</li>
						</ol>
					</div>
				</article>
				<div id="changelog-older">
					<article class="changelog">
						<h3 class="changelog-title"><span class="float-left">东皇钟 1.0.2</span><span class="changelog-date">2014-08-27</span></h3>
						<div class="changelog-detail-outer">
							<ol class="changelog-detail">
								<li>新增：验证码自动识别功能</li>
								<li>新增：开放12306接口地址的设置</li>
								<li>新增：订单提交后支持查看处理进度</li>
							</ol>
						</div>
					</article>
				</div>
				<div id="changelog-older">
					<article class="changelog">
						<h3 class="changelog-title"><span class="float-left">东皇钟 1.0.1</span><span class="changelog-date">2014-08-22</span></h3>
						<div class="changelog-detail-outer">
							<ol class="changelog-detail">
								<li>新增：会话缓存功能，短时间内无需重复登录</li>
								<li>优化：订单提交流程，去除无用的请求</li>
								<li>优化：不能根据席别进行排序购票的问题</li>
							  </ol>
						</div>
					</article>
				</div>
				<div id="changelog-older">
					<article class="changelog">
						<h3 class="changelog-title"><span class="float-left">东皇钟 1.0.0</span><span class="changelog-date">2014-08-20</span></h3>
						<div class="changelog-detail-outer">
							<ol class="changelog-detail">
								<li>基于2013版流程，重构程序框架，更清晰简洁，为开源而生</li>
							  </ol>
						</div>
					</article>
				</div>
			</div>
		</section>
	<%@ include file="/commons/footer.jsp"%>
</body>
</html>
<script src="${ctx}/js/ticket4j/ticket4j.js"></script>