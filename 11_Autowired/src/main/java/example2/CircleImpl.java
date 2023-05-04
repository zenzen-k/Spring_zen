package example2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// CircleImpl myCircleImpl = new CircleImpl();
@Component("myCircleImpl")
public class CircleImpl implements Circle {
	
	// 자동으로 엮어준다.
	// Shape타입의 객체를 만들어야 하는데, Shape의 자식을 밀어 넣어라는 의미, 
	// 자식이 한개면 @Autowired()만 작성하지만, 자식이 여러개면 PointX 참조변수를 작성, 즉 아래 작성한 @Qualifier를 써야한다.
	@Autowired()
	// 앞에서 생성한 객체의 이름을 작성한다.
	// 마찬가지로 객체를 생성해줌.
	@Qualifier("PointX")
	Shape pointx; // pointx, pointy 관리가능 (shape의 자식이니까)
	int x;
	int y;

	public CircleImpl() {
		System.out.println("CircleImpl() 생성자");
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public String make() {
		return pointx.make();
	}

	public Shape getPointx() {
		return pointx;
	}

	public void setPointx(Shape pointx) { // pointx가 올수도, pointy 가 올수도 있다, (shape의 자식이니까)
		System.out.println("setPointx()");
		this.pointx = pointx;
	}

}
