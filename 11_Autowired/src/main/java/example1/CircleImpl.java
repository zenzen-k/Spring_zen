package example1;

public class CircleImpl implements Circle {

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
