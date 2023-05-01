<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
	<div class="container-fluid">
		<a class="navbar-brand" id="home" type="button"
			style="color: white; font-weight: 700">R U ALONE</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" id="notification" href="javascript:alert('준비중입니다.');">공지사항</a>
				</li>
				<li class="nav-item"><a class="nav-link active"
					href="javascript:alert('준비중입니다.');">문의사항</a></li>
				<li class="nav-item"><a class="nav-link active" id="board" type="button"
					>게시판</a></li>
				<li class="nav-item"><a
					class="nav-link active disableBtn" id="mypage" type="button"
					>마이 페이지</a></li>
					<li class="nav-item"><a type="button"
					class="nav-link active disableBtn" id="attraction"
					>관광지 검색</a></li>
			</ul>
			<form class="d-flex" role="search">
				<a class="btn btn-outline-light me-2" id="loginBtn" type="button"
					style="width: 180px"> 로그인 </a> <a
					class="btn btn-outline-light me-2" id="signInBtn" type="button"
					style="width: 180px"> 회원가입 </a> <a
					class="btn btn-outline-light me-2 disableBtn"
					id="logoutBtn" type="button" style="width: 180px"> 로그아웃 </a>
			</form>
		</div>
	</div>
</nav>

<%--<script>--%>
<%--	document.querySelector("#home").addEventListener("click", function () {--%>
<%--		location.href = "${root}/index.jsp";--%>
<%--	  });--%>
<%--      document.querySelector("#loginBtn").addEventListener("click", function () {--%>
<%--    	location.href = "${root}/user?action=login";--%>
<%--      });--%>
<%--      document.querySelector("#signInBtn").addEventListener("click", function () {--%>
<%--      	location.href = "${root}/user?action=mvjoin";--%>
<%--        });--%>
<%--      document.querySelector("#logoutBtn").addEventListener("click", function () {--%>
<%--        	location.href = "${root}/user?action=logout";--%>
<%--          });--%>
<%--      document.querySelector("#mypage").addEventListener("click", function () {--%>
<%--      	location.href = "${root}/user?action=mvinfo";--%>
<%--        });--%>
<%--      document.querySelector("#attraction").addEventListener("click", function () {--%>
<%--        	location.href = "${root}/attraction/list.jsp";--%>
<%--          });--%>
<%--      document.querySelector("#mypage").addEventListener("click", function () {--%>
<%--      	location.href = "${root}/user/info.jsp";--%>
<%--        });--%>
<%--      document.querySelector("#board").addEventListener("click", function () {--%>
<%--    	  if(`${login}`=="true"){--%>
<%--        	location.href = "${root}/article?action=list";--%>
<%--    	  }else{--%>
<%--    		  location.href = "${root}/user?action=login";--%>
<%--        	}--%>
<%--          });--%>
<%--      </script>--%>
