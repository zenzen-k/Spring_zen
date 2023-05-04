package example2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("myRectangleImpl")
public class RectangleImpl implements Rectangle {
	
	@Autowired
	@Qualifier("PointY")
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
