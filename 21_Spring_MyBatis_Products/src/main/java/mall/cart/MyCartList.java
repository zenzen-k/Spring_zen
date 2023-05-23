package mall.cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 장바구니!
public class MyCartList {
	//상품 번호와 주문 수량 두가지를 한묶음으로 표현!
	private Map<Integer, Integer> orderlists = null;
	
	// 생성자! 생성자로 오면 장바구니에 담을 상품
	public MyCartList() {
		orderlists = new HashMap<Integer, Integer>();
	}

	public void addOrder(int num, int orderqty) {
		orderlists.put(num, orderqty);
	}
	
	public Map<Integer, Integer> getAllOrder() {
		return this.orderlists;
	}
	
}
