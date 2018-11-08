package com.kbs.dna.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kbs.dna.dao.BDao;
import com.kbs.dna.dto.BDto;
import com.kbs.dna.dto.BFacebookNewsDto;
import com.kbs.dna.dto.BHomepageNewsDto;
import com.kbs.dna.dto.BHomepagePvDto;
import com.kbs.dna.dto.BNaverNewsDto;
import com.kbs.dna.dto.BYoutubeNewsDto;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BReportCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		String dt = request.getParameter("dt");
		// Ȩ������ ���� ���� ���� ��� ���� ������ �Ķ���ͷ� ���� (���ڵ鿡�Դ� 10��/ ������ 5��)
		String homepageArticle_count = request.getParameter("homepageArticle_count");
	
		// �Ķ���ͷ� ��¥ �����͸� ���� �ʴ� ��쿡�� ���� ��¥�� ���� 
		if(dt == null || dt == ""){
			dt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		}
		
		if(homepageArticle_count == null || homepageArticle_count == "")
			homepageArticle_count = "5";
		
		BDao dao = new BDao();
		
		BDto dto = dao.briefingReportView(dt);
		ArrayList<BHomepagePvDto> homepagePvDtos = dao.homepagePvView(dt); 
		ArrayList<BHomepageNewsDto> homepageArticleDtos = dao.homepageNewsView(dt, homepageArticle_count);
		ArrayList<BNaverNewsDto> naverNewsDtos = dao.naverNewsView(dt);
		ArrayList<BFacebookNewsDto> facebookArticleDtos = dao.facebookNewsView(dt);
		ArrayList<BYoutubeNewsDto> bYoutubeArticleDtos = dao.youtubeNewsView(dt);
		
		// ��¥ ǥ�ø� ���� set
		request.setAttribute("ref_date", dt);		
		
		request.setAttribute("briefReport_view", dto);
		request.setAttribute("homepagePv_view", homepagePvDtos);
		request.setAttribute("homepageArticle_view", homepageArticleDtos);
		request.setAttribute("naverNews_view", naverNewsDtos);
		request.setAttribute("facebookArticle_view", facebookArticleDtos);
		request.setAttribute("youtubeArticle_view", bYoutubeArticleDtos);		
	}

}
