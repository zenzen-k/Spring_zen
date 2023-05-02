package sample2;

public class DeliveryDaoImpl implements DelivaryDao{
	public DeliveryDaoImpl() {
		System.out.println("DeliveryDao() 생성자");
	}

	public void insertAddress() {
		System.out.println("배송지 정보추가 : insertAddress()");
	}

	public void removeAddress() {
		System.out.println("배송지 정보취소 : removeAddress()");
	}
}
