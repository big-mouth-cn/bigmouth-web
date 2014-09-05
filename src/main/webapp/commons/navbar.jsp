<%@ page contentType="text/html; charset=UTF-8" language="java"%>
	<!-- Static navbar -->
	<div class="navbar navbar-inverse navbar-static-top" role="navigation">
	  <div class="container">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
	        <span class="sr-only">Big-mouth</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="${ctx }/">Big-mouth</a>
	    </div>
	    <div class="navbar-collapse collapse">
	      <ul id="menu" class="nav navbar-nav">
	        <li index="0"><a href="${ctx }/"><span class="glyphicon glyphicon-home"></span> 简 介</a></li>
	        <li index="1"><a href="${ctx }/blog"><span class="glyphicon glyphicon-book"></span> 博 客</a></li>
	        <li index="2"><a href="${ctx }/album"><span class="glyphicon glyphicon-camera"></span> 摄 影</a></li>
	        <li index="3"><a href="${ctx }/contact"><span class="glyphicon glyphicon-phone"></span> 联 系</a></li>
	        <li index="4"><a href="${ctx }/about"><span class="glyphicon glyphicon-info-sign"></span> 关 于</a></li>
	        <%--
	        <li index="5"><a href="${ctx }/resume"><span class="glyphicon glyphicon-user"></span> 简历</a></li>
	         --%>
	        <li index="6"><a href="${ctx }/ticket4j"><span class="glyphicon glyphicon-bell"></span> 东皇钟</a></li>
	      </ul>
	      <form class="navbar-form navbar-right" role="search">
		      <div class="div-search form-group">
		        <input id="input-search" type="text" class="form-control input-sm" placeholder="搜索">
		      </div>
		  </form>
	    </div>
	  </div>
	</div>