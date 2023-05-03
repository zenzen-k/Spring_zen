package com.spring.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopMain {

	public static void main(String[] args) {
		
		AbstractApplicationContext  context  = new GenericXmlApplicationContext("infoContext.xml");
		Student mystu = (Student)context.getBean("mystu");
		Worker mywork = (Worker)context.getBean("mywork");
		
		mystu.getStudentInfo(); // ÇÙ½É±â´É
		System.out.println("=============");
		mywork.getWorkerInfo(); // ÇÙ½É±â´É
	}

}
