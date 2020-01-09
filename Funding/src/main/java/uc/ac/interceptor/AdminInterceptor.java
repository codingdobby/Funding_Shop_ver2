package uc.ac.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import uc.ac.vo.MemberVO;

public class AdminInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {

		HttpSession session = req.getSession();
	
		int verify = (int)session.getAttribute("verify");
		
		if (verify!=9) {
			System.out.println(verify);
			res.sendRedirect("/funding/loginOK.do");
			return false;
			
			
		}

		return true;

	}
}