package com.kbs.dna.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kbs.dna.dao.BDao;
import com.kbs.dna.dto.BDto;
import com.kbs.dna.dto.BFacebookNewsDto;
import com.kbs.dna.dto.BNaverNewsDto;

public class BNaverListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		BDao dao = new BDao();
		ArrayList<BNaverNewsDto> dtos = dao.naver_list();
		request.setAttribute("list", dtos);
	}
}