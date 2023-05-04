package example2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// 어노테이션으로 이미 객체를 생성했기때문에 안해도 된다.
//		Shape px = new PointX(); // 부모로도 ㄱㅊ
//		PointY py = new PointY(); // 자식으로도 ㄱㅊ
		
//		CircleImpl circle = new CircleImpl();
//		circle.setPointx(px); // Shape pointx = new PointX(); //Autowired()
		
		
		// 메인에서 실행하면 해당 xml 파일로 가서 설정한대로 example2 패키지를 훑고 패키지냉ㅇ대로 객체를 생성한다.
		ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
		CircleImpl circle = (CircleImpl)context.getBean("myCircleImpl"); // 해당 객체를 생성한 참조변수 이름을 작성한다.
		System.out.println(circle.make()); // 아까 @Qualifier("PointX")로 참조변수명을 PointX로 했음!
		
		System.out.println("--------------------------");
		
		// RectangleImpl 타입으로 받아도 된다.
		Rectangle rect = (Rectangle)context.getBean("myRectangleImpl");
		System.out.println(rect.make());
		
	}

}
