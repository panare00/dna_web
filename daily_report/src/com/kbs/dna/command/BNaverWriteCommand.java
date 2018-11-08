package com.kbs.dna.command;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kbs.dna.dao.BDao;

public class BNaverWriteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		BDao dao = new BDao();		
		
		String[] dt = request.getParameterValues("dt");
		String[] title = request.getParameterValues("title");
		String[] url = request.getParameterValues("url");
		String[] reporter = request.getParameterValues("reporter");
		String[] pv = request.getParameterValues("pv");
		
		for(int i=0,s=title.length; i<s; i++)
			  dao.naver_write(dt[i], title[i], url[i], reporter[i], pv[i]);
		
	}
}
