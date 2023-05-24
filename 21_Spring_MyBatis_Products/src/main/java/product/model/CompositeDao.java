package product.model;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mall.cart.ShoppingList;

@Component
public class CompositeDao {
	private final String namespace = "product.model.Composite";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public List<ProductBean> getOrderDetailByOid(int oid) {
		List<ProductBean> lists = sqlSessionTemplate.selectList(namespace+".GetOrderDetailByOid", oid);
		return lists;
	}

}