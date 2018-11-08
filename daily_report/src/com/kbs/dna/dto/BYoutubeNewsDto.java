package com.kbs.dna.dto;

public class BYoutubeNewsDto{
	String title;
	String thumbnails;
	String url;
	String dt;
	int viewCount;
	int likeCount;
	int commentCount;
	
	public BYoutubeNewsDto() {
		
	}

	public BYoutubeNewsDto(String title, String thumbnails, String url, String dt, int viewCount, int likeCount,
			int commentCount) {
		super();
		this.title = title;
		this.thumbnails = thumbnails;
		this.url = url;
		this.dt = dt;
		this.viewCount = viewCount;
		this.likeCount = likeCount;
		this.commentCount = commentCount;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnails() {
		return thumbnails;
	}

	public void setThumbnails(String thumbnails) {
		this.thumbnails = thumbnails;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}	
}