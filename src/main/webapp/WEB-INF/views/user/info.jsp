<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="kor">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
            crossorigin="anonymous"/>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css"/>
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
            crossorigin="anonymous"></script>

    <script>
        function fillInfo() {
            document.getElementById("inputName").setAttribute("value",
                "${userInfo.getName()}");
            document.getElementById("inputName").setAttribute("readonly", true);

            document.getElementById("inputId").setAttribute("value",
                "${userInfo.getLoginId()}");
            document.getElementById("inputId").setAttribute("readonly", true);

            document.getElementById("emailFirst").setAttribute("value",
                "${userInfo.getEmail()}");
            document.getElementById("emailLast").setAttribute("value",
                "${userInfo.getDomain()}");
        }
    </script>

    <link rel="stylesheet" href="../css/main.css"/>
    <title>마이 페이지</title>
</head>

<body onload="fillInfo()">
<%@include file="../common/nav.jsp" %>
<div class="contentWrapper">
    <div class="container mb-2" style="text-align: center">
        <h2 class="welcome">My Page</h2>
        <br/>
    </div>
    <div class="container">
        <div class="row mx-auto rounded signUpBox"
             style="width: 600px; border: 1px solid gray; padding: 15px">
            <form id="form-modify" action="">
                <input name="action" value="modify" hidden>
                <h3
                        style="text-decoration: underline rgb(134, 221, 221); font-weight: 700">
                    나의 회원 정보</h3>
                <br/>
                <div class="mb-3">
                    <label for="inputName" class="form-label">이름 :</label> <input
                        type="text" class="form-control" name="name" id="inputName"
                        placeholder="홍길동"/>
                </div>
                <div class="mb-3">
                    <label for="inputId" class="form-label">아이디 :</label> <input
                        type="text" class="form-control" name="loginId" id="inputId"
                        aria-describedby="emailHelp" placeholder="user01"/>
                    <div id="textCheckId"></div>
                </div>
                <%--					<div class="mb-3">--%>
                <%--						<label for="inputPw" class="form-label">변경 비밀번호 :</label> <input--%>
                <%--							type="password" class="form-control" name="password"--%>
                <%--							id="inputPw" onkeyup="checkPassword()" />--%>
                <%--					</div>--%>
                <%--					<div class="mb-3">--%>
                <%--						<label for="checkPw" class="form-label">변경 비밀번호 확인 :</label> <input--%>
                <%--							type="password" class="form-control" id="checkPw" name="email"--%>
                <%--							onkeyup="checkPassword()" />--%>
                <%--						<div id="textCheckPw"></div>--%>
                <%--					</div>--%>
                <div class="mb-2">이메일 :</div>

                <div class="input-group mb-3">
                    <input type="email" class="form-control" id="emailFirst"
                           placeholder="userEmail" name="email_id" aria-label="Username"/>
                    <span class="input-group-text">@</span> <input type="text"
                                                                   class="form-control" id="emailLast" name="domain"
                                                                   placeholder="xxx.com" aria-label="Server"/> <select
                        id="selectEmail" class="mx-1" onchange="enterEmail()">
                    <option value="">선택</option>
                    <option value="naver.com">네이버</option>
                    <option value="google.com">구글</option>
                    <option value="daum.com">다음</option>
                    <option value="ssafy.com">싸피</option>
                </select>
                </div>
                <br/>
                <div class="btnSet">
                    <button type="button" id="btn-modify" class="btn btn-primary"
                            style="width: 32%">수정하기
                    </button>
                    <button type="button" id="delete-Btn" class="btn btn-danger"
                            style="width: 32%" onclick="withdraw()">탈퇴하기
                    </button>
                    <a type="button" href="../index.jsp" class="btn btn-dark"
                       style="width: 32%"> 뒤로가기 </a>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    function enterEmail() {
        let mail = document.getElementById("emailLast");
        let email = document.getElementById("selectEmail").value;
        mail.value = email;
    }

    // function checkPassword() {
    //     let ipPw = document.getElementById("inputPw").value;
    //     let cPw = document.getElementById("checkPw").value;
    //     let text = document.getElementById("textCheckPw");
    //     if (cPw.length == 0) {
    //         text.innerHTML = "";
    //     } else if (ipPw == cPw) {
    //         text.innerHTML = `<div class="right">비밀 번호가 일치합니다</div>`;
    //     } else {
    //         text.innerHTML = `<div class="wrong">비밀 번호가 일치하지 않습니다</div>`;
    //     }
    // }

    document.querySelector("#btn-modify").addEventListener("click", function () {
        if (confirm("회원정보를 수정하시겠습니까??")) {
            let data = {
                "loginId": document.getElementById("inputId").value,
                "email": document.getElementById("emailFirst").value,
                "domain": document.getElementById("emailLast").value
            };
            console.log(data);
            fetch("/api/user-management/modify", {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(data)
            }).then(response => location.href = "/logout");
        }
    })

    document.querySelector("#delete-Btn").addEventListener("click",
    		function() {
    			if (confirm("정말로 탈퇴하시겠습니까??")) {
    				if (confirm("진짜로 탈퇴하시겠습니까??")) {
    					let userid = document.getElementById("inputId").value;
						fetch("/api/user-management/user/"+ document.getElementById("inputId").value, {
							method: "delete",
							headers: {
								"Content-Type": "application/json",
							}
						}).then(response => location.href="/logout");
    				}
    			}
    		});
</script>
</body>
</html>
