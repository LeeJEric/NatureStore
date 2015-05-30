package cn.lee.j.eric.application;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

public class ActionInterceptor implements HandlerInterceptor{

	private static Logger log = Logger.getLogger(ActionInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "GET,POST,PUT,DELETE,OPTIONS");
//		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		response.setHeader("Access-Control-Allow-Headers", "X-Requested-With");
		String currentURL = request.getRequestURI();
		StringBuffer sb = new StringBuffer();
		sb.append(currentURL).append(" ");

		Enumeration<String> keys = request.getParameterNames();
		String user_ID = "-";
		while(keys.hasMoreElements()) {
			String k = keys.nextElement();
			sb.append(k).append("=").append(request.getParameter(k)).append("&");
			if(k.equals("userId")){//
				user_ID = request.getParameter(k);
			}
		}
		if(sb.indexOf("&")!=-1){
			sb.deleteCharAt(sb.lastIndexOf("&"));
		}
		StringBuffer buffer = new StringBuffer();
		buffer.append(user_ID).append(" ").append(sb);
		log.info(buffer.toString());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
//		String currentURL = request.getRequestURI();
//		log.info(currentURL+"|postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
//		String currentURL = request.getRequestURI();
//		log.info(currentURL+"|afterCompletion");
	}

}
