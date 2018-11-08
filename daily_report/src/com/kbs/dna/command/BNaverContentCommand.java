package com.kbs.dna.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kbs.dna.dao.BDao;
import com.kbs.dna.dto.BDto;
import com.kbs.dna.dto.BFacebookNewsDto;
import com.kbs.dna.dto.BNaverNewsDto;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BNaverContentCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String docid = request.getParameter("docid");
			
		BDao dao = new BDao();
		BNaverNewsDto dto = dao.naver_contentView(docid);
		
		request.setAttribute("content_view", dto);
		
	}

}
