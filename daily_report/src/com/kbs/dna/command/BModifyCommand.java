package com.kbs.dna.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kbs.dna.dao.BDao;

public class BModifyCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String dt = request.getParameter("dt");
		String interestReport = request.getParameter("interestReport").replace("\r\n","<br>");
		String digitalReport = request.getParameter("digitalReport").replace("\r\n","<br>");
		
		BDao  dao = new BDao();
		dao.modify(dt, interestReport, digitalReport);
			
	}

}
 