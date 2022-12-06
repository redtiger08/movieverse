package com.board.db;

public class BoardDto {
	
	private int review_star;
	private int member_Num;
	private String review_content = "";
	private String review_time ="";
	private String review_content_id ="";
	private String member_nick ="";
	private String poster_path ="";
	private String type = "";
	private String data_id = "";
	private String member_id = "";
	private String mark_time = "";

	
	public String getPoster_path() {
		return poster_path;
	}
	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getData_id() {
		return data_id;
	}
	public void setData_id(String data_id) {
		this.data_id = data_id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMark_time() {
		return mark_time;
	}
	public void setMark_time(String mark_time) {
		this.mark_time = mark_time;
	}
	public String getMember_nick() {
		return member_nick;
	}
	public void setMember_nick(String member_nick) {
		this.member_nick = member_nick;
	}
	public int getReview_star() {
		return review_star;
	}
	public void setReview_star(int review_star) {
		this.review_star = review_star;
	}
	public int getMember_Num() {
		return member_Num;
	}
	public void setMember_Num(int member_Num) {
		this.member_Num = member_Num;
	}
	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public String getReview_time() {
		return review_time;
	}
	public void setReview_time(String review_time) {
		this.review_time = review_time;
	}
	public String getReview_content_id() {
		return review_content_id;
	}
	public void setReview_content_id(String review_content_id) {
		this.review_content_id = review_content_id;
	}
	
}
