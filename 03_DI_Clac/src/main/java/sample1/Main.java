package sample1;

public class Main {

	public static void main(String[] args) {
		CalcBean cb = new CalcBeanImpl(4);
		// 부모가 setSu1을 가지고 있지 않기때문에 사용할수없당,
		cb.setSu1(13);
		cb.calculate();
	}

}
