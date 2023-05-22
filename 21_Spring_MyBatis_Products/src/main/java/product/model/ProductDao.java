package product.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import utility.Paging;

@Component
public class ProductDao {
	
	private String namespace = "product.model.Product";
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;

	public List<ProductBean> getProdList(Paging pageInfo, Map<String, String> map) {
		List<ProductBean> productLists = new ArrayList<ProductBean>(); 
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		productLists = sqlSessionTemplate.selectList(namespace + ".GetProdList", map, rowBounds);
		return productLists;
	}

	public int getTotalCount(Map<String, String> map) {
		int count = sqlSessionTemplate.selectOne(namespace + ".GetTotalCount", map);
		return count;
	}

	public int insertProduct(ProductBean product) {
		int cnt = -1;
		cnt = sqlSessionTemplate.insert(namespace + ".InsertProduct", product);
//		try {
//			cnt = sqlSessionTemplate.insert(namespace + ".InsertProduct", product);
//		}catch (DataAccessException e) {
//			System.out.println("insert fail");
//		}
		return cnt;
	}

	public ProductBean getOneProduct(int num) {
		ProductBean product = sqlSessionTemplate.selectOne(namespace + ".GetOneProduct", num);
		return product;
	}

	public int deleteProduct(int num) {
		int cnt = -1;
		cnt = sqlSessionTemplate.delete(namespace + ".DeleteProduct", num);
		return cnt;
	}

	public int updateProduct(ProductBean product) {
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace + ".UpdateProduct", product);
		return cnt;
	}
	
}
