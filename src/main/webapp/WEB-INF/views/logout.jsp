<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    session.removeAttribute("loginMember");
%>
<script type="text/javascript">
    alert("로그아웃되었습니다!")
    location.href = "/"
</script>
