package sample3;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Main {

	public static void main(String[] args) {
//		// setter 통한 주입
//		PointImpl point = new PointImpl();
//		point.setXpos(3.0);
//		point.setYpos(4.0);
//		
//		// 생성자 통한 주입
//		CircleImpl circle = new CircleImpl(point, 10.0);
//		circle.display();
		
		
		Resource resource = new ClassPathResource("appContext.xml");
		// resource가 관리하는 xml에 가서 bean공장에서 bean을 생성한다.
		// xml파일에 작성했다고 생성되는 것이 아니다. 아래처럼 xmlbeanFactory까지 작성해주어야 객체가 생성된다.
		BeanFactory factory = new XmlBeanFactory(resource);
		
		// circle로 관리하는 객체의 id. 즉 bean의 id가 c 였다면 아래에 c가 들어간다.
		// 또한 getBean메서드는 오브젝트를 리턴하므로 다운캐스팅을 해주어야한다.
		// CircleImpl클래스의 부모가 Circle이므로 Circle인터페이스 타입으로 객체를 받을 수 있다.
		Circle circle = (Circle)factory.getBean("circle");
		circle.display();
		
		Point point = (Point)factory.getBean("point");
		System.out.println("xpos : " + point.getXpos());
		System.out.println("ypos : " + point.getYpos());
		
	}

}
