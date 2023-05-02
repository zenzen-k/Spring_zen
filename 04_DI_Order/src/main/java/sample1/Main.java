package sample1;

public class Main {

	public static void main(String[] args) {
		Service service = new Service();
		OrderDao odao = new OrderDao();
		DeliveryDao ddao = new DeliveryDao();
		
		service.setOdao(odao);
		service.setDdao(ddao);
		service.order();
		service.cancel();
	}

}
