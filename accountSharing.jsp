<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import= "com.board.json.*" %>
<%@ page import="java.sql.*" %>  
<%
request.setAttribute("msgList1", new JsonDAO().getMoviePasingData("","&with_genres=27"));
request.setAttribute("msgList2", new JsonDAO().getTvPasingData("", ""));
request.setAttribute("msgList3", new JsonDAO().getTvPasingData("&with_watch_providers=8", ""));
request.setAttribute("msgList4", new JsonDAO().getTvPasingData("&with_watch_providers=337", ""));
request.setAttribute("msgList5", new JsonDAO().getTvPasingData("&with_watch_providers=97", ""));
//with_genres=27
//&with_watch_providers="+aaa+"
//&with_watch_providers=337
//&with_genres=27
String userId = (String)session.getAttribute("userId"); 
request.setAttribute("userId", userId);
String tmp = request.getParameter("bid");
String bid = (tmp != null && tmp.length() > 0) ? tmp : "";
%> 

    
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Swiper -->
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/css/swiper.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/Swiper/4.5.1/js/swiper.min.js"></script>
<script>
document.addEventListener("DOMContentLoaded", function() {

    var mySwiper = new Swiper('.swiper-container', {
        slidesPerView: 6,
        slidesPerGroup: 6,
        observer: true,
        observeParents: true,
        spaceBetween: 24,
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },
        breakpoints: {
            1280: {
                slidesPerView: 6,
                slidesPerGroup: 6,
            },
            720: {
                slidesPerView: 1,
                slidesPerGroup: 1,
            }
        }
    });
    
});
</script>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/accountSharing.css"/>
    <title>MOVIEVERSE</title>
</head>
<body>

    <header class="header">
        <section class="flex">
            <a href="index.jsp" class="logo"><img src="img/logo2.png" alt=""></a>
            <nav class="navbar">
                <a href="movie_main.jsp">??????</a>
                <a href="tv_main.jsp">TV?????????</a>
                <a href="accountSharing.jsp">????????????</a>
            </nav>
                        <div class="navbarRight">
					<form action="SearchData.jsp" method ="get" style="display: flex;">
						<input id="searchInput" type="text" placeholder="?????????/?????????, ?????? ?????? ??????????????????" name="search" size="35" required="required" />
						<input class="serch_Img" name="button" type="image" src="img/searchBtn.png" />
					</form>
  					<c:choose>
					<c:when test="${userId eq null}">
						<a class="login" href="login_main.jsp">?????????</a>
					</c:when>
					<c:otherwise>
						<a class ="login" href="logout.jsp">????????????</a>
					</c:otherwise>
					</c:choose>	
			</div>
		</section>
    </header>
    <div class="banner">
		<img src="img/share_youtube.png" class="youtube">
		<img src="img/share_video.png" class="video">	
    	<h1>OTT ?????? ????????? ??????????????????</h1>
		<img src="img/share_netflix.png" class="netflix">
		<img src="img/share_disney.png" class="disney">
	</div>
     
      <section class="main">
			<h3><img class ="cookie" src ="img/netflix_ss.png"/></h3>
				<div class="swiper-container">
				    <div class="swiper-wrapper">
				    <!-- ?????? ????????? ??? ????????? 20??? ???????????? ???????????? -->
	<%
				Class.forName("org.mariadb.jdbc.Driver");
		try( 
		Connection conn = DriverManager.getConnection(
				"jdbc:mariadb://localhost/movieverse17", "movieverse17", "shingu1718!");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(String.format("select * from shareParty%s where ott_name ='????????????' order by shareParty_num desc ",bid));
		) {
		while (rs.next()) {       	           
 %> 
				        <a href="share_party.jsp?shareParty_num=<%=rs.getInt("shareParty_num")%>&ott_name=????????????"><div class="swiper-slide"><img src ="img/netflix.png" /><div class ="number"><p class ="number1"><%=rs.getInt("shareParty_gauge")%></p><p class ="number2">/4</p></div></div></a>
 <%          
		}
     } catch(Exception e) {
         e.printStackTrace();
     }
 %>				        
				       
				    </div>
				    <div class="swiper-button-next"></div>
				    <div class="swiper-button-prev"></div>
				</div>
				    </section>
				    
      <section class="main">
			<h3><img class ="cookie" src ="img/watcha_ss.png"/></h3>
				<div class="swiper-container">
				    <div class="swiper-wrapper">
				    <!-- ?????? ????????? ??? ????????? 20??? ???????????? ???????????? -->
	<%
				Class.forName("org.mariadb.jdbc.Driver");
		try( 
		Connection conn = DriverManager.getConnection(
				"jdbc:mariadb://localhost/movieverse17", "movieverse17", "shingu1718!");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(String.format("select * from shareParty%s where ott_name ='??????' order by shareParty_num desc ",bid));
		) {
		while (rs.next()) {       	           
 %> 
				        <a href="share_party.jsp?shareParty_num=<%=rs.getInt("shareParty_num")%>&ott_name=??????"><div class="swiper-slide"><img src ="img/watcha.png" /><div class ="number"><p class ="number1"><%=rs.getInt("shareParty_gauge")%></p><p class ="number2">/4</p></div></div></a>
 <%          
		}
     } catch(Exception e) {
         e.printStackTrace();
     }
 %>	
				    </div>
				    <div class="swiper-button-next"></div>
				    <div class="swiper-button-prev"></div>
				</div>
				    </section>
				    
      <section class="main">
			<h3><img class ="cookie2" src ="img/disney_white2.png"/></h3>
				<div class="swiper-container">
				    <div class="swiper-wrapper">
				    <!-- ?????? ????????? ??? ????????? 20??? ???????????? ???????????? -->
	<%
				Class.forName("org.mariadb.jdbc.Driver");
		try( 
		Connection conn = DriverManager.getConnection(
				"jdbc:mariadb://localhost/movieverse17", "movieverse17", "shingu1718!");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(String.format("select * from shareParty%s where ott_name ='??????????????????' order by shareParty_num desc ",bid));
		) {
		while (rs.next()) {       	           
 %> 
				        <a href="share_party.jsp?shareParty_num=<%=rs.getInt("shareParty_num")%>&ott_name=??????????????????"><div class="swiper-slide"><img src ="img/disnep.png" /><div class ="number"><p class ="number1"><%=rs.getInt("shareParty_gauge")%></p><p class ="number2">/4</p></div></div></a>
 <%          
		}
     } catch(Exception e) {
         e.printStackTrace();
     }
 %>		
				    </div>
				    <div class="swiper-button-next"></div>
				    <div class="swiper-button-prev"></div>
				</div>
				    </section>
				    
      <section class="main">
			<h3><img src ="img/wavve_ss.png"/></h3>
				<div class="swiper-container">
				    <div class="swiper-wrapper">
				    <!-- ?????? ????????? ??? ????????? 20??? ???????????? ???????????? -->
	<%
				Class.forName("org.mariadb.jdbc.Driver");
		try( 
		Connection conn = DriverManager.getConnection(
				"jdbc:mariadb://localhost/movieverse17", "movieverse17", "shingu1718!");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(String.format("select * from shareParty%s where ott_name ='?????????' order by shareParty_num desc ",bid));
		) {
		while (rs.next()) {       	           
 %> 
				        <a href="share_party.jsp?shareParty_num=<%=rs.getInt("shareParty_num")%>&ott_name=?????????"><div class="swiper-slide"><img src ="img/wavve_box.png" /><div class ="number"><p class ="number1"><%=rs.getInt("shareParty_gauge")%></p><p class ="number2">/4</p></div></div></a>
 <%          
		}
     } catch(Exception e) {
         e.printStackTrace();
     }
 %>		
				    </div>
				    <div class="swiper-button-next"></div>
				    <div class="swiper-button-prev"></div>
				</div>
				    </section>
					
					

				    

</body>
</html>