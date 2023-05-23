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
	
	// ��ٱ��� ��Ϻ���(CartAddController���� ��û)
	// ��� ������ �ƴϴ�
	@RequestMapping(command)
	public String doAction(HttpSession session, Model model) {
		// Map<��ǰ��ȣ, �ֹ�����>
		Map<Integer, Integer> mapList = ((MyCartList)session.getAttribute("mycart")).getAllOrder();
		// ������ ����
		//MemberBean loginInfo = (MemberBean)session.getAttribute("loginInfo");
		// ��ǰ��ȣ�������� (map�� key)
		Set<Integer> keyList = mapList.keySet();
		
		// �Ѱ���
		int totalAmount = 0;
		
		List<ShoppingList> slist = new ArrayList<ShoppingList>();
		for(int pnum : keyList) {
			ProductBean pb = productDao.getOneProduct(pnum);
			ShoppingList shopping = new ShoppingList();
			shopping.setPnum(pb.getNum());
			shopping.setPname(pb.getName());
			shopping.setPrice(pb.getPrice()); // ����
			shopping.setQty(mapList.get(pnum)); // �ֹ�����
			shopping.setAmount(pb.getPrice()*mapList.get(pnum)); // �ֹ�����
			totalAmount += pb.getPrice()*mapList.get(pnum);
			slist.add(shopping);
		}
		
		model.addAttribute("slist", slist);
		model.addAttribute("totalAmount", totalAmount);
		
		return getPage;
	}
}
