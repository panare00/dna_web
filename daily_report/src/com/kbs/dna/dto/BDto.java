package com.kbs.dna.dto;

//import java.sql.Timestamp;

public class BDto {

	String dt;
	String interestReport;	
	String digitalReport;
	
	public BDto() {
		// TODO Auto-generated constructor stub
	}	
	
	public BDto(String dt, String interestReport, String digitalReport) {
		super();
		this.dt = dt;
		this.interestReport = interestReport;		
		this.digitalReport = digitalReport;
	}
	
	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

	public String getInterestReport() {
		return interestReport;
	}

	public void setInterestReport(String interestReport) {
		this.interestReport = interestReport;
	}
	
	public String getDigitalReport() {
		return digitalReport;
	}

	public void setDigitalReport(String digitalReport) {
		this.digitalReport = digitalReport;
	}	
}
