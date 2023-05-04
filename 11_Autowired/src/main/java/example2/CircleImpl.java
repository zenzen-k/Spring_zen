package example2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// CircleImpl myCircleImpl = new CircleImpl();
@Component("myCircleImpl")
public class CircleImpl implements Circle {
	
	// �ڵ����� �����ش�.
	// ShapeŸ���� ��ü�� ������ �ϴµ�, Shape�� �ڽ��� �о� �־��� �ǹ�, 
	// �ڽ��� �Ѱ��� @Autowired()�� �ۼ�������, �ڽ��� �������� PointX ���������� �ۼ�, �� �Ʒ� �ۼ��� @Qualifier�� ����Ѵ�.
	@Autowired()
	// �տ��� ������ ��ü�� �̸��� �ۼ��Ѵ�.
	// ���������� ��ü�� ��������.
	@Qualifier("PointX")
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
