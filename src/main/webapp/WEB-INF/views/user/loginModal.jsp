<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="root" value="${pageContext.request.contextPath}" />

<div class="container">
    <div class="row justify-content-center">
        <div class="col-lg-8 col-md-10 col-sm-12">
            <h2 class="my-3 py-3 shadow-sm bg-light text-center">
                <mark class="orange">로그인</mark>
            </h2>
        </div>
        <div class="col-lg-8 col-md-10 col-sm-12">
            <form id="form-login" method="POST" action="">
                <div class="form-check mb-3 float-end">
                    <input
                            class="form-check-input"
                            type="checkbox"
                            value="ok"
                            id="saveid"
                            name="saveid"
                    ${idck}
                    />
                    <label class="form-check-label" for="saveid"> 아이디저장 </label>
                </div>
                <div class="mb-3">
                    <label for="loginId" class="form-label">아이디 : </label>
                    <input
                            type="text"
                            class="form-control"
                            id="loginId"
                            name="loginId"
                            placeholder="아이디..."
                            value="${saveid}"
                    />
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">비밀번호 : </label>
                    <input
                            type="password"
                            class="form-control"
                            id="password"
                            name="password"
                            placeholder="비밀번호..."
                    />
                </div>
                <div class="text-danger mb-2">${msg}</div>
                <div class="col-auto text-center">
                    <button type="button" id="btn-login" class="btn btn-outline-primary mb-3">
                        로그인
                    </button>
                    <button type="button" id="btn-mv-join" class="btn btn-outline-success mb-3">
                        회원가입
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>

<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"
></script>

<script>
    document.querySelector("#btn-mv-join").addEventListener("click", function () {
        location.href = "${root}/user/join";
    });

    document.querySelector("#btn-login").addEventListener("click", function () {
        if (!document.querySelector("#loginId").value) {
            alert("아이디 입력!!");
            return;
        } else if (!document.querySelector("#password").value) {
            alert("비밀번호 입력!!");
            return;
        } else {
            let form = document.querySelector("#form-login");
            form.setAttribute("action", "/login");
            form.submit();
        }
    });
</script>