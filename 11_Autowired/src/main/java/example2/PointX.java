package example2;

import org.springframework.stereotype.Component;

// PointX ��ü�� �����ϴ� ������̼�
// ��ü�� �����ϴ� ������ ���� �ۼ��Ѵ�. ������ ������ �̸� �ȵǴµ� ����� ����
// @Component("p") // PointX p = new PointX();
@Component("PointX") // PointX PointX = new PointX();
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
