package com.board.db;

import java.sql.*;
import java.time.*;
import java.util.ArrayList;
public class BoardDao {
	private static final int paginationSize = 3;
	private static final int listSize = 5;


	private Connection getConnection() throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		return DriverManager.getConnection(
                "jdbc:mariadb://localhost/movieverse17", "movieverse17", "shingu1718!");
	}
	
	private String getCurrentTime() {
		return LocalDate.now() + " " + LocalTime.now().toString().substring(0,10);
	}
	
    public void insertReviewMovie(String nickname, String userId, int userNum, String review, int reviewStar, String id, String poster_path, String type) {
    	try (		
		Connection conn = getConnection();
    	Statement stmt = conn.createStatement();
		) {
			stmt.executeUpdate(String.format(
					"insert into movie_review (m_review_star, member_num, m_review_content, m_review_time, m_review_content_id, member_nick, member_id, poster_path, type)" +
								"values ('%d', '%d', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",reviewStar, userNum, review, getCurrentTime(), id, nickname, userId, poster_path, type ));
		} catch(Exception e){
			e.printStackTrace();
		} 
	}
    
    public void insertReviewTv(String nickname, String userId, int userNum, String review, int reviewStar, String id, String poster_path, String type) {
    	try (		
		Connection conn = getConnection();
    	Statement stmt = conn.createStatement();
		) {
			
			stmt.executeUpdate(String.format(
					"insert into tv_review (t_review_star, member_num, t_review_content, t_review_time, t_review_content_id, member_nick, member_id, poster_path, type)" +
								"values ('%d', '%d', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",reviewStar, userNum, review, getCurrentTime(), id , nickname, userId, poster_path, type ));
		} catch(Exception e){
			e.printStackTrace();
		} 
	}
    
    public ArrayList<BoardDto> selectMovieReview(String id, int start, int limit) {
    	ArrayList<BoardDto> dtoList = new ArrayList<BoardDto>();
    	     try ( 
    	         Connection conn = getConnection();
    	         Statement stmt = conn.createStatement();
    	         ResultSet rs = stmt.executeQuery(String.format("select * from movie_review where m_review_content_id='%s' limit %d, %d", id, start, limit));
    	     ) {
    	         while (rs.next()) {
    	         	BoardDto dto= new BoardDto();

    	        	 dto.setReview_star(rs.getInt("m_review_star"));
    	        	 dto.setMember_Num(rs.getInt("member_num"));
    	        	 dto.setReview_time(rs.getString("m_review_time"));
    	        	 dto.setReview_content_id(rs.getString("m_review_content_id"));
    	        	 dto.setReview_content(rs.getString("m_review_content"));
    	        	 dto.setMember_nick(rs.getString("member_nick"));

    	        	 dtoList.add(dto);
    	         }
    	         
    	     } catch(Exception e) {
    	         e.printStackTrace();
    	     }
    	     return dtoList;
    }
    public ArrayList<BoardDto> selectTvReview(String id, int start, int limit) {
    	ArrayList<BoardDto> dtoList = new ArrayList<BoardDto>();
    	     try ( 
    	         Connection conn = getConnection();
    	         Statement stmt = conn.createStatement();
    	         ResultSet rs = stmt.executeQuery(String.format("select * from tv_review where t_review_content_id='%s' limit %d, %d", id, start, limit));
    	     ) {
    	         while (rs.next()) {
    	         	BoardDto dto= new BoardDto();

    	        	 dto.setReview_star(rs.getInt("t_review_star"));
    	        	 dto.setMember_Num(rs.getInt("member_num"));
    	        	 dto.setReview_time(rs.getString("t_review_time"));
    	        	 dto.setReview_content_id(rs.getString("t_review_content_id"));
    	        	 dto.setReview_content(rs.getString("t_review_content"));
    	        	 dto.setMember_nick(rs.getString("member_nick"));

    	        	 dtoList.add(dto);
    	         }
    	         
    	     } catch(Exception e) {
    	         e.printStackTrace();
    	     }
    	     return dtoList;
    }
    
    // movie ????????? tv ????????? ??? ?????? ???????????? time?????? ???????????? ????????? ????????? 
    // 2?????? ???????????? time????????? ???????????? ?????? ?????? ?????? 
    // ????????? ?????? ??????????????? ????????? ???. 
    public ArrayList<BoardDto> selectUserMoiveReview(String userId, int start, int limit) {
    	ArrayList<BoardDto> dtoList = new ArrayList<BoardDto>();
    	     try ( 
    	         Connection conn = getConnection();
    	         Statement stmt = conn.createStatement();
    	         ResultSet rs = stmt.executeQuery(String.format("select * from movie_review where member_id='%s' limit %d, %d", userId, start, limit));

    	     ) {
    	    	 while (rs.next()) {
    	         	BoardDto dto= new BoardDto();

    	         	dto.setReview_star(rs.getInt("m_review_star"));
    	         	dto.setMember_Num(rs.getInt("member_num"));
    	         	dto.setReview_time(rs.getString("m_review_time"));
    	         	dto.setReview_content_id(rs.getString("m_review_content_id"));
    	         	dto.setPoster_path(rs.getString("poster_path"));
    	         	dto.setType(rs.getString("type"));
    	         	dto.setReview_content(rs.getString("m_review_content"));
    	         	dto.setMember_nick(rs.getString("member_nick"));
    	         	dtoList.add(dto);

    	         }
    	         
    	     } catch(Exception e) {
    	         e.printStackTrace();
    	     }
    	     return dtoList;
    }
    
    public ArrayList<BoardDto> selectUserTvReview(String userId, int start, int limit) {
    	ArrayList<BoardDto> dtoList = new ArrayList<BoardDto>();
    	     try ( 
    	         Connection conn = getConnection();
    	         Statement stmt = conn.createStatement();
    	         ResultSet rs = stmt.executeQuery(String.format("select * from tv_review where member_id='%s' limit %d, %d", userId, start, limit));

    	     ) {
    	    	 while (rs.next()) {
    	         	BoardDto dto= new BoardDto();

    	         	dto.setReview_star(rs.getInt("t_review_star"));
    	         	dto.setMember_Num(rs.getInt("member_num"));
    	         	dto.setReview_time(rs.getString("t_review_time"));
    	         	dto.setReview_content_id(rs.getString("t_review_content_id"));
    	         	dto.setPoster_path(rs.getString("poster_path"));
    	         	dto.setType(rs.getString("type"));
    	         	dto.setReview_content(rs.getString("t_review_content"));
    	         	dto.setMember_nick(rs.getString("member_nick"));

    	         	dtoList.add(dto);

    	         }
    	         
    	     } catch(Exception e) {
    	         e.printStackTrace();
    	     }
    	     return dtoList;
    }
    

    public ArrayList<Pagination> getUserMovieReviewPagination(int pageNo, String userId) {
     
    	ArrayList<Pagination> pgnList = new ArrayList<Pagination>();
        int numRecords = new BoardDao().getUserMovieNumRecords(userId);
  
    	int numPages = (int)Math.ceil((double)numRecords / listSize);

    	int firstLink = ((pageNo - 1) / paginationSize) 
    			* paginationSize + 1;
    	int lastLink = firstLink + paginationSize - 1;
    	if (lastLink > numPages) {
    		lastLink = numPages;
    	}

    	if (firstLink > 1) {
    		pgnList.add(new Pagination("??????", firstLink - 1, false));
    	}

    	for (int i = firstLink; i <= lastLink; i++) {
    		pgnList.add(new Pagination("" + i, i, i == pageNo));
    	}

    	if (lastLink < numPages) {
    		pgnList.add(new Pagination("??????", lastLink + 1, false));
    	}
    	return pgnList;
    }
    
    public int getUserMovieNumRecords(String userId) {
        int numRecords = 0;
        try (
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
        	
            ResultSet rs = stmt.executeQuery("select count(*) from movie_review where member_id="+userId);
        ) {
            if (rs.next()) {
                numRecords =  rs.getInt(1);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return numRecords;
    }
    
    public ArrayList<Pagination> getUserTvReviewPagination(int pageNo, String userId) {
        
    	ArrayList<Pagination> pgnList = new ArrayList<Pagination>();
        int numRecords = new BoardDao().getUserTvNumRecords(userId);
  
    	int numPages = (int)Math.ceil((double)numRecords / listSize);

    	int firstLink = ((pageNo - 1) / paginationSize) 
    			* paginationSize + 1;
    	int lastLink = firstLink + paginationSize - 1;
    	if (lastLink > numPages) {
    		lastLink = numPages;
    	}

    	if (firstLink > 1) {
    		pgnList.add(new Pagination("??????", firstLink - 1, false));
    	}

    	for (int i = firstLink; i <= lastLink; i++) {
    		pgnList.add(new Pagination("" + i, i, i == pageNo));
    	}

    	if (lastLink < numPages) {
    		pgnList.add(new Pagination("??????", lastLink + 1, false));
    	}
    	return pgnList;
    }
    
    public int getUserTvNumRecords(String userId) {
        int numRecords = 0;
        try (
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
        	
        		//????????????
            ResultSet rs = stmt.executeQuery("select count(*) from tv_review where member_id="+userId);
        ) {
            if (rs.next()) {
                numRecords =  rs.getInt(1);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return numRecords;
    }
    
    
    public int getMovieNumRecords(String id) {
        int numRecords = 0;
        try (
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
        	
            ResultSet rs = stmt.executeQuery("select count(*) from movie_review where m_review_content_id="+id);
        ) {
            if (rs.next()) {
                numRecords =  rs.getInt(1);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return numRecords;
    }
    
    public int getTvNumRecords(String id) {
        int numRecords = 0;
        try (
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
        	
            ResultSet rs = stmt.executeQuery("select count(*) from tv_review where t_review_content_id="+id);
        ) {
            if (rs.next()) {
                numRecords =  rs.getInt(1);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return numRecords;
    }
    
    
    public ArrayList<Pagination> getMoviePagination(int pageNo, String id) {
     
    	ArrayList<Pagination> pgnList = new ArrayList<Pagination>();
        int numRecords = new BoardDao().getMovieNumRecords(id);
  
    	int numPages = (int)Math.ceil((double)numRecords / listSize);

    	int firstLink = ((pageNo - 1) / paginationSize) 
    			* paginationSize + 1;
    	int lastLink = firstLink + paginationSize - 1;
    	if (lastLink > numPages) {
    		lastLink = numPages;
    	}

    	if (firstLink > 1) {
    		pgnList.add(new Pagination("??????", firstLink - 1, false));
    	}

    	for (int i = firstLink; i <= lastLink; i++) {
    		pgnList.add(new Pagination("" + i, i, i == pageNo));
    	}

    	if (lastLink < numPages) {
    		pgnList.add(new Pagination("??????", lastLink + 1, false));
    	}
    	return pgnList;
    }

    
    public ArrayList<Pagination> getTvPagination(int pageNo, String id) {
     
    	ArrayList<Pagination> pgnList = new ArrayList<Pagination>();
        int numRecords = new BoardDao().getTvNumRecords(id);
  
    	int numPages = (int)Math.ceil((double)numRecords / listSize);

    	int firstLink = ((pageNo - 1) / paginationSize) 
    			* paginationSize + 1;
    	int lastLink = firstLink + paginationSize - 1;
    	if (lastLink > numPages) {
    		lastLink = numPages;
    	}

    	if (firstLink > 1) {
    		pgnList.add(new Pagination("??????", firstLink - 1, false));
    	}

    	for (int i = firstLink; i <= lastLink; i++) {
    		pgnList.add(new Pagination("" + i, i, i == pageNo));
    	}

    	if (lastLink < numPages) {
    		pgnList.add(new Pagination("??????", lastLink + 1, false));
    	}
    	return pgnList;
    }

	public void setBookmark(String id, String userId, String poster_path, String type) {
		try (		
				Connection conn = getConnection();
		    	Statement stmt = conn.createStatement();
				) {
					stmt.executeUpdate(String.format(
							"insert into mark (member_id, poster_path, mark_time, type, data_id)" +
										"values ('%s', '%s', '%s', '%s', '%s')",userId, poster_path, getCurrentTime(), type, id));
				} catch(Exception e){
					e.printStackTrace();
				} 
	}

	
	
	public void deleteBookmark(String id, String userId) {
	try (	
			Connection	conn = getConnection();
			 Statement stmt = conn.createStatement();
	) {
		stmt.executeUpdate(String.format("delete from mark where member_id='%s' and data_id='%s'", userId, id));

	} catch(Exception e){
		e.printStackTrace();
	} 
	
}


    public void checkBookmark(String id, String userId, String poster_path, String type) {
    	     try ( 
    	         Connection conn = getConnection();
    	         Statement stmt = conn.createStatement();
    	         ResultSet rs = stmt.executeQuery(String.format("select * from mark where member_id='%s' and data_id='%s'", userId, id));
    	     ) {
    	         if (rs.next()) {
    	        	 deleteBookmark(id, userId);
    	         }else {
    	        	 setBookmark(id, userId, poster_path, type);
    	         }
    	         
    	     } catch(Exception e) {
    	         e.printStackTrace();
    	     }
    }
    
    public ArrayList<BoardDto> selectBookmark(String userId, int start, int limit) {
    	ArrayList<BoardDto> dtoList = new ArrayList<BoardDto>();
    	     try ( 
    	         Connection conn = getConnection();
    	         Statement stmt = conn.createStatement();
    	         ResultSet rs = stmt.executeQuery(String.format("select * from mark where member_id='%s' limit %d, %d", userId, start, limit));
    	     ) {
    	         while (rs.next()) {
    	         	BoardDto dto= new BoardDto();

    	        	 dto.setPoster_path(rs.getString("poster_path"));
    	        	 dto.setMark_time(rs.getString("mark_time"));
    	        	 dto.setType(rs.getString("type"));
    	        	 dto.setData_id(rs.getString("data_id"));
    	        	 dto.setMember_id(rs.getString("member_id"));

    	        	 dtoList.add(dto);
    	         }
    	         
    	     } catch(Exception e) {
    	         e.printStackTrace();
    	     }
    	     return dtoList;
    }
    
    public int getBookmarkNumRecords(String userId) {
        int numRecords = 0;
        try (
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
        	
        		//????????????
            ResultSet rs = stmt.executeQuery("select count(*) from mark where member_id="+userId);
        ) {
            if (rs.next()) {
                numRecords =  rs.getInt(1);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return numRecords;
    }
    
    public ArrayList<Pagination> getBookmarkPagination(int pageNo, String userId) {
        
    	ArrayList<Pagination> pgnList = new ArrayList<Pagination>();
        int numRecords = new BoardDao().getBookmarkNumRecords(userId);
  
    	int numPages = (int)Math.ceil((double)numRecords / listSize);

    	int firstLink = ((pageNo - 1) / paginationSize) 
    			* paginationSize + 1;
    	int lastLink = firstLink + paginationSize - 1;
    	if (lastLink > numPages) {
    		lastLink = numPages;
    	}

    	if (firstLink > 1) {
    		pgnList.add(new Pagination("??????", firstLink - 1, false));
    	}

    	for (int i = firstLink; i <= lastLink; i++) {
    		pgnList.add(new Pagination("" + i, i, i == pageNo));
    	}

    	if (lastLink < numPages) {
    		pgnList.add(new Pagination("??????", lastLink + 1, false));
    	}
    	return pgnList;
    }
    //////////////////////////////
    public void setShareHeader(int userNum, String bank, String accountNum, String userId) {
        try (      
              Connection conn = getConnection();
               Statement stmt = conn.createStatement();
              ) {
                 stmt.executeQuery(String.format(
                 "insert into shareHeader (member_num, shareHeader_bankName, shareHeader_accountNum, member_id) values (%d,'%s','%s','%s');",
                userNum, bank, accountNum, userId));
              } catch(Exception e){
                 e.printStackTrace();
              } 
     }
      
     public void setShareParty(int userNum, int ottprice, String selectOption) {
        try (      
              Connection conn = getConnection();
               Statement stmt = conn.createStatement();
              ) {
                 String curTime = LocalDate.now() +  LocalTime.now().toString().substring(0,8);
                 stmt.executeQuery(String.format(
                 "insert into shareParty (header_num, ottprice, ott_name,shareParty_time, shareParty_gauge) values (%d, %d,'%s', '%s', 1);",
                userNum, ottprice, selectOption, curTime));
              } catch(Exception e){
                 e.printStackTrace();
              } 
     }
     
     public void setShareMember(int userNum, int shareParty_num) {
        try (      
              Connection conn = getConnection();
               Statement stmt = conn.createStatement();
              ) {
                 stmt.executeQuery(String.format(
                 "insert into shareMember (member_num, shareParty_num) values (%d,%d);",
                userNum, shareParty_num));
              } catch(Exception e){
                 e.printStackTrace();
              } 
     }
      
     public void setPartyUpdate(int shareParty_gauge) {
        try (      
              Connection conn = getConnection();
               Statement stmt = conn.createStatement();
              ) {
                 
                 stmt.executeUpdate(String.format(
                 "update shareParty set shareParty_gauge =%d",
                             shareParty_gauge));
              } catch(Exception e){
                 e.printStackTrace();
              } 
     }
    

}

    
//	public void deleteOne(int num) {
//		try (	
//				Connection	conn = getConnection();
//				 Statement stmt = conn.createStatement();
//		) {
//			stmt.executeUpdate("delete from board where num="+num);
//
//		} catch(Exception e){
//			e.printStackTrace();
//		} 
//		
//	}



			
//	public Boolean setTvBookmark(String id, String userId, String poster_path, String type) {
//		try (		
//				Connection conn = getConnection();
//		    	Statement stmt = conn.createStatement();
//				) {
//					stmt.executeUpdate(String.format(
//							"insert into movie_review (m_review_star, member_num, m_review_content, m_review_time, m_review_content_id, member_nick)" +
//										"values ('%d', '%d', '%s', '%s', '%s', '%s')",reviewStar, userNum, review, getCurrentTime(), id, nickname ));
//				} catch(Exception e){
//					e.printStackTrace();
//				} 
//			}
//}
		



//	
//	public BoardDto setReview(String nickname, String userId, String text) {
//	    
//	    BoardDto dto = null;
//
//	    try (
//	        Connection conn = getConnection();
//	        Statement stmt = conn.createStatement();
//
//	        ResultSet rs = stmt.executeQuery(
//	                "select * from board where num=");
//	    ) {
//	        if (rs.next()) {
//	        	dto= new BoardDto(rs.getInt("num"),rs.getString("writer"),
//	        			rs.getString("title"), rs.getString("content"),rs.getString("regtime"),
//	        			rs.getInt   ("hits"));
//
//
//	            
//	            if (incHits) {
//	                stmt.executeUpdate(
//	                       "update board set hits=hits+1 where num=" + num);
//	            }
//	        }
//	    } catch(Exception e) {
//	        e.printStackTrace();
//	    }
//	    
//	    return dto;
//	}
//	
//	

//    	
//    public void updateOne(BoardDto dto) {
//
//		try (
//				Connection conn = getConnection();
//				Statement stmt = conn.createStatement();
//		) {
//			
//			stmt.executeUpdate(String.format(
//					"update board set writer='%s', title ='%s', content ='%s', regtime ='%s' where num=%d",
//								 dto.getWriter(), dto.getTitle(), dto.getContent(), getCurrentTime(), dto.getNum()));
//			
//
//		} catch(Exception e){
//			e.printStackTrace();
//		} 
//		
//    }
//// ???????????? ?????? ???????????? ????????? ArrayList ????????? Linked list ?????? ?????????


