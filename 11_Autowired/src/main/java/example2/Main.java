package example2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// ������̼����� �̹� ��ü�� �����߱⶧���� ���ص� �ȴ�.
//		Shape px = new PointX(); // �θ�ε� ����
//		PointY py = new PointY(); // �ڽ����ε� ����
		
//		CircleImpl circle = new CircleImpl();
//		circle.setPointx(px); // Shape pointx = new PointX(); //Autowired()
		
		
		// ���ο��� �����ϸ� �ش� xml ���Ϸ� ���� �����Ѵ�� example2 ��Ű���� �Ȱ� ��Ű���ä���� ��ü�� �����Ѵ�.
		ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
		CircleImpl circle = (CircleImpl)context.getBean("myCircleImpl"); // �ش� ��ü�� ������ �������� �̸��� �ۼ��Ѵ�.
		System.out.println(circle.make()); // �Ʊ� @Qualifier("PointX")�� ������������ PointX�� ����!
		
		System.out.println("--------------------------");
		
		// RectangleImpl Ÿ������ �޾Ƶ� �ȴ�.
		Rectangle rect = (Rectangle)context.getBean("myRectangleImpl");
		System.out.println(rect.make());
		
	}

}
