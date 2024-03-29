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
    <div class="vh-100 d-flex justify-content-center align-items-center">
      <div class="container">
        <div class="row d-flex justify-content-center">
          <div class="col-12 col-md-8 col-lg-6">
            <div class="card bg-white">
              <div class="card-body p-5">
                <form class="mb-3 mt-md-4" name="join" onsubmit="return confirm('회원가입 하시겠습니까?');" method="POST">

                    <script type="text/javascript">

                    var check = "${check}";
                    var message = "${msg}";
                        if(check==2){
                            if(message=="ok"){
                                alert("회원가입에 성공하셨습니다.");
                                location.href='/login';
                            }else if(message=="exist"){
                                alert("아이디가 이미 존재합니다.");
                            }else{
                                alert("입력이 안된 사항이 있습니다!");
                            }
                        }
                    </script>
                  <h2 class="fw-bold mb-5 text-uppercase ">회원가입 페이지</h2>

                  <div class="mb-3">
                    <label for="text" class="form-label ">아이디</label>
                    <input type="text" class="form-control" name ="member_id" id="member_id" placeholder="example123">
                  </div>

                  <div class="mb-3">
                    <label for="password" class="form-label ">비밀번호</label>
                    <input type="password" class="form-control" name="pw" id="pw" placeholder="*******">
                  </div>

                  <div class="mb-3">
                    <label for="text" class="form-label ">이름</label>
                    <input type="text" class="form-control" name = "name" id="name" placeholder="홍길동">
                  </div>
                <div class="col-md-6 mb-4">

                  <h6 class="mb-2 pb-1">성별</h6>

                  <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="maleGender"
                      value="남자" />
                    <label class="form-check-label" for="maleGender">남자</label>
                  </div>

                  <div class="form-check form-check-inline">
                    <input class="form-check-input" type="radio" name="gender" id="femaleGender"
                      value="여자" />
                    <label class="form-check-label" for="femaleGender">여자</label>
                  </div>

                </div>

                  <div class="mb-4">
                    <label for="email" class="form-label ">이메일</label>
                    <input type="email" class="form-control" name="email" id="email" placeholder="ex12@ex.com">
                  </div>

                  <div class="d-grid">
                    <input class="btn btn-outline-dark" type="submit" id="joinBtn" value="회원가입" ></input>
                  </div>

                </form>

                <div>
                  <p class="mb-0  text-center">계정이 이미 있으신가요? <a href="login" class="text-primary fw-bold">로그인하러 가기</a></p>
                </div>

                <br>
                <h4 class="mb-0  text-center"><a href="/" class="text-secondary fw-bold">홈페이지로 돌아가기</a></h4>

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS-->
   <script src="../resources/static/js/scripts.js"></script>
  </body>
</html>