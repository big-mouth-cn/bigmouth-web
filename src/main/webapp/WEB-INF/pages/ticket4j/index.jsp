<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<title>东皇钟 - 胡大嘴的小站</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="东皇钟(原大嘴购票程序)，是一款火车票购买的辅助程序，它的主要目的是减少人机交互来达到购票的目的。">
	<meta name="keyworkds" content="东皇钟,大嘴抢票,抢票软件,胡大嘴,大嘴,Allen Hu,Big mouth,Big-mouth">
	<meta name="author" content="Allen Hu, 胡大嘴">
	<%@ include file="/commons/metalibs.jsp"%>
	<link href="${ctx }/css/ticket4j.css" rel="stylesheet">
	<style type="text/css">
	.total { position: absolute;top: 65px;right: 15px;color: #808080;padding: 5px 10px;border: 1px solid rgba(51, 51, 51, 0.82);font-size: 12px;background-image: none;outline: 0;-webkit-box-shadow: inset 0 3px 5px rgba(0, 0, 0, 0.53);box-shadow: inset 0 3px 5px rgba(0, 0, 0, 0.53);border-radius: 6px;}
	.share {}
	</style>
</head>
<body>

	<%@ include file="/commons/navbar.jsp"%>
		<header class="mainbanner">
			<div class="mainbanner-inner container text-center">
				<h1 class="mainbanner-title">&nbsp;&nbsp;回家，是我们共同的愿望！</h1>
				<div class="mainbanner-action">
					<a id="download" data-os="pc" class="btn-download-pc text-hide" href="http://pan.baidu.com/s/1hq460lu" target="_blank">立即下载东皇钟 1.0.8</a>
				</div>
				<div class="mainbanner-intro"><span>最新版本：1.0.8 (2014-09-15)</span></div>
				<div class="text-center">
					<div class="inline-block text-left github" style="height: 55px;">
						<a href="https://github.com/big-mouth-cn/ticket4j" target="_blank">https://github.com/big-mouth-cn/ticket4j</a>
					</div>
				</div>
				<div class="total">截至此时，通过东皇钟共成功提交了 <b><s:property value="reports.size"/></b> 笔订单</div>
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
					<h3 class="changelog-title"><span class="float-left">东皇钟 1.0.8<span class="font-normal font-italic color-red">(New)</span></span><span class="changelog-date">2014-09-15</span></h3>
					<div class="changelog-detail-outer">
						<ol class="changelog-detail">
							<li>修复：可能会出现一直正在预订某趟车次的问题</li>
							<li>修复：容易出现非法请求的问题</li>
						</ol>
					</div>
				</article>
				<div class="changelog-older">
					<article class="changelog">
						<h3 class="changelog-title"><span class="float-left">东皇钟 1.0.7</span><span class="changelog-date">2014-09-12</span></h3>
						<div class="changelog-detail-outer">
							<ol class="changelog-detail">
								<li>优化：购票时遇到网络等各种因素造成当前请求失败后不会再受影响</li>
								<li>修复：误以为官方更换了查票地址的问题</li>
							</ol>
						</div>
					</article>
				</div>
				<div class="changelog-older">
					<article class="changelog">
						<h3 class="changelog-title"><span class="float-left">东皇钟 1.0.6</span><span class="changelog-date">2014-09-10</span></h3>
						<div class="changelog-detail-outer">
							<ol class="changelog-detail">
								<li>修复：修复多乘车人购票时在提交订单时会出现java.lang.IllegalStateException异常</li>
								<li>优化：提高配置文件容错率</li>
								<li>优化：优化智能切换查票地址功能，可随官方变动自动切换</li>
							</ol>
						</div>
					</article>
				</div>
				<div class="changelog-older">
					<article class="changelog">
						<h3 class="changelog-title"><span class="float-left">东皇钟 1.0.5</span><span class="changelog-date">2014-09-09</span></h3>
						<div class="changelog-detail-outer">
							<ol class="changelog-detail">
								<li>新增：订单排队流程。防止出票失败，未到售票时间的问题</li>
								<li>新增：是否需要对所有的请求都进行DNS切换（在本地无法打开kyfw.12306.com时开启）</li>
								<li>新增：控制台输出出票失败的原因</li>
								<li>修复：与服务器时间不同步的问题</li>
								<li>优化：订单等待处理流程</li>
							</ol>
						</div>
					</article>
				</div>
				<div class="changelog-older">
					<article class="changelog">
						<h3 class="changelog-title"><span class="float-left">东皇钟 1.0.4</span><span class="changelog-date">2014-09-03</span></h3>
						<div class="changelog-detail-outer">
							<ol class="changelog-detail">
								<li>新增：定时查票功能，可自由配置时间</li>
								<li>新增：查票时支持动态切换DNS，可以选择速度优先和随机切换两种模式</li>
								<li>优化：查票地址可设置多个，支持自动智能切换功能</li>
							</ol>
						</div>
					</article>
				</div>
				<div class="changelog-older">
					<article class="changelog">
						<h3 class="changelog-title"><span class="float-left">东皇钟 1.0.3</span><span class="changelog-date">2014-08-30</span></h3>
						<div class="changelog-detail-outer">
							<ol class="changelog-detail">
								<li>新增：订票前检查乘车人身份是否满足购票条件，防止在订单提交后无法出票</li>
								<li>新增：购票成功后保存订单信息到云端</li>
								<li>优化：提升验证码识别准确率</li>
							</ol>
						</div>
					</article>
				</div>
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
<script>
	window._bd_share_config = {
		"common" : {
			"bdSnsKey" : {},
			"bdText" : "东皇钟(原大嘴购票程序)，是一款火车票购买的辅助程序，它的主要目的是减少人机交互来达到购票的目的。回家，是我们共同的愿望！",
			"bdMini" : "1",
			"bdMiniList" : [ "qzone", "tsina", "weixin", "tqq", "tieba", "mshare", "hi", "ty" ],
			"bdPic" : "",
			"bdStyle" : "0",
			"bdSize" : "16"
		},
		"slide" : {
			"type" : "slide",
			"bdImg" : "5",
			"bdPos" : "right",
			"bdTop" : "100.5"
		}
	};
	with (document)
		0[(getElementsByTagName('head')[0] || body).appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='
				+ ~(-new Date() / 36e5)];
</script>