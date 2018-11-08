package com.kbs.dna.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kbs.dna.dao.BDao;

public class BDeleteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		String dt = request.getParameter("dt");
		BDao dao = new BDao();
		dao.delete(dt);
		
	}

}
