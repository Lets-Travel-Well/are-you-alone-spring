<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="root" value="${pageContext.request.contextPath}" />

<%--<c:if test="${cookie.ssafy_id.value ne null}">--%>
<%--    <c:set var="idck" value=" checked"/>--%>
<%--    <c:set var="saveid" value="${cookie.ssafy_id.value}"/>--%>
<%--</c:if>--%>
<%@include file="./common/header.jsp"%>
    <title>RUALONE</title>
</head>
<body>
<%@include file="./common/nav.jsp"%>

<c:if test="${empty userInfo}">
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
</c:if>


<c:if test="${not empty userInfo}">
    <div class="container">
        <div>${userInfo.loginId} ${userInfo.name}</div>
        <!-- 로그인 사용자 정보(로그아웃) 출력 -->
<%--        <%@ include file="/WEB-INF/views/common/confirm.jsp" %>--%>
        <div class="row justify-content-center">
            <div class="col-lg-8 col-md-10 col-sm-12">
                <h2 class="my-3 py-3 shadow-sm bg-light text-center">
                    <mark class="orange">RUALONE</mark>
                </h2>
            </div>

            <form id="form-post" method="POST" action="">
                <div class="mb-3">
                    <label for="subject" class="form-label">제목 : </label>
                    <input
                            type="text"
                            class="form-control"
                            id="subject"
                            name="subject"
                    />
                </div>
                <div class="mb-3">
                    <label for="content" class="form-label">내용 : </label>
                    <input
                            type="text"
                            class="form-control"
                            id="content"
                            name="content"
                    />
                </div>
                <div class="col-auto text-center">
                    <button type="button" id="btn-post" class="btn btn-outline-primary mb-3">
                        버어튼
                    </button>
                </div>
            </form>

            <div class="col-lg-8 col-md-10 col-sm-12 text-center">
<%--                <a href="${root}/article/list?pgno=1&key=&word=">글목록</a><br>--%>
<%--                <c:if test="${userinfo.userId eq 'admin'}">--%>
<%--                    <a href="list.html">회원목록</a><br />--%>
<%--                </c:if>--%>
            </div>
        </div>
    </div>
    <script>
        document.querySelector("#btn-post").addEventListener("click", function () {
            if (!document.querySelector("#subject").value) {
                alert("아이디 입력!!");
                return;
            } else if (!document.querySelector("#content").value) {
                alert("비밀번호 입력!!");
                return;
            } else {
                let form = document.querySelector("#form-post");
                form.setAttribute("action", "/api/board-management/post");
                form.submit();
            }
        });
    </script>
</c:if>
<%@include file="./common/footer.jsp"%>