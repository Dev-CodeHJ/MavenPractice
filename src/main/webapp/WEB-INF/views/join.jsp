<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>회원가입 페이지</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
  <body>
      	<script type="text/javascript">
      	var check=${check};
  		var message = "${msg}";
  		if(check==2)
  		alert(message);
  		</script>
    <div class="vh-100 d-flex justify-content-center align-items-center">
      <div class="container">
        <div class="row d-flex justify-content-center">
          <div class="col-12 col-md-8 col-lg-6">
            <div class="card bg-white">
              <div class="card-body p-5">
                <form class="mb-3 mt-md-4">

                  <h2 class="fw-bold mb-5 text-uppercase ">회원가입 페이지</h2>

                  <div class="mb-3">
                    <label for="text" class="form-label ">아이디</label>
                    <input type="text" class="form-control" id="memberId" placeholder="example123">
                  </div>

                  <div class="mb-3">
                    <label for="password" class="form-label ">비밀번호</label>
                    <input type="password" class="form-control" id="pw" placeholder="*******">
                  </div>

                  <div class="mb-3">
                    <label for="text" class="form-label ">이름</label>
                    <input type="text" class="form-control" id="name" placeholder="홍길동">
                  </div>
                <div class="col-md-6 mb-4">

                  <h6 class="mb-2 pb-1">성별</h6>

                  <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="maleGender"
                      value="option1" checked />
                    <label class="form-check-label" for="maleGender">남자</label>
                  </div>

                  <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="inlineRadioOptions" id="femaleGender"
                      value="option2" />
                    <label class="form-check-label" for="femaleGender">여자</label>
                  </div>

                </div>

                  <div class="mb-4">
                    <label for="email" class="form-label ">이메일</label>
                    <input type="email" class="form-control" id="email" placeholder="ex12@ex.com">
                  </div>

                  <div class="d-grid">
                  <button class="btn btn-outline-dark" button type="button" onclick="location.href='joinAction'">회원가입</button>
                  </div>

                </form>

                <div>
                  <p class="mb-0  text-center">계정이 이미 있으신가요? <a href="login" class="text-primary fw-bold">로그인하러 가기</a></p>
                </div>

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
            <!-- Bootstrap core JS-->
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
            <!-- Core theme JS-->
            <script src="../resources/js/scripts.js"></script>
  </body>
</html>