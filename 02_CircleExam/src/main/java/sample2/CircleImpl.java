package sample2;

public class CircleImpl implements Circle{
	// 중심좌표
	//private double xpos;
	//private double ypos;
	private PointImpl point; // 상속이 아닌 포함관계
	//반지름
	private double radius;
	
	// 생성자에서 point 객체를 받아서 넣는다.
	public CircleImpl(PointImpl point, double radius) { // 생성자를 통한 주입
		super();
		this.point = point;
		this.radius = radius;
	}
	
	public void display() {
		System.out.println("원의 중심 : " + point.getXpos() + "," + point.getYpos());
		System.out.println("원의 면적 : " + getArea());
	}
	
	public double getArea() {
		//return radius * radius * 3.14;
		return Math.pow(radius, 2) * Math.PI;
	}
}
