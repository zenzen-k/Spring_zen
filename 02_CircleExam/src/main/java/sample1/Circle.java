package sample1;

public class Circle{
	// �߽���ǥ
	//private double xpos;
	//private double ypos;
	private Point point; // ����� �ƴ� ���԰���
	//������
	private double radius;
	
	// �����ڿ��� point ��ü�� �޾Ƽ� �ִ´�.
	public Circle(Point point, double radius) {
		super();
		this.point = point;
		this.radius = radius;
	}
	
	public void display() {
		System.out.println("���� �߽� : " + point.getXpos() + "," + point.getYpos());
		System.out.println("���� ���� : " + getArea());
	}
	
	public double getArea() {
		//return radius * radius * 3.14;
		return Math.pow(radius, 2) * Math.PI;
	}
}
