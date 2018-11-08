package com.kbs.dna.dto;

public class BHomepagePvDto {

	String dt;
	int mo;
	int pc;
	int app;
	int total;	

	public BHomepagePvDto() {
		// TODO Auto-generated constructor stub
	}

	public BHomepagePvDto(String dt, int mo, int pc, int app, int total) {
		super();
		this.dt = dt;
		this.mo = mo;
		this.pc = pc;
		this.app = app;		
		this.total = total;
	}

	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

	public int getMo() {
		return mo;
	}

	public void setMo(int mo) {
		this.mo = mo;
	}

	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}

	public int getApp() {
		return app;
	}

	public void setApp(int app) {
		this.app = app;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
}
