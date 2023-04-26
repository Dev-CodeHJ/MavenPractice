<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:line-height="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>마이페이지</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet" />
</head>
<body>
<div class="vh-100 d-flex justify-content-center align-items-center">
    <div class="container">
        <div class="row d-flex justify-content-center">
            <div class="col-12 col-md-8 col-lg-6">
                <div class="card bg-white">
                    <div class="card-body p-4">
                        <form class="mb-3 mt-md-4" name="update" onsubmit="return confirm('회원정보를 변경하시겠습니까?');" method="POST">

                            <script type="text/javascript">
                                var check = "${check}";
                                var message = "${msg}";
                                    if(check==2){
                                        if(message=="error"){
                                            alert("비밀번호가 일치하지 않습니다.")
                                        } else {
                                        alert("회원정보가 수정되었습니다. 다시 로그인 해주세요!");
                                        location.href='/logout';
                                        }
                                    }
                            </script>
                            <h2 class="fw-bold mb-4 text-uppercase ">내 정보</h2>

                            <div class="mb-4">
                                <label for="text" class="form-label ">아이디</label>
                                <input type="text" class="form-control" name="member_id" id="member_id" value="<%= session.getAttribute("member_id") %>" readonly="readonly">
                            </div>

                            <div class="mb-4">
                                <label for="password" class="form-label ">비밀번호</label>
                                <div class="mb-1">
                                <input type="password" class="form-control" name="pw" id="pw" placeholder="비밀번호를 입력해주세요.">
                                </div>
                                <input type="password" class="form-control" name="pw1" id="pw1" placeholder="한 번 더 입력해주세요.">
                            </div>

                            <div class="mb-4">
                                <label for="text" class="form-label ">이름</label>
                                <input type="text" class="form-control" name = "name" id="name" value="<%= session.getAttribute("name") %>">
                            </div>
                            <div class="col-md-6 mb-3">

                                <h6 class="mb-2 pb-1">성별</h6>

                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="gender" id="maleGender"
                                           value="남자" <% if(session.getAttribute("gender").equals("남자")){ %>
                                           checked
                                           <% } %>/>
                                    <label class="form-check-label" for="maleGender">남자</label>
                                </div>

                                <div class="form-check form-check-inline">
                                    <input class="form-check-input" type="radio" name="gender" id="femaleGender"
                                           value="여자" <% if(session.getAttribute("gender").equals("여자")){ %>
                                           checked
                                           <% } %>/>
                                    <label class="form-check-label" for="femaleGender">여자</label>
                                </div>

                            </div>

                            <div class="mb-4">
                                <label for="email" class="form-label ">이메일</label>
                                <input type="email" class="form-control" name="email" id="email" value="<%= session.getAttribute("email") %>">
                            </div>

                            <div class="d-grid">
                                <input class="btn btn-outline-dark" type="submit" id="updateBtn" value="회원정보 수정" ></input>
                            </div> <br>
                            <h4 class="mb-0  text-center"><a href="/" class="text-secondary fw-bold">홈페이지로 돌아가기</a></h4>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
</body>
</html>
