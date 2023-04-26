package com.yedam.member.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.member.domain.EventVO;
//import com.yedam.member.domain.EventVO;
//import com.yedam.member.service.EventService;
//import com.yedam.member.service.EventServiceImpl;

public class EventListControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		String json = "[{\"title\":\"test\",\"startDate\":\"2023-04-05\",\"endDate\":\"2023-04-07\"}]";
		String json = "";
		
		List<EventVO> list = new ArrayList<>();
//		list.add(new EventVO("title1", "2024-04-05", null));
//		list.add(new EventVO("title2", "2023-04-06", "2023-04-09"));
//		list.add(new EventVO("title3", "2024-04-16", "2023-04-19"));
		
		Gson gson = new GsonBuilder().create();
		json = gson.toJson(list);
		
//		List<EventVO> list = service.events();
//		for(int i = 0; i < list.size(); i++) {
//			json += "{\"title\":" + list.get(i).getTitle() + ",";
//			json += "\"startDate\":" + list.get(i).getStartDate() + ",";
//			json += "\"endDate\":\"" + list.get(i).getEndDate() + ",";
//			
//			if(i+1 != list.size()) {
//				json += ",";
//			}
//		}
//		json += "]";
		return json + ".json";
	}

}
