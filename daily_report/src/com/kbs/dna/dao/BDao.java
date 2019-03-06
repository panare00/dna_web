package com.kbs.dna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.kbs.dna.dto.BDaumNewsDto;
import com.kbs.dna.dto.BDto;
import com.kbs.dna.dto.BFacebookNewsDto;
import com.kbs.dna.dto.BHomepageNewsDto;
import com.kbs.dna.dto.BHomepagePvDto;
import com.kbs.dna.dto.BNaverNewsDto;
import com.kbs.dna.dto.BYoutubeNewsDto;
import java.text.*;

public class BDao {

	DataSource dataSource;
	
	public BDao() {
		// TODO Auto-generated constructor stub
		
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mySQLDB");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void write(String dt, String interestReport, /*String coverReport,*/ String digitalReport) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into report_briefing (dt, interestReport, digitalReport) values (?, ?, ? )";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, dt);
			preparedStatement.setString(2, interestReport);			
			preparedStatement.setString(3, digitalReport);
			int rn = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}		
	}
	
	public ArrayList<BDto> list() {
		
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select dt, interestReport, digitalReport from report_briefing order by dt desc;";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				String dt = resultSet.getString("dt");
				String interestReport = resultSet.getString("interestReport");				
				String digitalReport = resultSet.getString("digitalReport");
				
				BDto dto = new BDto(dt, interestReport, digitalReport);
				dtos.add(dto);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
	public BDto contentView(String strDT) {
		// TODO Auto-generated method stub
		
		BDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = dataSource.getConnection();
			
			String query = "select * from report_briefing where dt = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, strDT);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				String dt = resultSet.getString("dt");
				String interestReport = resultSet.getString("interestReport");				
				String digitalReport = resultSet.getString("digitalReport");
				
				interestReport = interestReport.replace("<br>","\r\n");				
				digitalReport = digitalReport.replace("<br>","\r\n");
				
				dto = new BDto(dt, interestReport, digitalReport);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
	public void modify(String dt, String interestReport, String digitalReport) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update report_briefing set interestReport = ?, digitalReport = ? where dt = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, interestReport);
			preparedStatement.setString(2, digitalReport);
			preparedStatement.setString(3, dt);
			int rn = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	public void delete(String dt) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			
			connection = dataSource.getConnection();
			String query = "delete from report_briefing where dt = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, dt);
			int rn = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	public BDto briefingReportView(String strDT) {
		// TODO Auto-generated method stub
		
		BDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = dataSource.getConnection();
			
			String query = "select * from report_briefing where dt = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, strDT);
			//preparedStatement.setInt(1, Integer.parseInt(strID));
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				String dt = resultSet.getString("dt");
				String interestReport = resultSet.getString("interestReport");				
				String digitalReport = resultSet.getString("digitalReport");
				
				dto = new BDto(dt, interestReport, digitalReport);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return dto;
	}
		
	public ArrayList<BHomepagePvDto> homepagePvView(String strDT) {
		
		String startDate = calculatePreviousDay(strDT , 8);
		String endDate = calculatePreviousDay(strDT , 1);
		
		ArrayList<BHomepagePvDto> dtos = new ArrayList<BHomepagePvDto>();
		BHomepagePvDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
				
		try {
			
			connection = dataSource.getConnection();
			
			String query = "select * from homepage_pv where ? <= dt and dt <= ? order by dt desc";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, startDate);
			preparedStatement.setString(2, endDate);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				String dt = resultSet.getString("dt");
				int mo = resultSet.getInt("mo");
				int pc = resultSet.getInt("pc");
				int app = resultSet.getInt("app");
				int total = resultSet.getInt("total");
				
				dto = new BHomepagePvDto(dt, mo, pc, app, total);
				dtos.add(dto);				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return dtos;
	}
		
	public ArrayList<BHomepageNewsDto> homepageNewsView(String strDT, String resultCount) {		
		
		// 전날 날짜 받아오기 
		String sPreviousDay = calculatePreviousDay(strDT, 1);
				
		ArrayList<BHomepageNewsDto> dtos = new ArrayList<BHomepageNewsDto>();
		BHomepageNewsDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
				
		try {
			
			connection = dataSource.getConnection();
			
			String query = "select * from homepage_rank where dt = ? order by rank limit " + resultCount;
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, sPreviousDay);
			//preparedStatement.setString(2, resultCount);			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				String dt = resultSet.getString("dt");
				int rank = resultSet.getInt("rank");
				int newsCode = resultSet.getInt("newsCode");
				String newsTitle = resultSet.getString("newsTitle");
				String url = resultSet.getString("url");
				String sourceName = resultSet.getString("sourceName");
				String contentsName = resultSet.getString("contentsName");
				String broadName = resultSet.getString("broadName");				
				String positionName = resultSet.getString("positionName");				
				String reporterName = resultSet.getString("reporterName");				
				int totalViews = resultSet.getInt("totalViews");
				int pcViews = resultSet.getInt("pcViews");
				int mobileViews = resultSet.getInt("mobileViews");
				int appViews = resultSet.getInt("appViews");
				
				dto = new BHomepageNewsDto(dt, rank, newsCode, newsTitle, url, sourceName, contentsName, broadName, positionName, reporterName, totalViews, pcViews, mobileViews, appViews  );
				dtos.add(dto);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
	public ArrayList<BFacebookNewsDto> facebookNewsView(String strDT) {		
		
		// 전날 날짜 받아오기 
		String sPreviousDay = calculatePreviousDay(strDT, 1);
		
		ArrayList<BFacebookNewsDto> dtos = new ArrayList<BFacebookNewsDto>();
		BFacebookNewsDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
				
		try {
			
			connection = dataSource.getConnection();
			
			String query = "select * from facebook_feed where dt = ? order by impression desc limit 5";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, sPreviousDay);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				String docid = resultSet.getString("id");
				String title = resultSet.getString("name");
				String dt = resultSet.getString("dt");
				int reach = resultSet.getInt("impression");
				int reaction = resultSet.getInt("like_count")
						+ resultSet.getInt("love_count")
						+ resultSet.getInt("wow_count")
						+ resultSet.getInt("haha_count")
						+ resultSet.getInt("sorry_count")
						+ resultSet.getInt("anger_count");
				int share = resultSet.getInt("share_count");
				String type = resultSet.getString("type");
				String url = resultSet.getString("url");
								
				dto = new BFacebookNewsDto(docid, dt, title, reach, reaction, share, type, url);
				dtos.add(dto);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
	public ArrayList<BYoutubeNewsDto> youtubeNewsView(String strDT) {		
		
		// 전날 날짜 받아오기 
		String sPreviousDay = calculatePreviousDay(strDT, 1);
		
		ArrayList<BYoutubeNewsDto> dtos = new ArrayList<BYoutubeNewsDto>();
		BYoutubeNewsDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
				
		try {
			
			connection = dataSource.getConnection();
			
			String query = "select * from youtube_article where dt = ? order by viewCount desc limit 5";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, sPreviousDay);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				String title = resultSet.getString("title");
				String thumbnails = resultSet.getString("thumbnails");
				String url = resultSet.getString("url");
				String dt = resultSet.getString("dt");
				int viewCount = resultSet.getInt("viewCount");
				int likeCount = resultSet.getInt("likeCount");
				int commentCount = resultSet.getInt("commentCount");
				
				dto = new BYoutubeNewsDto(title, thumbnails, url, dt, viewCount, likeCount, commentCount);
				dtos.add(dto);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
	public String calculatePreviousDay(String dt, int day){
		
		String sDay = null;
		String sPreviousDay = null;
		long lCurTime;
		
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.KOREA);
		java.util.Date dDate = new java.util.Date();
		
		try {
			dDate = sdf.parse(dt);
			sDay = sdf.format(dDate);
			lCurTime = dDate.getTime();
			dDate = new java.util.Date(lCurTime+(1000*60*60*24*- day ));
			sPreviousDay = sdf.format(dDate);     
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		
		return sPreviousDay;
	}
	
	public void fb_write(String dt, String title, String reach, String reaction, String share, String type, String url) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into facebook_article (dt, title, reach, reaction, share, type, url) values (?, ?, ?, ?, ?, ?, ? )";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, dt);
			preparedStatement.setString(2, title);
			preparedStatement.setInt(3, Integer.parseInt(reach));
			preparedStatement.setInt(4, Integer.parseInt(reaction));
			preparedStatement.setInt(5, Integer.parseInt(share));
			preparedStatement.setString(6, type);
			preparedStatement.setString(7, url);
			int rn = preparedStatement.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}		
	}
		
	public void naver_write(String dt, String title, String url, String reporter, String pv) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into naver_news (dt, title, url, reporter, pv) values (?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, dt);
			preparedStatement.setString(2, title);
			preparedStatement.setString(3, url);
			preparedStatement.setString(4, reporter);
			preparedStatement.setInt(5, Integer.parseInt(pv));
			int rn = preparedStatement.executeUpdate();
			System.out.println(query);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}		
	}
	
	public ArrayList<BNaverNewsDto> naver_list() {
		
		ArrayList<BNaverNewsDto> dtos = new ArrayList<BNaverNewsDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select * from naver_news order by dt desc;";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int docid = resultSet.getInt("docid");
				String title = resultSet.getString("title");
				String dt = resultSet.getString("dt");
				String url = resultSet.getString("url");
				String reporter = resultSet.getString("reporter");
				int pv = resultSet.getInt("pv");
								
				BNaverNewsDto dto = new BNaverNewsDto(docid, dt, title, url, reporter, pv);
				dtos.add(dto);
			}			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
	public BNaverNewsDto naver_contentView(String reqDocid) {
		
		BNaverNewsDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select * from naver_news where docid = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, reqDocid);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				int docid = resultSet.getInt("docid");
				String dt = resultSet.getString("dt");
				String title = resultSet.getString("title");
				String url = resultSet.getString("url");
				String reporter = resultSet.getString("reporter");
				int pv = resultSet.getInt("pv");				
				
				dto = new BNaverNewsDto(docid, dt, title, url, reporter, pv);				
			}			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
	public void naver_modify(String docid, String dt, String title, String reporter, String pv, String url) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update naver_news set title = ?, dt = ?, reporter = ? , url = ? , pv = ? where docid = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, title);
			preparedStatement.setString(2, dt);
			preparedStatement.setString(3, reporter);
			preparedStatement.setString(4, url);
			preparedStatement.setInt(5, Integer.parseInt(pv));
			preparedStatement.setInt(6, Integer.parseInt(docid));
			
			int rn = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	public void naver_delete(String docid) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {			
			connection = dataSource.getConnection();
			String query = "delete from naver_news where docid = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(docid));
			int rn = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	public ArrayList<BNaverNewsDto> naverNewsView(String strDT) {		
		
		// 전날 날짜 받아오기 
		String sPreviousDay = calculatePreviousDay(strDT, 1);
		
		ArrayList<BNaverNewsDto> dtos = new ArrayList<BNaverNewsDto>();
		BNaverNewsDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		System.out.println(sPreviousDay);
		
		try {			
			connection = dataSource.getConnection();
			
			String query = "select * from naver_news where dt = ? order by pv desc limit 6";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, sPreviousDay);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int docid = resultSet.getInt("docid");
				String title = resultSet.getString("title");
				String url = resultSet.getString("url");
				String dt = resultSet.getString("dt");
				String reporter = resultSet.getString("reporter");				
				int pv = resultSet.getInt("pv");
				
				dto = new BNaverNewsDto(docid, dt, title, url, reporter, pv);
				dtos.add(dto);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return dtos;
	}	
	public void daum_write(String dt, String title, String url, String reporter, String pv) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into daum_news (dt, title, url, reporter, pv) values (?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, dt);
			preparedStatement.setString(2, title);
			preparedStatement.setString(3, url);
			preparedStatement.setString(4, reporter);
			preparedStatement.setInt(5, Integer.parseInt(pv));
			int rn = preparedStatement.executeUpdate();
			System.out.println(query);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}		
	}
	
	public ArrayList<BDaumNewsDto> daum_list() {
		
		ArrayList<BDaumNewsDto> dtos = new ArrayList<BDaumNewsDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "select * from daum_news order by dt desc;";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				int docid = resultSet.getInt("docid");
				String title = resultSet.getString("title");
				String dt = resultSet.getString("dt");
				String url = resultSet.getString("url");
				String reporter = resultSet.getString("reporter");
				int pv = resultSet.getInt("pv");
								
				BDaumNewsDto dto = new BDaumNewsDto(docid, dt, title, url, reporter, pv);
				dtos.add(dto);
			}			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return dtos;
	}
	
	public BDaumNewsDto daum_contentView(String reqDocid) {
		
		BDaumNewsDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "select * from daum_news where docid = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, reqDocid);
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				int docid = resultSet.getInt("docid");
				String dt = resultSet.getString("dt");
				String title = resultSet.getString("title");
				String url = resultSet.getString("url");
				String reporter = resultSet.getString("reporter");
				int pv = resultSet.getInt("pv");				
				
				dto = new BDaumNewsDto(docid, dt, title, url, reporter, pv);				
			}			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
	public void daum_modify(String docid, String dt, String title, String reporter, String pv, String url) {
		// TODO Auto-generated method stub
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "update daum_news set title = ?, dt = ?, reporter = ? , url = ? , pv = ? where docid = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, title);
			preparedStatement.setString(2, dt);
			preparedStatement.setString(3, reporter);
			preparedStatement.setString(4, url);
			preparedStatement.setInt(5, Integer.parseInt(pv));
			preparedStatement.setInt(6, Integer.parseInt(docid));
			
			int rn = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	public void daum_delete(String docid) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {			
			connection = dataSource.getConnection();
			String query = "delete from daum_news where docid = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(docid));
			int rn = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	public ArrayList<BDaumNewsDto> daumNewsView(String strDT) {		
		
		// 전날 날짜 받아오기 
		String sPreviousDay = calculatePreviousDay(strDT, 1);
		
		ArrayList<BDaumNewsDto> dtos = new ArrayList<BDaumNewsDto>();
		BDaumNewsDto dto = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		System.out.println(sPreviousDay);
		
		try {			
			connection = dataSource.getConnection();
			
			String query = "select * from daum_news where dt = ? order by pv desc limit 6";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, sPreviousDay);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int docid = resultSet.getInt("docid");
				String title = resultSet.getString("title");
				String url = resultSet.getString("url");
				String dt = resultSet.getString("dt");
				String reporter = resultSet.getString("reporter");				
				int pv = resultSet.getInt("pv");
				
				dto = new BDaumNewsDto(docid, dt, title, url, reporter, pv);
				dtos.add(dto);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return dtos;
	}	
}
