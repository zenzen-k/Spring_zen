package sample1;

public class Main {

	public static void main(String[] args) {
		Point point = new Point();
		point.setXpos(3.0);
		point.setYpos(4.0);
		
		Circle circle = new Circle(point, 10.0);
		circle.display();
	}

}
