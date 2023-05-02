package example3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopMain {
	public static void main(String[] args) {
		// 핵심기능 호출.
		// 핵심기능을 호출하면 알아서 메서드가 호출되도록 xml파일에서 작성함.
		
		AbstractApplicationContext context =  new GenericXmlApplicationContext("aopExam.xml");
		Board myboard = (Board)context.getBean("myboard");
		myboard.board(); // 핵심기능
		
		System.out.println("----------");
		
		Order myorder = (Order)context.getBean("myorder");
		myorder.order();
	}
}
