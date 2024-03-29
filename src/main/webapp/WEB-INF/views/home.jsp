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
    <title>메인페이지</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet" />
</head>
    <body>
            <!-- 로그인 하지 않았을 경우 -->
    <% if(session.getAttribute("loginMember")==null) { %>

        <div class="d-flex" id="wrapper">
            <!-- Sidebar-->
            <div class="border-end bg-white" id="sidebar-wrapper">
                <div class="sidebar-heading border-bottom bg-light">자유게시판</div>
                <div class="list-group list-group-flush">
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="boardList">글 목록</a>
                </div>
            </div>
            <!-- Page content wrapper-->
            <div id="page-content-wrapper">
                <!-- Top navigation-->
                <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
                    <div class="container-fluid">
                        <button class="btn btn-primary" id="sidebarToggle">게시판</button>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav ms-auto mt-2 mt-lg-0">
                                <li class="nav-item active"><a class="nav-link" href="join">회원가입</a></li>
                                <li class="nav-item"><a class="nav-link" href="login">로그인</a></li>
                            </ul>
                        </div>
                    </div>
                </nav>
                <!-- Page content-->
                <div class="container-fluid">
                    <h1 class="mt-4">홈페이지</h1>
                    <p>로그인 후 사용해 주세요</p>
                </div>
            </div>
        </div>

    <!-- 로그인 했을 경우 -->
    <% } else { %>

        <script type="text/javascript">
            function check(){
                var pw = "<%= session.getAttribute("pw") %>";
                var enteredPw = prompt("비밀번호를 입력하세요.");

                if(enteredPw != null){
                    if(pw == enteredPw){
                        return true;
                    } else{
                        alert("비밀번호가 올바르지 않습니다.");
                        return false;
                    }
                } else{
                    return false;
                }
            }
            function delCheck(){
                if(check()==true){
                    if(confirm('정말로 탈퇴하시겠습니까?')){
                        return ture;
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
        </script>

        <div class="d-flex" id="wrapper">
            <!-- Sidebar-->
            <div class="border-end bg-white" id="sidebar-wrapper">
                <div class="sidebar-heading border-bottom bg-light">자유게시판</div>
                <div class="list-group list-group-flush">
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="boardList">글 목록</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">새 글 작성</a>
                    <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">내 게시글 관리</a>
                </div>
            </div>
            <!-- Page content wrapper-->
            <div id="page-content-wrapper">
                <!-- Top navigation-->
                <nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
                    <div class="container-fluid">
                        <button class="btn btn-primary" id="sidebarToggle">게시판</button>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav ms-auto mt-2 mt-lg-0">
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">마이페이지</a>
                                    <div class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                                        <a class="dropdown-item" href="updateMember" onclick="return check();">내 정보 / 변경</a>
                                        <a class="dropdown-item" href="logout" onclick="return confirm('로그아웃 하시겠습니까?');">로그아웃</a>
                                        <div class="dropdown-divider"></div>
                                        <a class="dropdown-item" href="deleteMember" onclick="return delCheck();">회원 탈퇴</a>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
                <!-- Page content-->
                <div class="container-fluid">
                    <h1 class="mt-4">홈페이지</h1>
                    <h4 class="mt-3"> <%= session.getAttribute("name") %>님, 환영합니다.</h4>
                </div>
            </div>
        </div>

    <% } %>

        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>
