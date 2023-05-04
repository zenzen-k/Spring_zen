package example1;

public class Main {

	public static void main(String[] args) {
		Shape px = new PointX(); // �θ�ε� ����
		PointY py = new PointY(); // �ڽ����ε� ����
		
		CircleImpl circle = new CircleImpl();
		
		circle.setPointx(px); // Shape pointx = new PointX();
		//circle.setPointx(py); // Shape pointx = new PointY();
		
		System.out.println(circle.make());
		
		System.out.println("------------------");
		
		
		RectangleImpl rect = new RectangleImpl();
		rect.setPt(py);
		
		System.out.println(rect.make()); // Shape pt = new PointY();
		
	}

}
