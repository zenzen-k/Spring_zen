package sample1;

public class Main {

	public static void main(String[] args) {
		CalcBean cb = new CalcBeanImpl(4);
		// �θ� setSu1�� ������ ���� �ʱ⶧���� ����Ҽ�����,
		cb.setSu1(13);
		cb.calculate();
	}

}
