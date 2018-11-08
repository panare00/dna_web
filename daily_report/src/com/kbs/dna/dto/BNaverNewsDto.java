package com.kbs.dna.dto;

public class BNaverNewsDto {
	int docid;
	String dt;
	String title;
	String url;
	String reporter;
	int pv;	
	
	public BNaverNewsDto() {
		// TODO Auto-generated constructor stub
	}

	public BNaverNewsDto(int docid, String dt, String title, String url, String reporter, int pv) {
		super();
		this.docid = docid;
		this.dt = dt;
		this.title = title;
		this.url = url;
		this.reporter = reporter;
		this.pv = pv;
	}

	public int getDocid() {
		return docid;
	}

	public void setDocid(int docid) {
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getReporter() {
		return reporter;
	}

	public void setReporter(String reporter) {
		this.reporter = reporter;
	}

	public int getPv() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv = pv;
	}
}
