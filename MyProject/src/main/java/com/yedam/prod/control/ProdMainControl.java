package com.yedam.prod.control;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.prod.domain.ProdVO;
import com.yedam.prod.service.ProdService;
import com.yedam.prod.service.ProdServiceImpl;

public class ProdMainControl implements Control {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String pid = req.getParameter("id");
		
		ProdService service = new ProdServiceImpl();
		ProdVO vo = service.getProd(Integer.parseInt(pid));
		List<ProdVO> list = service.prodList();
		
		req.setAttribute("prodInfo", vo);
		req.setAttribute("prod", list);
		
		return "prod/prodMain.tiles";
	}

}
