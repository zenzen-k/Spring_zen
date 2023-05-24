package mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import product.model.CompositeDao;
import product.model.ProductBean;

@Controller
public class OrderDetailContoller {
	// orderList.jsp에서 상세보기 클릭
	private final String command = "orderDetail.mall";
	private final String getPage = "orderdetailView";

	@Autowired
	CompositeDao cdao;

	// orderList.jsp 에서 상세보기 클릭 -> 컨트롤러
	@RequestMapping(command)
	public String doAction(@RequestParam("oid") int oid, Model model) {

		List<ProductBean> lists = cdao.getOrderDetailByOid(oid);
		System.out.println("lists:" + lists.size());
		model.addAttribute("lists", lists);

		return getPage;
	}
}
