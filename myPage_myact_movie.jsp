<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import= "com.board.json.*" %>
<%@ page import= "com.board.db.*" %>
    <%
    
    int listSize = 5;
    String tmp = request.getParameter("page");
    int pageNo = (tmp != null && tmp.length() > 0) 
    ? Integer.parseInt(tmp) : 1;
    
    String tmpNum = request.getParameter("pageNum");
    int pageNoNum = (tmpNum != null && tmpNum.length() > 0) 
    ? Integer.parseInt(tmpNum) : 1;
  
    String userId ="";
    if((String)session.getAttribute("userId") != null){
      	userId = (String)session.getAttribute("userId");
		request.setAttribute("bookMark", new BoardDao().selectBookmark(userId, (pageNo-1)*listSize, listSize));
		request.setAttribute("pgnList",new BoardDao().getBookmarkPagination(pageNo, userId));
		
		request.setAttribute("userReview", new BoardDao().selectUserMoiveReview(userId, (pageNoNum-1)*listSize, listSize));
		request.setAttribute("pgnList1",new BoardDao().getUserMovieReviewPagination(pageNoNum, userId));

		
    }

    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/myPage_myact.css"/>
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
                <p>내 북마크</p>
                <div class="content">
                    <div class="poster">
                        <div class="size">
                           	<c:forEach var="release_date" begin="0" end="5" step="1" items="${bookMark}">
				        <a href="content_main.jsp?id=${release_date.data_id}&type=${release_date.type}"><img src="https://image.tmdb.org/t/p/w200/${release_date.poster_path }"></a>
				        </c:forEach>
                       
                        </div>
                    </div>                   
                </div>
                		<div style="width:680px; text-align:center;">
						<c:forEach var="pgn" items="${pgnList}">
   	   					 <a class="pgn" href="myPage_myact.jsp?page=${pgn.pageNo}">
           				  <c:choose>			
              			  <c:when test="${pgn.curPage}">
							<u>${pgn.display}</u>
             			 </c:when>
           				   <c:otherwise>
							  ${pgn.display}		
             		  </c:otherwise>
              		 </c:choose>
         			 </a>&nbsp;
     				 </c:forEach>
  						</div>
                <p>작성한 평가</p>
                              <p>  <a href = "myPage_myact_movie.jsp">MOVIE</a> / <a href = "myPage_myact_tv.jsp" >TV</a></p>
                <c:forEach var= "hype" begin="0" end="5" step="1"  items="${userReview}">
                <div class="eval">
                    <div class="pho">     
				    <a href="content_main.jsp?id=${hype.review_content_id}&type=${hype.type}"><img src="https://image.tmdb.org/t/p/w200/${hype.poster_path}"></a>
                    </div>
                    <div class="since">
                        <div class="star">
							<c:forEach  begin="0" end="${hype.review_star -1}" step="1" >
                   			   <span class= "ss">★</span>
                   			</c:forEach>                       
                        </div>
                        <div class="ymd">
                            <h2>${hype.review_time }</h2>
                        </div>
                    </div>
                    <div class="review">
                       <input type="text" value = "${hype.review_content}">
                    </div>
                </div>
                </c:forEach>
                
      
                <div style="width:680px; text-align:center;">
				<c:forEach var="pgn" items="${pgnList1}">
   	   				 <a class="pgn" href="myPage_myact_movie.jsp?&pageNum=${pgn.pageNo}">
          	   <c:choose>
             	   <c:when test="${pgn.curPage}">
						<u>${pgn.display}</u>
              </c:when>
              <c:otherwise>
					  ${pgn.display}
               </c:otherwise>
               </c:choose>
          </a>&nbsp;
      </c:forEach>
  </div>
            </div>

        </div>
    </div>
    
</body>
</html>