package order.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrdersDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private String namespace = "order.model.Order";

	public int insertOrders(String ordersId) {
		int cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace + ".InsertOrders", ordersId);
		return cnt;
	}

	public List<OrdersBean> getOrderList(String mid) {
		List<OrdersBean> olist = new ArrayList<OrdersBean>();
		olist = sqlSessionTemplate.selectList(namespace + ".GetOrderList", mid);
		return olist;
	}
}
