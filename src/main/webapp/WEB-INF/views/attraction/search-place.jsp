<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<%@include file="../common/header.jsp"%>
<title>RUALONE</title>
<%--<script>--%>
<%--    function getSido(){--%>
<%--        fetch("/api/attraction-management/sido",{--%>
<%--            method: "GET"--%>
<%--        }).then((response) => response.json()).then((data) => {console.log(data.response)})--%>
<%--    }--%>
<%--    --%>
<%--</script>--%>
<script>
    function getSido() {
        fetch("/api/attraction-management/sido", {
            method: "GET"
        })
            .then(response => response.json())
            .then(data => {
                // 서버로부터 받은 JSON 데이터를 sidos 변수에 할당
                const sidos = data.response;
                const select = document.getElementById("search-area");
                // sidos 배열의 각 요소를 option 요소로 만들어 select 요소에 추가
                sidos.forEach(sido => {
                    const option = document.createElement("option");
                    option.value = sido.sidoCode;
                    option.textContent = sido.sidoName;
                    select.appendChild(option);
                });
            });
    }

</script>
</head>
<body onload="getSido()">
<%@include file="../common/nav.jsp"%>
<!-- 관광지 검색 start -->
<center>
    <section class="page-section p-3 mt-3" id="search-place">
        <div class="text-center fw-bold w-75" role="alert">
            <h2 class="section-heading text-uppercase">Travel Information</h2>
            <h3 class="section-subheading text-muted">
                원하는 여행지를 검색해보세요.
            </h3>

            <!-- 관광지 검색 start -->
            <form class="mb-3 d-flex justify-content-center" onsubmit="return false;" role="search">
                <div class="col-3 m-1 ms-5">
                    <select id="search-area" class="form-select me-2 shadow">
                        <option value="0" selected>검색 할 시도</option>
                    </select>
                </div>
                <div class="col-3 m-1">
                    <select id="search-sigun" class="form-select me-2 shadow">
                        <option value="0" selected>검색 할 구군</option>
                    </select>
                </div>
                <div class="col-3 mt-1 ms-1">
                    <select id="search-content-id" class="form-select me-2 shadow bg-gradient"
                            style="background-color: #fefaea">
                        <option value="0" selected>컨텐츠 선택</option>
                        <option value="12">관광지</option>
                        <option value="14">문화시설</option>
                        <option value="15">축제공연행사</option>
                        <option value="25">여행코스</option>
                        <option value="28">레포츠</option>
                        <option value="32">숙박</option>
                        <option value="38">쇼핑</option>
                        <option value="39">음식점</option>
                    </select>

                </div>
                <div class="col-2 mt-1" >
                    <button id="btn-search" class="btn btn-outline-success shadow" type="button">
                        Search
                    </button>
                </div>
            </form>

            <!-- kakao map start -->
            <div id="map" class="mt-3 shadow" style="width: 100%; height: 600px"></div>
            <!-- kakao map end -->

        </div>
    </section>
</center>
<%@include file="../common/footer.jsp"%>
<script type="text/javascript"
        src="//dapi.kakao.com/v2/maps/sdk.js?appkey=65e66ed3a412cb73e32b300c2f3a1803&libraries=services,clusterer,drawing"></script>
<script>
    let sel = document.getElementById("search-sigun");
    // 지역 이 선택된 경우
    document.getElementById("search-area").addEventListener("change", function () {
    // 지역이 변경된 경우
        let areaCode = document.getElementById("search-area").value;

        if (areaCode != 0) {
            sel.innerHTML = '<option value="0" selected>검색 할 구군</option>';
            let sigunAreaUrl = "/api/attraction-management/gugun/" + areaCode;
            fetch(sigunAreaUrl, { method: 'GET' })
                .then((response) => response.json())
                .then((data) => {
                    // 서버로부터 받은 JSON 데이터를 sidos 변수에 할당
                    const guguns = data.response;
                    const select = document.getElementById("search-sigun");
                    // sidos 배열의 각 요소를 option 요소로 만들어 select 요소에 추가
                    guguns.forEach(gugun => {
                        const option = document.createElement("option");
                        option.value = gugun.gugunCode;
                        option.textContent = gugun.gugunName;
                        select.appendChild(option);
                    });
                });
        } else {
            sel.innerHTML = '<option value="0" selected>검색 할 구군</option>';
        }
    })
    function getSido() {
        fetch("/api/attraction-management/sido", {
            method: "GET"
        })
            .then(response => response.json())
            .then(data => {
                // 서버로부터 받은 JSON 데이터를 sidos 변수에 할당
                const sidos = data.response;
                const select = document.getElementById("search-area");
                // sidos 배열의 각 요소를 option 요소로 만들어 select 요소에 추가
                sidos.forEach(sido => {
                    const option = document.createElement("option");
                    option.value = sido.sidoCode;
                    option.textContent = sido.sidoName;
                    select.appendChild(option);
                });
            });
    }
    document.getElementById("btn-search").addEventListener("click", () => {
        let searchUrl = "/api/attraction-management/attraction";

        let sidoCode = document.getElementById("search-area").value;
        let gugunCode = document.getElementById("search-sigun").value;
        let contentTypeId = document.getElementById("search-content-id").value;

        if (parseInt(sidoCode)) {
            searchUrl = searchUrl + `?sidoCode=` + sidoCode;
        } else {
            alert("지역을 선택해주세요.");
        }
        if (parseInt(gugunCode)) {
            searchUrl = searchUrl + `&gugunCode=` + gugunCode;
        } else {
            alert("시군을 선택해주세요.");
        }
        if (parseInt(contentTypeId)) {
            searchUrl = searchUrl + `&contentTypeId=${contentTypeId}` + contentTypeId;
        } else {
            alert('컨텐츠를 선택해주세요.');
        }

        fetch(searchUrl)
            .then((response) => response.json())
            .then((data) => {
                console.log(data.response)
                makeList(data)
                }
            );

    });

    // 카카오지도
    var mapContainer = document.getElementById("map"), // 지도를 표시할 div
        mapOption = {
            center: new kakao.maps.LatLng(37.500613, 127.036431), // 지도의 중심좌표
            level: 5, // 지도의 확대 레벨
        };



    var positions; // marker 배열.
    function makeList(data) {
        //  응답받은 json data = > postion
        let trips = data; // trips => 여행지 정보들 출력
        positions = [];
        console.log(data);
        trips.forEach((area) => {
            // title, addr1, zipcode, firstImage, latitude, longitude,
            let markerInfo = {
                contentId: area.contentId,
                like: area.scrap,
                title: area.title,
                addr1: area.addr1,
                zipcode: area.zipcode,
                firstImage: area.firstImage,
                latlng: new kakao.maps.LatLng(area.latitude, area.longitude),
            };
            positions.push(markerInfo);
        });
        displayMarker();
    }

    // 카카오지도
    var mapContainer = document.getElementById("map"), // 지도를 표시할 div
        mapOption = {
            center: new kakao.maps.LatLng(37.500613, 127.036431), // 지도의 중심좌표
            level: 5, // 지도의 확대 레벨
        };



    // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
    var map = new kakao.maps.Map(mapContainer, mapOption);

    var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";
    var imageSize = new kakao.maps.Size(24, 35);
    var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);
    var user = document.getElementById("user").innerText;

    var ovList= [];
    var markerList = [];
    function displayMarker() {
        // 마커 이미지의 이미지 주소입니다

        for (var i = 0; i < positions.length; i++) {

            // 마커를 생성합니다
            let marker = new kakao.maps.Marker({
                map: map, // 마커를 표시할 지도
                position: positions[i].latlng, // 마커를 표시할 위치
            });
            markerList[i] = marker;

            let content= '<div class="wrap">' +
                '    <div class="info  shadow ">' +
                '        <div class="bg-primary ">' +
                '        		<div class="text-light font-weight-bold p-1 d-flex justify-content-between">' +
                positions[i].title +
                '         		<div class="far fa-times-circle fa-lg" onclick="closeOverlay('+i+')" title="닫기"></div>' +
                '        		</div>'+
                '		   </div>' +
                '        <div class="body">' +
                '            <div class="img">' +
                '                <img src="'+positions[i].firstImage+'" width="73" height="70">' +
                '           </div>' +
                '            <div class="desc">' +
                '                <div class="ellipsis">'+positions[i].addr1+'</div>' +
                '                <div class="jibun ellipsis">(우)'+positions[i].zipcode+'</div>' +
                '                <div class="d-flex justify-content-end">';

            if(user != "" && positions[i].like == false) {
                content += '<button id="btn-scrap" class="btn btn-outline-warning d-flex justify-content-center p-1 m-2" type="button" onclick="like('+i+')"> like </button>';
            } else if(user != "" && positions[i].like == true) {
                marker.setImage(markerImage);
                content += '<button id="btn-scrap" class="btn btn-outline-danger d-flex justify-content-center p-1 m-2" type="button" onclick="like('+i+')"> dislike </button>';
            }

            content +=
                '                </div>' +
                '            </div>' +
                '        </div>' +
                '    </div>' +
                '</div>';



            // 마커 위에 커스텀오버레이를 표시합니다
            // 마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
            let overlay = new kakao.maps.CustomOverlay({
                content: content,
                position: marker.getPosition()
            });

            kakao.maps.event.addListener(marker, 'click', function () {
                overlay.setMap(map);
            });
            ovList[i] = overlay;


        }
        // 첫번째 검색 정보를 이용하여 지도 중심을 이동 시킵니다
        map.setCenter(positions[0].latlng);
    }

    function closeOverlay(i) {
        ovList[i].setMap(null);
    }

    // 좋아요 버튼 클릭

    function like(i) {


        var url = root + "/myattraction?action=like&contentId=" + positions[i].contentId;
        console.log(url);

        //likeToUnlike(i);
        fetch(url)
            .then((response) => response.json())
            .then((data) => {
                    console.log(data);
                    if (data == true) {
                        likeToUnlike(i);
                    } else {
                        unlikeToLike(i);
                    }
                }
            );
    }

    function unlikeToLike(i) {
        markerList[i].setImage(null);

        let content = '<div class="wrap">' +
            '    <div class="info  shadow ">' +
            '        <div class="bg-primary ">' +
            '        		<div class="text-light font-weight-bold p-1 d-flex justify-content-between">' +
            positions[i].title +
            '         		<div class="far fa-times-circle fa-lg" onclick="closeOverlay('+i+')" title="닫기"></div>' +
            '        		</div>'+
            '		   </div>' +
            '        <div class="body">' +
            '            <div class="img">' +
            '                <img src="'+positions[i].firstImage+'" width="73" height="70">' +
            '           </div>' +
            '            <div class="desc">' +
            '                <div class="ellipsis">'+positions[i].addr1+'</div>' +
            '                <div class="jibun ellipsis">(우)'+positions[i].zipcode+'</div>' +
            '                <div class="d-flex justify-content-end">' +
            '				   <button id="btn-scrap" class="btn btn-outline-warning d-flex justify-content-center p-1 m-2" type="button" onclick="like('+i+')"> like </button>' +
            '                </div>' +
            '            </div>' +
            '        </div>' +
            '    </div>' +
            '</div>';

        // 마커 위에 커스텀오버레이를 표시합니다
        // 마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
        ovList[i].setContent(content);


//    kakao.maps.event.addListener(markerList[i], 'click', function () {
//    	ovList[i].setMap(map);
//    });
    }

    function likeToUnlike(i) {



        markerList[i].setImage(markerImage);

        let content = '<div class="wrap">' +
            '    <div class="info  shadow ">' +
            '        <div class="bg-primary ">' +
            '        		<div class="text-light font-weight-bold p-1 d-flex justify-content-between">' +
            positions[i].title +
            '         		<div class="far fa-times-circle fa-lg" onclick="closeOverlay('+i+')" title="닫기"></div>' +
            '        		</div>'+
            '		   </div>' +
            '        <div class="body">' +
            '            <div class="img">' +
            '                <img src="'+positions[i].firstImage+'" width="73" height="70">' +
            '           </div>' +
            '            <div class="desc">' +
            '                <div class="ellipsis">'+positions[i].addr1+'</div>' +
            '                <div class="jibun ellipsis">(우)'+positions[i].zipcode+'</div>' +
            '                <div class="d-flex justify-content-end">' +
            '				   <button id="btn-scrap" class="btn btn-outline-danger d-flex justify-content-center p-1 m-2" type="button" onclick="like('+i+')"> dislike </button>' +
            '                </div>' +
            '            </div>' +
            '        </div>' +
            '    </div>' +
            '</div>';

        // 마커 위에 커스텀오버레이를 표시합니다
        // 마커를 중심으로 커스텀 오버레이를 표시하기위해 CSS를 이용해 위치를 설정했습니다
        ovList[i].setContent(content);


    //    kakao.maps.event.addListener(markerList[i], 'click', function () {
    //    	ovList[i].setMap(map);
    //    });
</script>