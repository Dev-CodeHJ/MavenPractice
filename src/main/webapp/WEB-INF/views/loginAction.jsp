<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="service.MemberService" %> <!-- userdao의 클래스 가져옴 -->
<%@ page import="java.io.PrintWriter" %> <!-- 자바 클래스 사용 -->

<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="member" class="dto.MemberDto" scope="page" />
<jsp:setProperty name="member" property="memberId" />
<jsp:setProperty name="member" property="pw" />
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>loginAction</title>
    </head>
    <body>
	<%
		MemberService service = new MemberService(); //인스턴스생성
		int result = service.login(member.getMemberId(), member.getPw());
		//로그인 성공

		if(result == 1){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("<location.href = 'main'");
			script.println("</script>");
		}

		//로그인 실패
		else if(result == 0){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('비밀번호가 틀립니다.')");
			script.println("history.back()");
			script.println("</script>");
		}
		//아이디 없음
		else if(result == -1){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('존재하지 않는 아이디 입니다.')");
		script.println("history.back()");
		script.println("</script>");
		}
		//DB오류
		else if(result == -2){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('DB오류가 발생했습니다.')");
		script.println("history.back()");
		script.println("</script>");

		}

	%>

</body>
</body>
</html>