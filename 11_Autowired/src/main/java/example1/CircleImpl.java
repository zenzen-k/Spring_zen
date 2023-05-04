package example1;

public class CircleImpl implements Circle {

	Shape pointx; // pointx, pointy �������� (shape�� �ڽ��̴ϱ�)
	int x;
	int y;

	public CircleImpl() {
		System.out.println("CircleImpl() ������");
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

	public void setPointx(Shape pointx) { // pointx�� �ü���, pointy �� �ü��� �ִ�, (shape�� �ڽ��̴ϱ�)
		System.out.println("setPointx()");
		this.pointx = pointx;
	}

}
