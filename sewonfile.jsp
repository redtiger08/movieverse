<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import= "com.board.json.*" %>
<%@ page import="java.sql.*" %>  

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>성남시 동물병원/ 약국 api활용</title>
   <!-- <link rel="stylesheet" href="css/share_party.css"/> -->
</head>
<body>
<%
request.setCharacterEncoding("utf-8");

%> 
    

<div class="main" >
 <table style="background-image: url('http://movieverse17.cafe24.com/img/backimg.png');
			background-repeat: no-repeat;
			background-size: cover;">
     <tr class="menu" style=" position: sticky; 
							  top: 0px;
						      background-color: gray !important;">
         <th style="width:100px;">구별</th>
         <th style="width:100px;">동별</th>
         <th style="width:200px;">사업자명</th>
		 <th style="width:200px;">인허가일자</th>   
		 <th style="width:600px;">소재지도로명주소</th>
         <th style="width:600px;">소재지지번주소</th>
		 <th style="width:200px;">전화번호</th>   
     </tr>     
<%
	
		
    Class.forName("org.mariadb.jdbc.Driver");
     try ( 
         Connection conn = DriverManager.getConnection(
                "jdbc:mariadb://localhost/movieverse17", "movieverse17", "shingu1718!");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from animal_20210624 ");


) {
    while (rs.next()) {       	           
 %>          
     <tr>
         <td><%=rs.getString("구별")%></td>
		 <td><%=rs.getString("동별")%></td>  
         <td><%=rs.getString("사업장명")%></td>
		 <td><%=rs.getDate("인허가일자")%></td>
		 <td><%=rs.getString("소재지도로명주소")%></td>
		 <td><%=rs.getString("소재지지번주소")%></td>  
         <td><%=rs.getString("전화번호")%></td>
		   
     </tr>
 <%          
         }
        
     } catch(Exception e) {
         e.printStackTrace();
     }
 %>
 </table>
 

 	<input type="button" value="글쓰기" onclick="location.href='review_write.jsp'">
	<input type="button" value="메인페이지 이동" onclick="location.href='index.jsp'"> 


 </div>

    
</body>
</html>