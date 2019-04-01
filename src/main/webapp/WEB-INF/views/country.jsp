<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
		<meta charset="utf-8">
   		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
	    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	    
	    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
		<title>Person Page</title>
		
	</head>
<body>
<h1>
	Hello world from Country ${name }  And with ${langName}!  
</h1>

	<div class="container">
		<div class="row">
			<div class="col-3">
				
					<b>${facets }</b>
				
			</div>
			<div class="col-9">
				<c:forEach items="${listContact}" var="contact">
					<div class="card" style="width: 18rem;">
						<div class="card-header">${contact.name}</div>
						<div class="card-body ">
							<img class="card-img-top"  alt="" src="${contact.flag }">
						</div>
						<div class="card-footer">
							${contact.capital }
							<br>
							${contact.objectID }
						</div>
					</div>
				</c:forEach>
			</div>
			
		</div>	
	</div>

</body>
</html>