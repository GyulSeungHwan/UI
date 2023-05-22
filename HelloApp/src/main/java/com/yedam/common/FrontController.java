package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.member.control.AddEventControl;
import com.yedam.member.control.EventListControl;
import com.yedam.member.control.LoginControl;
import com.yedam.member.control.LoginFormControl;
import com.yedam.member.control.LogoutControl;
import com.yedam.member.control.RemoveEventControl;
import com.yedam.member.control.RemoveReplyControl;
import com.yedam.notice.control.AddNoticeControl;
import com.yedam.notice.control.AddReplyControl;
import com.yedam.notice.control.GetNoticeControl;
import com.yedam.notice.control.GetNoticeJsonControl;
import com.yedam.notice.control.NoticeAddForm;
import com.yedam.notice.control.NoticeDelJsonControl;
import com.yedam.notice.control.NoticeListControl;
import com.yedam.notice.control.NoticeListJsonControl;
import com.yedam.notice.control.ReplyListControl;
import com.yedam.notice.control.ModifyNoticeControl;
import com.yedam.notice.control.ModifyNoticeFileControl;
import com.yedam.notice.control.ModifyNoticeJsonControl;
import com.yedam.notice.control.ModifyReplyControl;

public class FrontController extends HttpServlet {
	
	String encoding;
	private Map<String, Control> map;
	public FrontController() {
		map = new HashMap<>();
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		encoding = config.getInitParameter("enc");
		// 첫페이지
		map.put("/main.do", new MainControl());
		
		// 공지사항
		map.put("/noticeList.do", new NoticeListControl());
		map.put("/noticeListJson.do", new NoticeListJsonControl()); // json 데이터가져오는것
		map.put("/delNoticeJson.do", new NoticeDelJsonControl());
		map.put("/getNoticeJson.do", new GetNoticeJsonControl());
		map.put("/modifyNoticeFile.do", new ModifyNoticeFileControl());
		map.put("/modifyNoticeJson.do", new ModifyNoticeJsonControl());
		
		map.put("/noticeAddForm.do", new NoticeAddForm());
		map.put("/addNotice.do", new AddNoticeControl());
		map.put("/getNotice.do", new GetNoticeControl());
		map.put("/modifyNotice.do", new ModifyNoticeControl());
		
		// 회원관련
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do", new LoginControl());
		map.put("/logout.do", new LogoutControl());
		
		// 댓글정보
		map.put("/replyList.do", new ReplyListControl());
		map.put("/addReply.do", new AddReplyControl());
		map.put("/removeReply.do", new RemoveReplyControl());
		map.put("/modifyReply.do", new ModifyReplyControl());
		
		// 차트생성
		map.put("/chart.do", new ChartFormControl());
		map.put("/chartData.do", new ChartDataControl());
		
		// fullcalendar
		map.put("/fullCalendar.do", new FullCalendarControl());
		// 목록 - json형태의 data
		map.put("/eventList.do", new EventListControl());
		// 등록 - json형태의 retCode:Success, Fail
		map.put("/addEvent.do", new AddEventControl());
		// 삭제 - json형태의 retCode:Success, Fail
		map.put("/removeEvent.do", new RemoveEventControl());
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(encoding);
		
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.substring(context.length());
		System.out.println(path);
		
		Control control = map.get(path);
		String viewPage = control.execute(req, resp);
		System.out.println(viewPage);
		
		if (viewPage.endsWith(".do")) {
			resp.sendRedirect(viewPage);
			return;
		}
		
		if (viewPage.endsWith(".json")) {
			resp.setContentType("text/json;charset=UTF-8");
			resp.getWriter().print(viewPage.substring(0, viewPage.length() - 5)); // .json을 안보이게 하려고 -5를 넣었다
			return;
		}
		
		// 페이지 재지정
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
	}
}
