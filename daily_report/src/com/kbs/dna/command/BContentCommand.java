package com.kbs.dna.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kbs.dna.dao.BDao;
import com.kbs.dna.dto.BDto;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class BContentCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String dt = request.getParameter("dt");
	
		if(dt == null || dt == ""){
			dt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		}
		
		BDao dao = new BDao();
		BDto dto = dao.contentView(dt);
		
		request.setAttribute("content_view", dto);
		
	}

}
