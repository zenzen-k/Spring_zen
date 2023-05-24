package orderdetail.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailsDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private String namespace = "orderdetail.model.OrderDetail";

	public int insertOrderDetails(OrderDetailsBean odb) {
		int cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace + ".InsertOrderDetails", odb);
		
		return cnt;
	}

//	public List<OrderDetailsBean> getOrderDetaileList(int oid) {
//		List<OrderDetailsBean> odlist = new ArrayList<OrderDetailsBean>();
//		odlist = sqlSessionTemplate.selectList(namespace + ".GetOrderDetaileList", oid);
//		return odlist;
//	}
}
