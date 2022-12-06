<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String userId = (String)session.getAttribute("userId"); 
    String userName = (String)session.getAttribute("userName");
    String userNick = (String)session.getAttribute("userNick");
    String userAddr = (String)session.getAttribute("userAddr");
    int userNum = (Integer)session.getAttribute("userNum");
    request.setAttribute("userId", userId);
    request.setAttribute("userName", userName);
    request.setAttribute("userNick", userNick);
    request.setAttribute("userAddr", userAddr);
    request.setAttribute("userNum", userNum);

    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/myPage.css"/>
<title>MOVIEVERSE</title>
</head>
<body>
    <header class="header">
        <section class="flex">
            <a href="index.jsp" class="logo"><img src="img/logo2.png" alt=""></a>
		</section>
    </header>
    <div class="main">
        <div class="left">
            <div class="photo">
<!--                 <img src="img/act.png">
 -->            </div>
            <div class="page">
                <a href="myPage.jsp">내 프로필</a>
                <a href="myPage_myact_movie.jsp">내 활동</a>
                <a href="myPage_share.jsp">계정 공유</a>
            </div>
        </div>
        <div class="right">
            <div class="id">
                <p>계정</p>
                <div class="content">
                    <div class="nick">
                        <h2>${userName }</h2>
                        <h2>${userId }</h2>
                        <h2>********</h2>
                        <h2>${userAddr}</h2>

                    </div>
                    <div class="change">
                        <a href="">닉네임 변경</a>
                        <a href="">계정 변경</a>
                        <a href="">비밀번호 변경</a>
                        <a href="">주소 변경</a>
                    </div>                   
                </div>
                <p>포인트</p>
                <div class="point">
                    <div class="mypoint">                       
                       <h2>내 포인트 : 222</h2>                        
                    </div>
                    <div class="charge">
                        <a href="">충전하기</a>
                    </div>
                </div>
            </div>

        </div>
    </div>
</body>
</html>