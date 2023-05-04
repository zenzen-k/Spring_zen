package example1;

public class RectangleImpl implements Rectangle {

	Shape pt; // pointx, pointy 관리가능 (shape의 자식이니까)
	int x;
	int y;

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
		return pt.make();
	}

	public Shape getPt() {
		return pt;
	}

	public void setPt(Shape pt) {
		this.pt = pt;
	}

}
