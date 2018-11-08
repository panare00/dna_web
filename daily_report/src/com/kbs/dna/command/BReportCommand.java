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
		// 홈페이지 노출 기사는 공유 대상에 따라서 개수를 파라미터로 조절 (기자들에게는 10개/ 보고서는 5개)
		String homepageArticle_count = request.getParameter("homepageArticle_count");
	
		// 파라미터로 날짜 데이터를 받지 않는 경우에는 오늘 날짜로 세팅 
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
		
		// 날짜 표시를 위한 set
		request.setAttribute("ref_date", dt);		
		
		request.setAttribute("briefReport_view", dto);
		request.setAttribute("homepagePv_view", homepagePvDtos);
		request.setAttribute("homepageArticle_view", homepageArticleDtos);
		request.setAttribute("naverNews_view", naverNewsDtos);
		request.setAttribute("facebookArticle_view", facebookArticleDtos);
		request.setAttribute("youtubeArticle_view", bYoutubeArticleDtos);		
	}

}
