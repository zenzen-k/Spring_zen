package sample2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {

	public static void main(String[] args) {
		/*
		 * ServiceImpl service = new ServiceImpl(); 
		 * OrderDaoImpl odao = new OrderDaoImpl();
		 *  DeliveryDaoImpl ddao = new DeliveryDaoImpl();
		 * 
		 * service.setOdao(odao); 
		 * service.setDdao(ddao); 
		 * service.order();
		 * service.cancel();
		 */
		
		
		// �������̽� 3�� �����ϱ�.
		// insert, remove
		// order, cancle
		// xml�� �߰�
		Resource resource = new ClassPathResource("appContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		
		// �ۼ��ߴٰ� ��ü�� ��������� ���� �ƴϱ⶧���� ����忡�� ��ü�� �����ؾ��Ѵ�!!
		//OrderDaoImpl odao = (OrderDaoImpl)factory.getBean("odao");
		//DelivaryDao ddao = (DelivaryDao)factory.getBean("ddao");
		Service ser = (Service)factory.getBean("service");
		ser.order();
		ser.cancel();
		
		

		ApplicationContext context =  new FileSystemXmlApplicationContext("classpath:appContext.xml");
		ServiceImpl service =  (ServiceImpl)context.getBean("service");
		service.order();
		service.cancel();
	}

}
;