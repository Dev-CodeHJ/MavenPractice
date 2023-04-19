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
    <title>로그인 페이지</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
  <body>
    <div class="vh-100 d-flex justify-content-center align-items-center">
      <div class="container">
        <div class="row d-flex justify-content-center">
          <div class="col-12 col-md-8 col-lg-6">
            <div class="card bg-white">
              <div class="card-body p-5">
                <form class="mb-3 mt-md-4" name="login" method="POST">

                    <script type="text/javascript">

                    var check = "${check}";
                    var message = "${msg}";
                        if(check==2){
                            if(message=="ok"){
                                alert("로그인에 성공하셨습니다.");
                                location.href='/';
                            }else{
                                alert("아이디 또는 비밀번호가 일치하지 않습니다.");
                            }
                        }
                    </script>

                  <h2 class="fw-bold mb-2 text-uppercase ">로그인 페이지</h2>

                  <p class=" mb-5">아이디와 비밀번호를 입력해 주세요!</p>

                  <div class="mb-3">
                    <label for="text" class="form-label ">아이디</label>
                    <input type="text" class="form-control" name="member_id" id="member_id" placeholder="example123">
                  </div>

                  <div class="mb-3">
                    <label for="password" class="form-label ">비밀번호</label>
                    <input type="password" class="form-control" name="pw" id="pw" placeholder="*******">
                  </div>

                  <p class="small"><a class="text-primary" href="forget-password">비밀번호를 잊으셨나요?</a></p>

                  <div class="d-grid">
                  <button class="btn btn-outline-dark" button type="submit" >로그인</button>
                  </div>

                </form>

                <div>
                  <p class="mb-0  text-center">계정이 없으신가요? <a href="join" class="text-primary fw-bold">회원가입</a></p>
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