package uc.ac.common;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import uc.ac.funding.ProjectController;

public class LoggerIntercepter extends HandlerInterceptorAdapter{
	protected final Logger logger = LoggerFactory.getLogger(LoggerIntercepter.class);
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
	
		logger.debug("============LoggerintercepterStart==============");
		logger.debug("URI [{}],"+request.getRequestURI());
		
		Enumeration paraNames = request.getParameterNames();
		while(paraNames.hasMoreElements()) {
			String key = (String)paraNames.nextElement();
			String value=request.getParameter(key);
			logger.debug("RequestParameter Data==>"+ key +":"+value+"");
			
			
		}
		
		return super.preHandle(request, response, handler);
	}
@Override
public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
		ModelAndView modelAndView) throws Exception {
	logger.debug("=======================LoggerInterceptorEnd====================");
	super.postHandle(request, response, handler, modelAndView);
}
	

}
