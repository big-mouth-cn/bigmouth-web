<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>

<%@ include file="/commons/metalibs.jsp"%>
<style type="text/css">
</style>
</head>
<body>

	<%@ include file="/commons/navbar.jsp"%>
	
	<div class="container body">
		<div class="row text-center">
          	<img class="featurette-image" src="${ctx }/images/cry.png" style="width: 120px;">
        </div>
		<div class="row text-center">
        	<h1 class="effect">404</h1>
			<h3>Sorry! Page not found.</h3>
			<p class="margin-40"><a class="btn btn-primary" href="${ctx }/">&laquo; Back to home</a></p>
	    </div>
	</div>

	<%@ include file="/commons/footer.jsp"%>
</body>
</html>
<script>
$(function() {
	Menu.active(-1);
});
</script>