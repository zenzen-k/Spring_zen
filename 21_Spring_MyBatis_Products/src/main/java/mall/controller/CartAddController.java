package mall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mall.cart.MyCartList;

@Controller
public class CartAddController {
	private final String command = "/add.mall";
	private final String gotoPage = "redirect:/list.mall"; // 장바구니 목록 보기 요청
	
	
	// 상품 상세보기 -> 주문클릭 => add.mall (post)요청
	@RequestMapping(value=command)
	public String doAction(
			@RequestParam("pageNumber") int pageNumber,
			@RequestParam("num") int num,
			@RequestParam("orderqty") int orderqty,
			HttpSession session) {
		
		if(session.getAttribute("loginInfo") == null) { //로그인 X
			// destination 세션 설정은 계속 바뀐다.
			// redirect:/insert.prd : 상품추가
			// redirect:/detail.prd : 상품주문
			session.setAttribute("destination", "redirect:/detail.prd?num=" + num +"&pageNumber=" + pageNumber);
			// detail.prd 요청 처리하는 곳에서 num과 pageNumber를 요구하기때문에 넘겨야함
			return "redirect:/loginForm.mb"; 
			// MemberLoginController -> memberLoginForm.jsp -> 로그인하면 destination에 따라 detail.prd로
			
		}else { //로그인 O
			// 첫번째 장바구니에서만 객체생성. 두번째부터는 세션 정보를 가져올수있어서 null이 아님!
			MyCartList mycart = (MyCartList)session.getAttribute("mycart");
			if(mycart == null) { // 처음. 이때만 객체생성
				// 장바구니
				mycart = new MyCartList();
			}
			mycart.addOrder(num, orderqty); 
			
			// 장바구니는 한번만 만들어서 가지고 다니면된다. 여러객체를 만들필요가 없다.
			// 따라서 세션으로 설정해쥼
			session.setAttribute("mycart", mycart);
			return gotoPage;
		}
	}
}
