package sample2;

public class CircleImpl implements Circle{
	// �߽���ǥ
	//private double xpos;
	//private double ypos;
	private PointImpl point; // ����� �ƴ� ���԰���
	//������
	private double radius;
	
	// �����ڿ��� point ��ü�� �޾Ƽ� �ִ´�.
	public CircleImpl(PointImpl point, double radius) { // �����ڸ� ���� ����
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
