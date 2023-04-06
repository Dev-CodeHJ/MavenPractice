<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dao.MemberDao"%>
<%@ page import="java.io.PrintWriter"%>
<!-- 자바 클래스 사용 -->
<% request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="member" class="dto.MemberDto" scope="page" />
<jsp:setProperty name="member" property="memberId" />
<jsp:setProperty name="member" property="pw" />
<jsp:setProperty name="member" property="name" />
<jsp:setProperty name="member" property="gender" />
<jsp:setProperty name="member" property="email" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입액션</title>
</head>
<body>
 <%

    MemberDao memberDao = new MemberDao();
    int result = memberDao.join(member);
    PrintWriter script = response.getWriter();

    if (member.getMemberId() == null || member.getPw() == null || member.getName() == null || member.getGender() == null || member.getEmail() == null){

         PrintWriter script = response.getWriter();
         script.println("<script>");
         script.println("alert('입력이 안 된 사항이 있습니다.')");
         script.println("history.back()");
         script.println("</script>");

   } else{
        MemberService service = new MemberService(); //인스턴스생성
        int result = service.join(member);
        if(result == -1){ // 아이디가 기본키기. 중복되면 오류.
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("alert('이미 존재하는 아이디 입니다.')");
        script.println("history.back()");
        script.println("</script>");
        } //가입성공

    else {
        PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("location.href = 'main'");
        script.println("</script>");
        }

     }

 %>

  </body>

 </html>