<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<div class="row justify-content-center">
    <div class="col-lg-8 col-md-10 col-sm-12">
        <h2 class="my-3 py-3 shadow-sm bg-light text-center">
            <mark class="orange">회원가입</mark>
        </h2>
    </div>
    <div class="col-lg-8 col-md-10 col-sm-12">
        <form id="form-join" method="POST" action="">
            <div class="mb-3">
                <label for="username" class="form-label">이름 : </label>
                <input
                        type="text"
                        class="form-control"
                        id="username"
                        name="name"
                        placeholder="이름..."
                        required
                />
            </div>
            <div class="mb-3">
                <label for="userId" class="form-label">아이디 : </label>
                <input
                        type="text"
                        class="form-control"
                        id="userId"
                        name="loginId"
                        placeholder="아이디..."
                        required
                />
            </div>
            <div id="idcheck-result"></div>
            <div class="mb-3">
                <label for="pwd" class="form-label">비밀번호 : </label>
                <input
                        type="text"
                        class="form-control"
                        id="pwd"
                        name="password"
                        placeholder="비밀번호..."
                        required
                />
            </div>
            <div class="mb-3">
                <label for="pwdCheck" class="form-label">비밀번호확인 : </label>
                <input type="text" class="form-control" id="pwdCheck" placeholder="비밀번호확인..." required/>
            </div>
            <div id="pwcheck-result"></div>
            <div class="mb-3">
                <label for="email" class="form-label">이메일 : </label>
                <div class="input-group">
                    <input
                            type="text"
                            class="form-control"
                            id="email"
                            name="email"
                            placeholder="이메일"
                            required
                    />
                    <span class="input-group-text">@</span>
                    <select
                            class="form-select"
                            id="domain"
                            name="domain"
                            aria-label="이메일 도메인 선택"
                    >
                        <option selected>선택</option>
                        <option value="ssafy.com">싸피</option>
                        <option value="google.com">구글</option>
                        <option value="naver.com">네이버</option>
                        <option value="kakao.com">카카오</option>
                    </select>
                </div>
            </div>

            <div class="col-auto text-center">
                <button type="submit" id="btn-join" class="btn btn-outline-primary mb-3">
                    회원가입
                </button>
                <button type="button" id="btn-reset" class="btn btn-outline-success mb-3">초기화</button>
            </div>
        </form>
    </div>
    <div><a type="button" id = "btn_join_modal_close" onclick="resetForm()">닫기 버튼</a></div>
</div>


<script>
    let isUseId = false;
    document.querySelector("#userId").addEventListener("keyup", function () {
        let userid = this.value;
        let resultDiv = document.querySelector("#idcheck-result");
        if (userid.length < 6 || userid.length > 16) {
            resultDiv.setAttribute("class", "mb-3 text-dark");
            resultDiv.textContent = "아이디는 6자 이상 16자 이하여야합니다.";
            isUseId = false;
        } else {
            fetch("/api/user-management/check/" + userid,{
                method:"get"
            })
                .then(response => response.text())
                .then(data => {
                    console.log(data);
                    if (data=="false") {
                        resultDiv.setAttribute("class", "mb-3 text-primary");
                        resultDiv.textContent = userid + "는 사용할 수 있습니다.";
                        isUseId = true;
                    } else {
                        resultDiv.setAttribute("class", "mb-3 text-danger");
                        resultDiv.textContent = userid + "는 사용할 수 없습니다.";
                        isUseId = false;
                    }
                });
        }
    });

    document.querySelector("#pwdCheck").addEventListener("keyup", function () {
        let pwd = document.getElementById("pwd").value;
        let pwdCheck = document.getElementById("pwdCheck").value;
        let text = document.getElementById("pwcheck-result");
        if (pwdCheck.length == 0) {
            text.innerHTML = "";
        } else if (pwd == pwdCheck) {
            text.innerHTML = `<div class="right">비밀 번호가 일치합니다</div>`;
        } else {
            text.innerHTML = `<div class="wrong">비밀 번호가 일치하지 않습니다</div>`;
        }
    });

    document.querySelector("#btn-join").addEventListener("click",function(){
        let form = document.getElementById("#form_join");
        let data = {
            "name" : document.getElementById("username").value,
            "loginId" : document.getElementById("userId").value,
            "password" : document.getElementById("pwd").value,
            "email" : document.getElementById("email").value,
            "domain" : document.getElementById("domain").value
        };

        fetch("/api/user-management/join",{
            method:"POST",
            headers:{
                "Content-Type":"application/json",
            },
            body: JSON.stringify(data)
        }).then(response => location.href="/");
    })


    function resetForm() {
        let form =document.getElementById("form-join");
        form.reset();
    };

</script>

