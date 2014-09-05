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
	      	<li index="-99"><a href="${ctx }/" target="_blank"><span class="glyphicon glyphicon-home"></span> 前台首页</a></li>
	      	<li class="active" index="0"><a href="${ctx }/manage/home.shtml"><span class="glyphicon glyphicon-home"></span> 后台首页</a></li>
	        <li index="1"><a href="${ctx }/manage/blog.shtml"><span class="glyphicon glyphicon-book"></span> 博客管理</a></li>
	        <li index="2"><a href="${ctx }/manage/album.shtml"><span class="glyphicon glyphicon-camera"></span> 摄影管理</a></li>
	        <li index="3"><a href="${ctx }/manage/system.jsp"><span class="glyphicon glyphicon-cog"></span> 系统设置</a></li>
	      </ul>
	    </div>
	  </div>
	</div>

	<div id="struts2Message">
		<s:actionmessage theme="custom" />
		<s:actionerror  theme="custom" />
	</div>