package sample3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {

	public static void main(String[] args) {
//		// setter ���� ����
//		PointImpl point = new PointImpl();
//		point.setXpos(3.0);
//		point.setYpos(4.0);
//		
//		// ������ ���� ����
//		CircleImpl circle = new CircleImpl(point, 10.0);
//		circle.display();
		
		
		Resource resource = new ClassPathResource("appContext.xml");
		// resource�� �����ϴ� xml�� ���� bean���忡�� bean�� �����Ѵ�.
		// xml���Ͽ� �ۼ��ߴٰ� �����Ǵ� ���� �ƴϴ�. �Ʒ�ó�� xmlbeanFactory���� �ۼ����־�� ��ü�� �����ȴ�.
		BeanFactory factory = new XmlBeanFactory(resource);
		
		// circle�� �����ϴ� ��ü�� id. �� bean�� id�� c ���ٸ� �Ʒ��� c�� ����.
		// ���� getBean�޼���� ������Ʈ�� �����ϹǷ� �ٿ�ĳ������ ���־���Ѵ�.
		// CircleImplŬ������ �θ� Circle�̹Ƿ� Circle�������̽� Ÿ������ ��ü�� ���� �� �ִ�.
		Circle circle = (Circle)factory.getBean("circle");
		circle.display();
		
		Point point = (Point)factory.getBean("point");
		System.out.println("xpos : " + point.getXpos());
		System.out.println("ypos : " + point.getYpos());
		
	}

}
