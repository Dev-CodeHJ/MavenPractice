<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
  <title>BBS</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<%
// 아이디 세션 확인
		String memberId = null;
		if(session.getAttribute("memberId") != null){
			memberId = (String)session.getAttribute("memberId");
		}
	%>

	<!-- navigation bar start -->
		<nav class="navbar navbar-default">
	  		<div class = "navbar-header">
	  			<button type = "button" class = "navbar-toggle collapsed"
	  				data-toggle = "collapse"
	  				data-target="#bs-example-navbar-collapse-1"
	  				aria-expanded = "false">
	  				<span class = "icon-bar"></span>
					<span class = "icon-bar"></span>
					<span class = "icon-bar"></span>
				</button>
				<a class = "navbar-brand" href = "main">메인페이지</a>
	  		</div>
	  		<div class = "collapse navbar-collapse" id = "bs-example-navbar-collapse-1">
	  			<ul class = "nav navbar-nav">
	                <li class = "active"><a href = "main">메인</a></li>
	  				<li><a href = "bbs">게시판</a></li>
	  			</ul>
	  			<% if(memberId == null){%>
	  				<ul class = "nav navbar-nav navbar-right">
	  				<li class = "dropdown">
	  					<a href = "#" class = "dropdown-toggle"
	  					 	data-toggle="dropdown" role = "button"
	  					 	aria-hashpopup = "true"
	  					 	aria-expanded = "false">접속하기<span class = "caret"></span></a>
	  		            <ul class = "dropdown-menu">
	  		                <li><a href = "login">로그인</a></li>
	  		                <li><a href = "join">회원가입</a></li>
	  		            </ul>
	  				</li>
	  			</ul>
	  			<%}else{ %>
	  				<ul class = "nav navbar-nav navbar-right">
	  				<li class = "dropdown">
	  					<a href = "#" class = "dropdown-toggle"
	  					 	data-toggle="dropdown" role = "button"
	  					 	aria-hashpopup = "true"
	  					 	aria-expanded = "false">회원관리<span class = "caret"></span></a>
	  		            <ul class = "dropdown-menu">
	  		                <li><a href = "logoutAction">로그아웃</a></li>
	  		            </ul>
	  				</li>
	  			</ul>
	  			<%} %>
	  		</div>
		</nav>
	<!-- navigation bar end -->
	<div class = "container">
		<div class = "jumbotron">
			<div class = "container">
				<h1>메인 페이지</h1>
				<p>
					이 페이지는 부트스트랩으로 만든 간단한 JSP 웹 게시판입니다.
				</p>
				<a class = "btn btn-primary btn-pull" href = "#" role = "button">알아보기</a>
			</div>
		</div>
	</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>