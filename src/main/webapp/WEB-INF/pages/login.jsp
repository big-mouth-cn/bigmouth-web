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
			<div class="col-md-offset-8 col-md-4">
				<form class="form-signin" role="form" action="${ctx }/base/auth!login.shtml" method="post">
					<h2 class="form-signin-heading">Please sign in</h2>
					<input name="loginName" type="text" class="form-control" placeholder="Username" required autofocus> 
					<input name="password" type="password" class="form-control" placeholder="Password" required>
					<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
				</form>
			</div>
		</div>
		
	</div>
	

	<%@ include file="/commons/footer.jsp"%>
</body>
</html>