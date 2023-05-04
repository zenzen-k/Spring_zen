package example4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("carContext.xml");
		Person per = (Person)context.getBean("Consumer");
		
		per.setName("°¨ÀÚ");
		per.setAge(30);
		
		System.out.println(per.getName());
		System.out.println(per.getAge());
		System.out.println(per.personDrive());
		
	}
	
}
