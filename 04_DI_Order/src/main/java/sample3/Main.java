package sample3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {

	public static void main(String[] args) {
		Resource resource = new ClassPathResource("personContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
		MyInfo info = (MyInfo)factory.getBean("info");
		System.out.println("[print �޼��� ����]");
		info.print();
		System.out.println("----");
		System.out.println("[PersonŬ������ personPrint]");
		info.personPrint();
		System.out.println("----");
		System.out.println("[StudentŬ������ studentPrint]");
		info.studentPrint();
		System.out.println("====");
		
		// or
		ApplicationContext context = new FileSystemXmlApplicationContext("classpath:personContext.xml");
		MyInfo info2 = (MyInfo)context.getBean("info");
		info2.print();
	}

}
