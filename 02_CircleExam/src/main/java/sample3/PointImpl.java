package sample3;

// bean dto vo
public class PointImpl implements Point{
	private double xpos;
	private double ypos;
	
	public double getXpos() {
		return xpos;
	}
	public void setXpos(double xpos) { // ���� �����Ѵ�. setter�� ���� ����.
		this.xpos = xpos;
	}
	public double getYpos() {
		return ypos;
	}
	public void setYpos(double ypos) {
		this.ypos = ypos;
	}
	
}
