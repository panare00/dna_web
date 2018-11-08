package com.kbs.dna.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kbs.dna.dao.BDao;

public class BNaverModifyCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		BDao  dao = new BDao();
		
		String[] docid = request.getParameterValues("docid");
		String[] title = request.getParameterValues("title");
		String[] dt = request.getParameterValues("dt");
		String[] reporter = request.getParameterValues("reporter");
		String[] pv = request.getParameterValues("pv");
		String[] url = request.getParameterValues("url");
		
		for(int i=0,s=title.length; i<s; i++)			  
			dao.naver_modify(docid[i], dt[i], title[i], reporter[i], pv[i], url[i]);			
	}
}
 