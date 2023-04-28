<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    var message = "${msg}";
    if(message=="ok"){
        alert("회원이 탈퇴되셨습니다.");
        location.href='/logout';
    } else{
        alert("회원 탈퇴가 정상적으로 이루어지지 않았습니다.");
        location.href='/';
    }
</script>
