package example1;

public class PointX implements Shape{
	
	public PointX() {
		System.out.println("PointX()");
	}

	@Override
	public String make() {
		return "X�� �����";
	}

	@Override
	public String delete() {
		return "X�� �����";
	}
	
}
