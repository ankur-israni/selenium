<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>


	<!-- General meta information -->
	<title>Login</title>
	<meta name="keywords" content="" />
	<meta name="description" content="" />
	<meta name="robots" content="index, follow" />
	<meta charset="utf-8" />
	
	
	<script type="text/javascript" src="/shop/resources/js/jquery.js"></script>
	<script type="text/javascript" src="/shop/resources/js/jquery.query-2.1.7.js"></script>
	<script type="text/javascript" src="/shop/resources/js/rainbows.js"></script>

	<link type="text/css" rel="stylesheet" href="/shop/resources/css/style.css" media="screen" />
	
<script>


/* 	$(document).ready(function(){
 
	$("#submit1").hover(
	function() {
	$(this).animate({"opacity": "0"}, "slow");
	},
	function() {
	$(this).animate({"opacity": "1"}, "slow");
	});
 	}); */

	
	function go(){
		document.getElementById("loginId").src="/shop/resources/images/submit_hover.png";
		document.forms['loginForm'].action="/shop/cs?action=Login";
		document.forms['loginForm'].submit();
	}

</script>
	
</head>
<body>

<%
String loginError=(String)request.getAttribute("loginError");
String logoutMessage=(String)request.getAttribute("logoutMessage");
if(loginError!=null){
%>

<div class="loginMessage">
	<span style="color: red"><%=loginError %></span>
</div>

<%
}
%>

<%
if(logoutMessage!=null){
%>
<div class="loginMessage"><span style="color: green"><%=logoutMessage%></span></div>
<%
}
%>

 <form name="loginForm" action="/shop/cs" method="post">
	<div id="wrapper">
		<div id="wrappertop"></div>

		<div id="wrappermiddle"> 

			<h2 id='pageHeader'>Login</h2>

			<div id="username_input">
				<div id="username_inputleft"></div>
				<div id="username_inputmiddle">
					<input type="text" name="username" id="uid" value="E-mail Address" onclick="this.value = ''"></input>
					<img id="login_username_image" src="/shop/resources/images/mailicon.png" alt=""></img>
				</div>
			 	<div id="username_inputright"></div> 
			</div>
			
			<div id="password_input">
				<div id="password_inputleft"></div>
				<div id="password_inputmiddle">
					<input type="password" name="password" id="pid" value="Password" onclick="this.value = ''"></input>
					<img id="login_password_image" src="/shop/resources/images/passicon.png" alt=""></img>
				</div>
				<div id="password_inputright"></div>
			</div>


			<div id="submit">
			 	<input class="submitClass" title="testtitle" type="image" id="loginId" name="action"  value="Login" src="/shop/resources/images/submit.png" onclick="go();"/> 
			</div>


			<div id="links_left">

			<a href="#">Forgot your Password?</a>

			</div>

			<div id="links_right"><a href="#">Not a Member Yet?</a></div>

		</div>
 
		 <div id="wrapperbottom"></div>  
		
		
	 </div> 
	 	<input type="hidden" name="page" value="login"/>
</form>
</body>
</html>