<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<title>胡大嘴的小站</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="胡大嘴的小站（www.big-mouth.cn）是一个个人综合网站，包含各类技术文章、摄影等方面内容。">
	<meta name="keyworkds" content="胡大嘴,大嘴,Allen Hu,Big mouth,Big-mouth,Java,Memcached,ZooKeeper,MongoDB,博客,摄影,书法,烹饪">
	<meta name="author" content="Allen Hu, 胡大嘴">
	<%@ include file="/commons/metalibs.jsp"%>
	<style type="text/css">
	.carousel-caption {
		text-shadow: 0px 0px 10px #000;
	}
	</style>
	<meta property="qc:admins" content="17503465776217557540636" />
</head>
<body>

	<%@ include file="/commons/navbar.jsp"%>
	
	<div id="container">
	
		<div id="myCarousel" class="carousel slide hidden-xs" data-ride="carousel">
	      <!-- Indicators -->
	      <ol class="carousel-indicators">
	        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	        <li data-target="#myCarousel" data-slide-to="1"></li>
	        <li data-target="#myCarousel" data-slide-to="2"></li>
	        <li data-target="#myCarousel" data-slide-to="3"></li>
	      </ol>
	      <div class="carousel-inner">
	        <div class="item active">
	          <img src="${ctx}/images/STJ_1920x600.jpg">
	          <div class="container">
	            <div class="carousel-caption">
	              <h1>姑苏第一名街</h1>
	              <p>在苏州众多的街巷之中，名胜山塘街，被称誉为“姑苏第一名街”。其原因：一是山塘街是一条有1100多年历史的古街；二是它的格局具有最能代表苏州街巷的特点；三是它与许多名人、名事相关。</p>
	            </div>
	          </div>
	        </div>
	        <div class="item">
	          <img src="${ctx}/images/1.jpg">
	          <div class="container">
	            <div class="carousel-caption">
	              <h1>杭州·西湖</h1>
	              <p>杭州西湖是世界文化遗产，江南三大名湖之一，首批国家重点风景名胜区，首批全国文明风景旅游区示范点，中国十大名胜古迹、中国主要的观赏性淡水湖泊之一，在中国的历史文化和风景名胜中占有重要地位。</p>
	            </div>
	          </div>
	        </div>
	        <div class="item">
	          <img src="${ctx}/images/2.jpg">
	          <div class="container">
	            <div class="carousel-caption">
	              <h1>横店·秦王宫</h1>
	              <p>四海归一殿（正殿）分前殿、中殿、后殿，纵深长达120多米。宫殿气宇之轩昂，仅此便可略见一斑。殿堂建筑构造大量采用了大跨度的斗拱，以使穹隆高耸，气势雄浑，几乎无与伦比。</p>
	            </div>
	          </div>
	        </div>
	        <div class="item">
	          <img src="${ctx}/images/3.jpg">
	          <div class="container">
	            <div class="carousel-caption">
	              <h1>杭州·西溪湿地</h1>
	              <p>西溪湿地国家公园，是国内第一个也是唯一的集城市湿地、农耕湿地、文化湿地于一体的国家湿地公园。</p>
	            </div>
	          </div>
	        </div>
	      </div>
	    </div>
	
		<div class="container body">
			<h1 class="text-center effect">想改变世界，先从改变自己开始！</h1>
			
			<hr class="featurette-divider">
		
			<!-- 简介 -->
			<section class="row">
		        <div class="col-md-3 text-center">
		          <img class="img-circle" src="${ctx }/images/myheader.jpg" style="width: 140px; height: 140px;">
		        </div>
		        <div class="col-md-9">
		          <h2 class="effect">简介</h2>
		          <p>Hi，<span id="name"></span>欢迎访问我的小站。我叫胡大嘴，一个爱编程、爱摄影、爱书法、爱烹饪的屌丝文艺青年。<br/> 有目标，努力、坚持不懈，直到成功！是本站的理念和初衷。<br>如果您喜欢小站，可以将小站收藏起来方便下次访问，或者关注我的<a href="contact.jsp">微信公众号</a>。</p>
		        </div>
			</section>
			
			<hr class="featurette-divider">
			
			<!-- 编程 -->
			<div class="row featurette">
		        <div class="col-md-7">
		          <h2 class="effect">编程</h2>
		          <p>我最擅长的编程语言是<code>Java</code>。但我最喜欢<code>JavaScript</code>，因为它是一种动态、弱类型、基于原型的语言，所以我觉得它有着OOP的思想，有着Reflection的机制。</p>
		          <p>从接触计算机开始梦想着当一名Hacker。早期玩<code>Gray pigeons</code>刷钻，写木马，加壳，写私服脚本，那种小有成就的感觉是无以言表的！后来学编程的初衷也是希望能想写出真正的病毒。但当学了<code>Java</code>之后，发现它是具有卓越的安全性……<i>（此处省略很多字）</i></p>
		          <p>语言 <code>Java</code>,<code>JavaScript</code>,<code>Flex</code>,<code>Delphi</code></p>
		          <p>领域 <code>App Store</code>,<code>Monitor</code>,<code>ETL</code></p>
		          <p>学习 <code>Hadoop</code>,<code>NoSQL</code>,<code>Cache</code>,<code>Clusters</code></p>
		        </div>
		        <div class="col-md-5">
		          <img class="featurette-image img-responsive thumbnail" src="${ctx }/images/b465f4ad750a6d4dbf63253778e2e572.png">
		        </div>
		    </div>
		    
		    <hr class="featurette-divider">
		    
		    <!-- 摄影 -->
		    <div class="row featurette">
		    	<div class="col-md-5">
		          <img class="featurette-image img-responsive thumbnail" src="${ctx }/images/b465f4ad750a6d4dbf635464d5qw6d1.jpg">
		        </div>
		        <div class="col-md-7">
		          <h2 class="effect">摄影</h2>
		          <p>我爱拍照，纯屌丝新手一枚。很想行万里路，希望把世界各地最美的景观定格下来。<code>But</code>因为工作的关系，生活的压力，我只能迈出一小步，我的世界很小，但能足够体现我的热情。</p>
		          <p><code>Because </code>小弟一直走实用主义、简约、环保路线……<code>So</code>我的摄影器材非常简单…</p>
		          <p>设备 <code>Canon 600D</code>,<code>18-55mm IS II</code></p>
		        </div>
		    </div>
		    
		    <hr class="featurette-divider">
		    
		    <!-- 书法 -->
			<div class="row featurette">
		        <div class="col-md-7">
		          <h2 class="effect">书法</h2>
		          <p>中国书法，是中国汉字特有的一种传统艺术，被誉为：无言的诗，无行的舞；无图的画，无声的乐。随着现代化的教育方式，从小就很难再接触到了，很多中国历史特色文化也在慢慢的流失。</p>
		          <p>我的父亲是一名书法爱好者，不管是百忙之中，还是闲暇之余，他常会挥洒着笔墨，作出一幅幅精美的作品。我就是在这种环境下长大的，今天开始，下定决心继承这中国数千年的历史文化。</p>
		          <p>临摹 <code>王羲之</code>,<code>柳公权</code></p>
		        </div>
		        <div class="col-md-5">
		          <img class="featurette-image img-responsive thumbnail" src="${ctx }/images/b13651c39f3b6416cd31140fb99b5721.jpg">
		        </div>
		    </div>
		    
		</div>
	</div>

	<%@ include file="/commons/footer.jsp"%>
</body>
</html>
<script src="${ctx }/js/index/index.js"></script>