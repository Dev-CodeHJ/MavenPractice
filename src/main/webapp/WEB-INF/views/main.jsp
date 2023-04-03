<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
    <head>
        <meta
        http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- 뷰포트 -->
        <meta
        name="viewport" content="width=device-width" initial-scale="1">
        <!-- 스타일시트 참조 -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <title>게시판 웹 사이트</title>
    </head>
    <body>
        <%
		String memberId = null;

		if(session.getAttribute("memberId") != null) {
			memberId = (String) session.getAttribute("memberId");
		}
	%>
        <!-- 네비게이션 -->
        <nav class="navbar navbar-default">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expaned="false">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="main">JSP 게시판</a>
            </div>
            <div class="collapsenavbar-collapse" id="#bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active">
                        <a href="main">메인</a>
                    </li>
                    <li>
                        <a href="bbs">게시판</a>
                    </li>
                </ul>
                <%
				if(memberId == null){
			%>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">접속하기<span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="login">로그인</a>
                                </li>
                                <li>
                                    <a href="join">회원가입</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                <%
				} else {
			%>
                    <ul class="nav navbar-nav navbar-right">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">회원 관리<span class="caret"></span>
                            </a>
                            <ul class="dropdown-menu">
                                <li>
                                    <a href="logoutAction">로그아웃</a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                <%
				}
			%>
            </div>
        </nav>
        <!-- 애니매이션 담당 JQUERY -->
        <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
        <!-- 부트스트랩 JS  -->
        <script src="js/bootstrap.js"></script>
    </body>
</html>