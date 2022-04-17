package com.freyvik.springcourse.form.interceptors;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component("tiempoTranscurrido")
public class TiempoTranscurridoInterceptor implements HandlerInterceptor {
	
	private final static Logger log = LoggerFactory.getLogger(TiempoTranscurridoInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("Entrando en preHandler...");
		log.info("Handler: " + handler);
		
		long initTime = System.currentTimeMillis();
		request.setAttribute("initTime", initTime);
		
		Random rand = new Random();
		Integer espera = rand.nextInt(500);
		Thread.sleep(espera);
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		long finalTime = System.currentTimeMillis();
		long initTime = (Long) request.getAttribute("initTime");
		long timePassed = finalTime - initTime;
		
		if (modelAndView != null) {
			modelAndView.addObject("time", timePassed);
		}
		
		log.info("Tiempo transcurrido: ".concat(Long.toString(timePassed)));
		log.info("Saliendo del postHandler...");
	}
	
}
