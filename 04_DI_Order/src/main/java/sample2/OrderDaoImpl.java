package sample2;

public class OrderDaoImpl implements OrderDao{
	public OrderDaoImpl() {
		System.out.println("OrderDao ������");
	}

	public void insertOrder() {
		System.out.println("�ֹ����� �߰� : insertOrder()");
	}

	public void removeOrder() {
		System.out.println("�ֹ����� ��� : removeOrder()");
	}
}
