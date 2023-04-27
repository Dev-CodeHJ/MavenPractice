<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    var message = "${msg}";
        if(message=="ok"){
            if(confirm('정말로 탈퇴하시겠습니까?')){
                alert("탈퇴되셨습니다.");
                location.href='/';
            }
        }else if(message=="fail"){
            alert("비밀번호가 올바르지 않습니다.");
        }
</script>
