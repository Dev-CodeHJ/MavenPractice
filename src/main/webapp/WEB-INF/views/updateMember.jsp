<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>회원정보 변경페이지</title>
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
                            <h2 class="fw-bold mb-5 text-uppercase ">회원정보 변경</h2>

                            <div class="mb-3">
                                아이디 : <input type="text" name="id" value="<%=mapper.findByMemberId(member).getMemberId()%>" readonly="readonly"><br><br>
                            </div>

                            <div class="mb-3">
                                비밀번호 : <input type="password" name="pw" placeholder="비밀번호를 입력해주세요." ><br>
                                2 차확인 : <input type="password" name="pw" placeholder="한 번 더 입력해주세요." ><br><br>
                            </div>

                            <div class="mb-3">
                                이름 : <input type="text" name="name">
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
                                이메일 : <input type="email" name="email">
                            </div>

                            <div class="d-grid">
                                <input class="btn btn-outline-dark" type="submit" id="joinBtn" value="회원정보 변경" ></input>
                            </div>
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
