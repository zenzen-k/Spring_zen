package mall.cart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// ��ٱ���!
public class MyCartList {
	//��ǰ ��ȣ�� �ֹ� ���� �ΰ����� �ѹ������� ǥ��!
	private Map<Integer, Integer> orderlists = null;
	
	// ������! �����ڷ� ���� ��ٱ��Ͽ� ���� ��ǰ
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
