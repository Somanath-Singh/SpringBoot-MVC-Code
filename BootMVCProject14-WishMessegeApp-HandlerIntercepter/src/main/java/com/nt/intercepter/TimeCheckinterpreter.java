package com.nt.intercepter;

import java.time.LocalDateTime;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TimeCheckinterpreter implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) throws Exception {

		System.out.println("TimeCheckinterpreter.preHandle()");
		// get system data and Time
		LocalDateTime ldt = LocalDateTime.now();
		// get current hour of the day
		int hour = ldt.getHour();
		if (!req.getServletPath().equalsIgnoreCase("/")) {
			if (hour < 9 || hour > 17) {
				RequestDispatcher rd = req.getRequestDispatcher("/timeout.jsp");
				rd.forward(req, res);
				return false;
			}
		}

		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("TimeCheckinterpreter.postHandle()");
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("TimeCheckinterpreter.afterCompletion()");
	}

}
