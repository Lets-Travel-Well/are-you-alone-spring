<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<c:set var="posts"></c:set>
<%@include file="../common/header.jsp" %>
<title>게시글 리스트</title>

</head>
<body>
<%@include file="../common/nav.jsp"%>
<div class="row justify-content-center">
    <div class="col-lg-8 col-md-10 col-sm-12">
        <h2 class="my-3 py-3 shadow-sm bg-light text-center">
            <mark class="sky">자유 게시판</mark>
        </h2>
    </div>
    <div class="col-lg-8 col-md-10 col-sm-12">
        <div class="row align-self-center mb-2">
            <div class="col-md-2 text-start">
                <button type="button" id="btn-mv-register" class="btn btn-outline-primary btn-sm">
                    글쓰기
                </button>
            </div>
            <div class="col-md-7 offset-3">
                <form class="d-flex" id="form-search" action="">
                    <input type="hidden" name="action" value="list"/>
                    <input type="hidden" name="pgno" value="1"/>
                    <select
                            name="key"
                            id="key"
                            class="form-select form-select-sm ms-5 me-1 w-50"
                            aria-label="검색조건"
                    >
                        <option value="article_no">글번호</option>
                        <option value="subject">제목</option>
                        <option value="user_id">작성자</option>
                    </select>
                    <div class="input-group input-group-sm">
                        <input type="text" name="word" id="word" class="form-control" placeholder="검색어..."/>
                        <button id="btn-search" class="btn btn-dark" type="button">검색</button>
                    </div>
                </form>
            </div>
        </div>
        <table class="table table-hover">
            <thead>
            <tr class="text-center">
                <th scope="col">글번호</th>
                <th scope="col">작성자</th>
                <th scope="col">제목</th>
                <th scope="col">내용</th>
                <th scope="col">조회수</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="post" items="${postList}">
                <tr class="text-center">
                    <th scope="row">${post.id}</th>
                    <td class="text-start">
                        <a
                                href="#"
                                class="article-title link-dark"
                                data-no="${post.id}"
                                style="text-decoration: none"
                        >
                                ${post.memberId}
                        </a>
                    </td>
                    <td>${post.subject}</td>
                    <td>${post.content}</td>
                    <td>${post.hit}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="row">
        ${navigation.navigator}
    </div>
</div>
</div>

<form id="form-param" method="get" action="">
    <input type="hidden" id="p-action" name="action" value="">
    <input type="hidden" id="p-pgno" name="pgno" value="">
    <input type="hidden" id="p-key" name="key" value="">
    <input type="hidden" id="p-word" name="word" value="">
</form>


<script>
    let titles = document.querySelectorAll(".article-title");
    titles.forEach(function (title) {
        title.addEventListener("click", function () {
            console.log(this.getAttribute("data-no"));
            location.href = "${root}/article?action=view&articleno=" + this.getAttribute("data-no");
        });
    });

    document.querySelector("#btn-mv-register").addEventListener("click", function () {
        location.href = "/post/write";
    });

    document.querySelector("#btn-search").addEventListener("click", function () {
        let form = document.querySelector("#form-search");
        form.setAttribute("action", "${root}/article");
        form.submit();
    });

    let pages = document.querySelectorAll(".page-link");
    pages.forEach(function (page) {
        page.addEventListener("click", function () {
            console.log(this.parentNode.getAttribute("data-pg"));
            document.querySelector("#p-action").value = "list";
            document.querySelector("#p-pgno").value = this.parentNode.getAttribute("data-pg");
            document.querySelector("#p-key").value = "${param.key}";
            document.querySelector("#p-word").value = "${param.word}";
            document.querySelector("#form-param").submit();
        });
    });
</script>
</body>
</html>