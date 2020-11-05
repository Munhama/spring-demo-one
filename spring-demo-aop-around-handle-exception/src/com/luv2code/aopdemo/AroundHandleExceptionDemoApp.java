package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	private static Logger logger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());
	
	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",
				TrafficFortuneService.class);

		logger.info("\nMain Programm AroundDemoApp");
		logger.info("---------------------------");
		logger.info("Calling getFortuneService");
		
		boolean exceptionFlag = true;
		logger.info("FortuneService: " + trafficFortuneService.getFortuneService(exceptionFlag));

		logger.info("Finish");
	
		// close the context
		context.close();

	}

}
