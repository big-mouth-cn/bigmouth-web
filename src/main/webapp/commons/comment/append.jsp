<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<h2 class="effect margin-bottom-40">发表评论</h2>
<ul class="media-list">
  <li class="media">
    <a class="pull-left" href="#">
      <img id="headUrl" class="media-object thumbnail" src="${ctx }/images/head/default.png">
    </a>
    <div class="media-body">
    	<form class="form" role="form">
    	  <script src="${ctx }/js/kindeditor/kindeditor-min.js"></script>
    	  <script type="text/javascript">
    	  var nickname = '${sessionScope.user_info_bean.nickname}';
    	  var avatar = '${sessionScope.user_info_bean.avatar.avatarURL100 }';
    	  </script>
    	  <div id="welcome" class="form-group">
    	  	  <p><span class="name">游客</span>，<span class="remind">你好！</span></p>
    	  </div>
		  <div class="form-group hide">
		      <input class="form-control" id="name" placeholder="您的大名">
		  </div>
		  <div class="form-group hide">
		      <input class="form-control" id="email" placeholder="您的邮箱地址">
		  </div>
		  <div class="form-group">
		      <textarea class="form-control" id="content" rows="5" placeholder="我也说一句" style="width: 100%;"></textarea>
		  </div>
		  <div class="form-group">
		      <button id="btnSubmitComment" type="button" class="btn btn-primary">确认发表</button>
		      <a id="qqLoginBtn" href="javascript:;" onclick="QQ.login('${ctx }/auth.shtml');"><img src="${ctx }/images/bt_white_76X24.png"></a>
		  </div>
		</form>
    </div>
  </li>
</ul>