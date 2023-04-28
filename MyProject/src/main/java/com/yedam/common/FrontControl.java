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

import com.yedam.prod.control.ProdListControl;
import com.yedam.prod.control.ProdMainControl;
import com.yedam.prod.control.ProductAddControl;
import com.yedam.prod.control.ProductUploadControl;

public class FrontControl extends HttpServlet {
	
	String encoding;
	private Map<String, Control> map;
	public FrontControl() {
		map = new HashMap<>();
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		encoding = config.getInitParameter("enc");
		
		map.put("/prodList.do", new ProdListControl());
		map.put("/prodMain.do", new ProdMainControl());
		// ckeditor 관련
		map.put("/productAdd.do", new ProductAddControl());
		// ckeditor 이미지 업로드 처리
		map.put("/prodUpload.do", new ProductUploadControl());
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(encoding);
		
		String uri = req.getRequestURI();
		String context = req.getContextPath();
		String path = uri.substring(context.length());
		
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
		
		RequestDispatcher rd = req.getRequestDispatcher(viewPage);
		rd.forward(req, resp);
	}
}
