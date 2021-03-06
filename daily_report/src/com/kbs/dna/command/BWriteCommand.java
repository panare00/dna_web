package com.kbs.dna.command;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kbs.dna.dao.BDao;

public class BWriteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String dt = request.getParameter("dt");
		
		if(dt == null || dt == ""){
			dt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		}		
		
		String interestReport = request.getParameter("interestReport").replace("\r\n","<br>");		
		String digitalReport = request.getParameter("digitalReport").replace("\r\n","<br>");
				
		BDao dao = new BDao();		
		dao.write(dt, interestReport, digitalReport);
	}
}
