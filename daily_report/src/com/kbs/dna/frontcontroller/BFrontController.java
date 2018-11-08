package com.kbs.dna.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kbs.dna.command.BCommand;
import com.kbs.dna.command.BContentCommand;
import com.kbs.dna.command.BDeleteCommand;
import com.kbs.dna.command.BListCommand;
import com.kbs.dna.command.BModifyCommand;
import com.kbs.dna.command.BNaverContentCommand;
import com.kbs.dna.command.BNaverDeleteCommand;
import com.kbs.dna.command.BNaverListCommand;
import com.kbs.dna.command.BNaverModifyCommand;
import com.kbs.dna.command.BNaverWriteCommand;
import com.kbs.dna.command.BReportCommand;
import com.kbs.dna.command.BWriteCommand;

/**
 * Servlet implementation class BoardFrontController
 */
@WebServlet("*.do")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String viewPage = null;
		BCommand command = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		if(com.equals("/report_view.do")) {
			command = new BReportCommand();
			command.execute(request, response);
			viewPage = "report_view.jsp";		
		} else if(com.equals("/write_view.do")) {   // 여기서부터 회의자료 입력/수정/삭제 
			viewPage = "write_view.jsp";
		} else if(com.equals("/write.do")) {
			command = new BWriteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} else if(com.equals("/list.do")) {
			command = new BListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
		} else if(com.equals("/content_view.do")){
			command = new BContentCommand();
			command.execute(request, response);
			viewPage = "content_view.jsp";
		} else if(com.equals("/modify.do")) {
			command = new BModifyCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} else if(com.equals("/delete.do")) {
			command = new BDeleteCommand();
			command.execute(request, response);
			viewPage = "list.do";		
		} else if(com.equals("/naver_write_view.do")) {   // 여기서부터 네이버 콘텐츠 입력
			viewPage = "naver_write_view.jsp";
		} else if(com.equals("/naver_write.do")) {
			command = new BNaverWriteCommand();
			command.execute(request, response);
			viewPage = "naver_list.do";
		} else if(com.equals("/naver_list.do")) {
			command = new BNaverListCommand();
			command.execute(request, response);
			viewPage = "naver_list.jsp";
		} else if(com.equals("/naver_content_view.do")){
			command = new BNaverContentCommand();
			command.execute(request, response);
			viewPage = "naver_content_view.jsp";
		} else if(com.equals("/naver_modify.do")) {
			command = new BNaverModifyCommand();
			command.execute(request, response);
			viewPage = "naver_list.do";
		} else if(com.equals("/naver_delete.do")) {
			command = new BNaverDeleteCommand();
			command.execute(request, response);
			viewPage = "naver_list.do";
		} 
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}
