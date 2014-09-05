<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>

<%@ include file="/commons/metalibs.jsp"%>
<link rel="stylesheet" href="${ctx }/css/resume.css" type="text/css" />
<style type="text/css">
	.article{width:960px;margin:0 auto;}
	.content{position:relative;z-index:2;width:100%;min-height:630px;overflow:hidden; color: #EEE;}
	.content h1{font:700 64px Tahoma; text-shadow: 1px 1px 5px #000; color: #EEE;}

	.animg{position:absolute;left:-1000px;top:200px;
		-webkit-transition-duration:1s;
	}
	.detail{position:absolute;left:2000px;top:620px;width:100%;font-size:16px;
		-webkit-transition-duration:2s;
	}
	.detailtitle{position:absolute;left:0;top:-100px;padding:10px 20px;background:#333;color:#fff;font-size:24px;
		-webkit-transition-duration:3s;
	}
	.detailtitle-1{top:550px;left:-1000px;}

	/* 运动轨迹 begin */
	.content-focus .animg{left:0;top:200px;}
	.content-focus .detail{left:0;top:620px;}
	.content-focus .detailtitle{top:550px;}
	.content-focus .detailtitle-1{left:0;}
	/* 运动轨迹 end */


	.section{position:fixed;left:50%;width:960px;margin-left:-480px;}
	.section span{position:absolute;z-index:1;display:block;width:50px;height:50px;background:#999;opacity:.5;border-radius:25px;}
	.section-1 .span-1{left:400px;top:100px;}
	.section-1 .span-2{left:700px;top:200px;}
	.section-1 .span-3{left:750px;top:400px;}
	.section-1 .span-4{left:1100px;top:250px;}

	.section-2 .span-1{left:-50px;top:700px;}
	.section-2 .span-2{left:-100px;top:1000px;}
	.section-2 .span-3{left:200px;top:850px;}
	.section-2 .span-4{left:800px;top:800px;}

	.section-3 .span-1{left:-150px;top:1100px;}
	.section-3 .span-2{left:800px;top:1500px;}
	.section-3 .span-3{left:1200px;top:1850px;}
	.section-3 .span-4{left:800px;top:2500px;}


	.slidecount{position:fixed;right:10px;bottom:50%;z-index:1;}
	.slidecount li{margin-bottom:10px;}
	.slidecount li a{display:block;width:10px;height:10px;background:gray;border:3px solid white;overflow:hidden;line-height:100px;border-radius:10px;}
	.slidecount li a:hover{text-decoration:none;background:white;border:3px solid orange;}
	.slidecount li.focus a{background:orange;border:3px solid orange;}
	
	
	.center { text-align: center; }
	.keyword { }
	.description {margin: 15px;}
	.header { width: 140px; height: 140px; }
	.content-focus .header {-webkit-animation: slidedown 1s;}
	@-webkit-keyframes slidedown {
	0% {-webkit-transform: translate(0px,-50px); opacity: 0;}
	25% {-webkit-transform: translate(0px,0px); opacity: 1;}
	55% {-webkit-transform: translate(0px,-10px);}
	75% {-webkit-transform: translate(0px,0px);}
	90% {-webkit-transform: translate(0px,-5px);}
	100% {-webkit-transform: translate(0px,0px);}
	}
</style>
</head>
<body>

	<%@ include file="/commons/navbar.jsp"%>
	
	<div class="article">
		<div class="content content-1" id="first">
			<div class="center" style="margin-top: 50px;">
				<img class="img-circle header" src="${ctx }/images/myheader.jpg">
			</div>
			<div class="center description">
				<p><span class="keyword">胡笑</span>（Allen），男，未婚，身高176<em>cm</em>，体重65<em>kg</em>，一九八九年冬月初十出生在湖南溆浦某个小乡村。</p>
				<p>2015年毕业于长沙理工大学，工商企业管理专业，最高学历：<span class="keyword">本科</span></p>
				<p>现居住在杭州，工作于<span class="keyword">杭州魔品科技有限公司</span>，累计4年以上工作经验。</p>
				<p>该系统已运行：6501days 21hours 50minutes 12senconds</p>
			</div>
			<div>
				<p>主要经历</p>
				<p>1989年出生在一个黑暗的阁楼里（超生），1994年到2004年在善溪小学/中学完成九年义务教育，2005年在溆浦二中就读高中，在校期间天天泡网吧，打游戏，高一未读完辍学。辍学间两年，开始对计算机产生特别的兴趣。做网站、搭私服、写脚本、抓包、玩灰鸽子、刷钻、脚本。经过两年时间的反省与自勉，在人生最重要的十字路口找到了方向。随后在朋友推荐下选择了牛耳教育，从此踏上了这条编程开发的不归路。2010年从长沙来到杭州，就职于浙江网新恩普，从事通讯方向的工作。2011年就职于浙江协同数据，从事ETL领域的研发。2012年，就职于杭州斯凯网络从事应用商店领域的研发；2013年部门独立成杭州魔品科技，从事服务监控、管理及系统架构方面的研究。2013年底，因春运火车票一票难求，自己写了一个抢票软件，随后传播到互联网，造成较大影响，被铁道部公安请喝茶。</p>
			</div>
		</div>
		<div class="content content-2" id="second">
			<h1>技能专长</h1>
			<img class="animg" src="images/logo/Logo_Cat.png" alt="" />
			<p class="detailtitle">世界之美：倒影中的法国巴黎</p>
			<p class="detail">
				提到巴黎的风景，像埃菲尔铁塔，卢浮宫，凯旋门等标志性建筑可能会浮现在我们眼前。然而美术史学家Joanna Lemanska眼中的巴黎却别有另一番风情，他随机的记录了在雨后积水的地面或像镜子、玻璃和金属等闪闪反光的物体上巴黎的靓丽倒影图，从全新的角度展现了巴黎的美景。
			</p>
		</div>
		<div class="content content-3" id="third">
			<h1>兴趣爱好</h1>
			<img class="animg" src="images/logo/Logo_Simple_White_Cat.png" alt="" />
			<p class="detailtitle detailtitle-1">《MY智慧人生》</p>
			<p class="detail">
				淡淡的日子淡然地过。生活如水，人生似茶，再好的茶放到水中一泡，时间久了，也就淡了。也许是棱角平了，或许是成熟稳重了，脚步越来越踏实，日子越来越平淡。人生步入另外一种境界，——淡然。
			</p>
		</div>
	</div>

	<div class="slidecount">
		<ul>
			<li class="focus"><a href="#first" class="glyphicon glyphicon-user"> </a></li>
			<li><a href="#second">2</a></li>
			<li><a href="#third">3</a></li>
		</ul>
	</div>



	<script type="text/javascript">
		$(function(){
			$('.content').css('height', $(window).height());
			
			var timeout = 1000;
			var oWinTop;
			var oContentH = $(".content").height();
			var oContentLen = $(".content").length;
			var vIndex = 0;
			$(".article").css("height",oContentH*oContentLen);
			$(".content:eq("+vIndex+")").addClass("content-focus");

			$(window).scroll(function(){
				parallax();
				oWinTop = $(window).scrollTop();
				$(".slidecount li").removeClass("focus");
				if(oWinTop >= 0 && oWinTop < oContentH){
					vIndex = 0;
				}else if(oWinTop >= oContentH && oWinTop < (oContentH * 2)){
					vIndex = 1;
				}else{
					vIndex = 2;
				}
				$(".slidecount li:eq("+vIndex+")").addClass("focus");
				$(".content:eq("+vIndex+")").addClass("content-focus");
			});

			$(".slidecount li").click(function(){
				if($(this).index() == 0){
					$("body").animate({
						scrollTop:$("#first").offset().top
					},timeout);
					return false;
				}else if($(this).index() == 1){
					$("body").animate({
						scrollTop:$("#second").offset().top
					},timeout);
					return false;
				}else if($(this).index() == 2){
					$("body").animate({
						scrollTop:$("#third").offset().top
					},timeout);
					return false;
				}
			});

			function parallax(){
				var toped = $(window).scrollTop();
				$('.section-1').css({top:(0-(toped*1.75))+'px'});
				$('.section-2').css({top:(0-(toped*0.35))+'px'});
				$('.section-3').css({top:(0-(toped*1.35))+'px'});
			}
			parallax();
			
			$(".slidecount li").first().find('a').click();
		});
	</script>


	<%@ include file="/commons/footer.jsp"%>
</body>
</html>
<script src="${ctx}/js/resume/resume.js"></script>