package com.kbs.dna.command;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kbs.dna.dao.BDao;

public class BFacebookWriteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		BDao dao = new BDao();		
		
		String[] dt = request.getParameterValues("dt");
		String[] title = request.getParameterValues("title");
		String[] reach = request.getParameterValues("reach");
		String[] reaction = request.getParameterValues("reaction");
		String[] share = request.getParameterValues("share");
		String[] type = request.getParameterValues("type");
		String[] url = request.getParameterValues("url");
		
		for(int i=0,s=title.length; i<s; i++)
			  dao.fb_write(dt[i], title[i], reach[i], reaction[i], share[i], type[i], url[i]);
		
	}
}
