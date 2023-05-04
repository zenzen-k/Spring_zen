package example2;

import org.springframework.stereotype.Component;

// PointX 객체를 생성하는 어노테이션
// 객체를 관리하는 변수의 명을 작성한다. 원래는 동일한 이름 안되는데 여기는 가능
// @Component("p") // PointX p = new PointX();
@Component("PointX") // PointX PointX = new PointX();
public class PointX implements Shape{
	
	public PointX() {
		System.out.println("PointX()");
	}

	@Override
	public String make() {
		return "X를 만들다";
	}

	@Override
	public String delete() {
		return "X를 지우다";
	}
	
}
