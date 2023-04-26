package com.yedam.member.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.member.domain.EventVO;
import com.yedam.member.service.EventService;
import com.yedam.member.service.EventServiceImpl;

public class AddEventControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String start = req.getParameter("start_date");
		String end = req.getParameter("end_date");
		
		EventVO vo = new EventVO(end, end, end);
		vo.setTitle(title);
		vo.setStartDate(start);
		vo.setEndDate(end);
		
		EventService service = new EventServiceImpl();
		boolean result = service.addEvent(vo);
		
		String json = "";
		
		
		
		return json + ".json";
	}

}
