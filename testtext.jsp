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
 
    String userId ="";
    if((String)session.getAttribute("userId") != null){
      	userId = (String)session.getAttribute("userId");
		request.setAttribute("bookMark", new BoardDao().selectBookmark(userId, (pageNo-1)*listSize, listSize));
		request.setAttribute("pgnList", new BoardDao().getBookmarkPagination(pageNo, userId));

    }
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/myPage_myact.css"/>
<title>Insert title here</title>
</head>
<body>
                           	<c:forEach var="release_date" items="${bookMark}">
				        <a href="content_main.jsp?id=${release_date.data_id}&type=${release_date.type}"><img  src="https://image.tmdb.org/t/p/w200/${release_date.poster_path }"></a>
				        </c:forEach>


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

</body>	
</html>	