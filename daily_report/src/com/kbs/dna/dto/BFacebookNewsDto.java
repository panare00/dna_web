package com.kbs.dna.dto;

public class BFacebookNewsDto {
	String docid;
	String dt;
	String title;
	int reach;
	int reaction;
	int share;	
	String type;
	String url;
	
	public BFacebookNewsDto() {
		// TODO Auto-generated constructor stub
	}

	public BFacebookNewsDto(String docid, String dt, String title, int reach, int reaction, int share, String type,
			String url) {
		super();
		this.docid = docid;
		this.dt = dt;
		this.title = title;
		this.reach = reach;
		this.reaction = reaction;
		this.share = share;
		this.type = type;
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDocid() {
		return docid;
	}

	public void setDocid(String docid) {
		this.docid = docid;
	}

	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getReach() {
		return reach;
	}

	public void setReach(int reach) {
		this.reach = reach;
	}

	public int getReaction() {
		return reaction;
	}

	public void setReaction(int reaction) {
		this.reaction = reaction;
	}

	public int getShare() {
		return share;
	}

	public void setShare(int share) {
		this.share = share;
	}	
}
