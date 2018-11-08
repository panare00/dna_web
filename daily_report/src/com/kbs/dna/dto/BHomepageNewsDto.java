package com.kbs.dna.dto;

public class BHomepageNewsDto {
	
	String dt;
	int rank;
	int newsCode;
	String newsTitle;
	String url;
	String sourceName;
	String contentsName;
	String broadName;
	String positionName;
	String reporterName;
	int totalViews;
	int pcViews;
	int mobileViews;
	int appViews;
	
	public BHomepageNewsDto() {
		// TODO Auto-generated constructor stub
	}

	public BHomepageNewsDto(String dt, int rank, int newsCode, String newsTitle, String url, String sourceName,
			String contentsName, String broadName, String positionName, String reporterName, int totalViews,
			int pcViews, int mobileViews, int appViews) {
		super();
		this.dt = dt;
		this.rank = rank;
		this.newsCode = newsCode;
		this.newsTitle = newsTitle;
		this.url = url;
		this.sourceName = sourceName;
		this.contentsName = contentsName;
		this.broadName = broadName;
		this.positionName = positionName;
		this.reporterName = reporterName;
		this.totalViews = totalViews;
		this.pcViews = pcViews;
		this.mobileViews = mobileViews;
		this.appViews = appViews;
	}

	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getNewsCode() {
		return newsCode;
	}

	public void setNewsCode(int newsCode) {
		this.newsCode = newsCode;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getContentsName() {
		return contentsName;
	}

	public void setContentsName(String contentsName) {
		this.contentsName = contentsName;
	}

	public String getBroadName() {
		return broadName;
	}

	public void setBroadName(String broadName) {
		this.broadName = broadName;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getReporterName() {
		return reporterName;
	}

	public void setReporterName(String reporterName) {
		this.reporterName = reporterName;
	}

	public int getTotalViews() {
		return totalViews;
	}

	public void setTotalViews(int totalViews) {
		this.totalViews = totalViews;
	}

	public int getPcViews() {
		return pcViews;
	}

	public void setPcViews(int pcViews) {
		this.pcViews = pcViews;
	}

	public int getMobileViews() {
		return mobileViews;
	}

	public void setMobileViews(int mobileViews) {
		this.mobileViews = mobileViews;
	}

	public int getAppViews() {
		return appViews;
	}

	public void setAppViews(int appViews) {
		this.appViews = appViews;
	}		
}
