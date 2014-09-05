<%@ page contentType="text/html; charset=UTF-8" language="java"%>
<%@ include file="/commons/taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>

<%@ include file="/commons/metalibs.jsp"%>
</head>
<body>

	<%@ include file="/commons/navbar.jsp"%>
	
	<div class="container margin-top-60">
		<div class="row">
			<s:iterator value="result">
				<div class="stack twisted">
					<a href="${ctx }/album/${id}.html">
				      <img src="${tileImg }">
				      <span class="hidden-xs">${name }</span>
				    </a>
				</div>
			</s:iterator>
		</div>
	</div>
	

	<%@ include file="/commons/footer.jsp"%>
</body>
</html>
<script src="${ctx}/js/photo/photo.js"></script>