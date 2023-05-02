package sample1;

public class OrderDao {
	public OrderDao() {
		System.out.println("OrderDao 생성자");
	}

	public void insertOrder() {
		System.out.println("주문정보 추가 : insertOrder()");
	}

	public void removeOrder() {
		System.out.println("주문정보 삭제 : removeOrder()");
	}
}
