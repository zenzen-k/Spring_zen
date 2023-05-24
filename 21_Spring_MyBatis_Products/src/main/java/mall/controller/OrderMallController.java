package mall.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import member.model.MemberBean;
import order.model.OrdersBean;
import order.model.OrdersDao;

@Controller
public class OrderMallController {
	private final String command = "order.mall";
	private final String getPage = "orderList";
	private final String gotoPage = "redirect:/loginForm.mb";
	
	@Autowired
	OrdersDao ordersDao;
	
	// start.jsp -> 나의 주문내역 -> 컨트롤러
	// 로그인 먼저 확인 ㄱ ㄱ 
	@RequestMapping(value=command)
	public String doAction(HttpSession session, Model model) {
		
		if(session.getAttribute("loginInfo") == null) { // 로그인 안했을 때
			session.setAttribute("destination", "redirect:/order.mall");
			return gotoPage;
		} else { // 로그인 함
			MemberBean mb = (MemberBean)session.getAttribute("loginInfo");
			List<OrdersBean> olist = ordersDao.getOrderList(mb.getId());
			model.addAttribute("olist", olist);
			return getPage;
		}
		
	}
}
