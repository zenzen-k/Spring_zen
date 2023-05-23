package mall.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import mall.cart.MyCartList;
import mall.cart.ShoppingList;
import member.model.MemberBean;
import product.model.ProductBean;
import product.model.ProductDao;

@Controller
public class CartListController {
	private final String command = "list.mall";
	private final String getPage = "cartList";
	
	@Autowired
	private ProductDao productDao;
	
	// 장바구니 목록보기(CartAddController에서 요청)
	// 디비 저장이 아니당
	@RequestMapping(command)
	public String doAction(HttpSession session, Model model) {
		// Map<상품번호, 주문수량>
		Map<Integer, Integer> mapList = ((MyCartList)session.getAttribute("mycart")).getAllOrder();
		// 구매자 정보
		//MemberBean loginInfo = (MemberBean)session.getAttribute("loginInfo");
		// 상품번호가져오기 (map의 key)
		Set<Integer> keyList = mapList.keySet();
		
		// 총가격
		int totalAmount = 0;
		
		List<ShoppingList> slist = new ArrayList<ShoppingList>();
		for(int pnum : keyList) {
			ProductBean pb = productDao.getOneProduct(pnum);
			ShoppingList shopping = new ShoppingList();
			shopping.setPnum(pb.getNum());
			shopping.setPname(pb.getName());
			shopping.setPrice(pb.getPrice()); // 가격
			shopping.setQty(mapList.get(pnum)); // 주문수량
			shopping.setAmount(pb.getPrice()*mapList.get(pnum)); // 주문가격
			totalAmount += pb.getPrice()*mapList.get(pnum);
			slist.add(shopping);
		}
		
		model.addAttribute("slist", slist);
		model.addAttribute("totalAmount", totalAmount);
		
		return getPage;
	}
}
