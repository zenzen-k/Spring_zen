package order.model;

public class OrdersBean {

	private int oid;
	private String mid;
	private String orderdate;

	public OrdersBean() {
		super();
	}

	public OrdersBean(int oid, String mid, String orderdate) {
		super();
		this.oid = oid;
		this.mid = mid;
		this.orderdate = orderdate;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

}
