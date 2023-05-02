package example1;

public class Order {
	public void order() { // 생성자 아닌 메서드다.
		String msg = "상품 주문";
		System.out.println(msg + "을 위한 로그인 수행"); // 공통
		System.out.println(msg + "하기"); // 핵심
		System.out.println(msg + "을 DB에 저장"); // 공통
		System.out.println(msg + "을 위한 로그아웃"); // 공통
	}
}
