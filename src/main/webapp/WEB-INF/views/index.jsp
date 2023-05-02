
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
<%--    <%@include file="user/loginModal.jsp"%>--%>
</c:if>

<c:if test="${not empty userInfo}">
<%--    <div class="container">--%>
<%--        <div>${userInfo.loginId} ${userInfo.name}</div>--%>
<%--        <!-- 로그인 사용자 정보(로그아웃) 출력 -->--%>
<%--&lt;%&ndash;        <%@ include file="/WEB-INF/views/common/confirm.jsp" %>&ndash;%&gt;--%>
<%--        <div class="row justify-content-center">--%>
<%--            <div class="col-lg-8 col-md-10 col-sm-12">--%>
<%--                <h2 class="my-3 py-3 shadow-sm bg-light text-center">--%>
<%--                    <mark class="orange">RUALONE</mark>--%>
<%--                </h2>--%>
<%--            </div>--%>

<%--            <form id="form-post" method="POST" action="">--%>
<%--                <div class="mb-3">--%>
<%--                    <label for="subject" class="form-label">제목 : </label>--%>
<%--                    <input--%>
<%--                            type="text"--%>
<%--                            class="form-control"--%>
<%--                            id="subject"--%>
<%--                            name="subject"--%>
<%--                    />--%>
<%--                </div>--%>
<%--                <div class="mb-3">--%>
<%--                    <label for="content" class="form-label">내용 : </label>--%>
<%--                    <input--%>
<%--                            type="text"--%>
<%--                            class="form-control"--%>
<%--                            id="content"--%>
<%--                            name="content"--%>
<%--                    />--%>
<%--                </div>--%>
<%--                <div class="col-auto text-center">--%>
<%--                    <button type="button" id="btn-post" class="btn btn-outline-primary mb-3">--%>
<%--                        버어튼--%>
<%--                    </button>--%>
<%--                </div>--%>
<%--            </form>--%>

<%--            <div class="col-lg-8 col-md-10 col-sm-12 text-center">--%>
<%--&lt;%&ndash;                <a href="${root}/article/list?pgno=1&key=&word=">글목록</a><br>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <c:if test="${userinfo.userId eq 'admin'}">&ndash;%&gt;--%>
<%--&lt;%&ndash;                    <a href="list.html">회원목록</a><br />&ndash;%&gt;--%>
<%--&lt;%&ndash;                </c:if>&ndash;%&gt;--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--    <script>--%>
<%--        document.querySelector("#btn-post").addEventListener("click", function () {--%>
<%--            if (!document.querySelector("#subject").value) {--%>
<%--                alert("아이디 입력!!");--%>
<%--                return;--%>
<%--            } else if (!document.querySelector("#content").value) {--%>
<%--                alert("비밀번호 입력!!");--%>
<%--                return;--%>
<%--            } else {--%>
<%--                let form = document.querySelector("#form-post");--%>
<%--                form.setAttribute("action", "/api/board-management/post");--%>
<%--                form.submit();--%>
<%--            }--%>
<%--        });--%>
<%--    </script>--%>
</c:if>
<%@include file="./common/footer.jsp"%>