<%@page import="java.util.*, com.shop.domain.Item"%>
<html>
<head>
<title>Cart summary</title>
  	<link type="text/css" rel="stylesheet" href="/shop/resources/css/style.css" /> 
	
  <link rel="stylesheet" href="/shop/resources/js/jquery-ui-1.12.1.custom/jquery-ui.min.css" media="screen">	
<script type="text/javascript" src="/shop/resources/js/jquery-ui-1.12.1.custom/external/jquery/jquery.js"></script>
<script type="text/javascript" src="/shop/resources/js/jquery-ui-1.12.1.custom/jquery-ui.min.js"></script>  
</head>
<body>


<form name="summaryForm" action="/shop/cs" method="post">
	<jsp:include page="f_header.jsp"></jsp:include>
	<jsp:include page="f_summary_body.jsp"></jsp:include>	
	<jsp:include page="f_footer.jsp"></jsp:include>

	<input type="hidden" name="page" value="summary"/>
</form>
</body>
</html>