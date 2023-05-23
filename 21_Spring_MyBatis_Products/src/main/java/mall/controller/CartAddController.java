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
	private final String gotoPage = "redirect:/list.mall"; // ��ٱ��� ��� ���� ��û
	
	
	// ��ǰ �󼼺��� -> �ֹ�Ŭ�� => add.mall (post)��û
	@RequestMapping(value=command)
	public String doAction(
			@RequestParam("pageNumber") int pageNumber,
			@RequestParam("num") int num,
			@RequestParam("orderqty") int orderqty,
			HttpSession session) {
		
		if(session.getAttribute("loginInfo") == null) { //�α��� X
			// destination ���� ������ ��� �ٲ��.
			// redirect:/insert.prd : ��ǰ�߰�
			// redirect:/detail.prd : ��ǰ�ֹ�
			session.setAttribute("destination", "redirect:/detail.prd?num=" + num +"&pageNumber=" + pageNumber);
			// detail.prd ��û ó���ϴ� ������ num�� pageNumber�� �䱸�ϱ⶧���� �Ѱܾ���
			return "redirect:/loginForm.mb"; 
			// MemberLoginController -> memberLoginForm.jsp -> �α����ϸ� destination�� ���� detail.prd��
			
		}else { //�α��� O
			// ù��° ��ٱ��Ͽ����� ��ü����. �ι�°���ʹ� ���� ������ �����ü��־ null�� �ƴ�!
			MyCartList mycart = (MyCartList)session.getAttribute("mycart");
			if(mycart == null) { // ó��. �̶��� ��ü����
				// ��ٱ���
				mycart = new MyCartList();
			}
			mycart.addOrder(num, orderqty); 
			
			// ��ٱ��ϴ� �ѹ��� ���� ������ �ٴϸ�ȴ�. ������ü�� �����ʿ䰡 ����.
			// ���� �������� ��������
			session.setAttribute("mycart", mycart);
			return gotoPage;
		}
	}
}
