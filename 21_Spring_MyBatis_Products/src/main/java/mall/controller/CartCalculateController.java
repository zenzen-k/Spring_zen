package mall.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mall.cart.MyCartList;
import member.model.MemberBean;
import member.model.MemberDao;
import order.model.OrdersDao;
import orderdetail.model.OrderDetailsBean;
import orderdetail.model.OrderDetailsDao;
import product.model.ProductDao;

@Controller
public class CartCalculateController {
	private final String command = "calculate.mall";
	private final String gotoPage = "redirect:/list.prd"; // 상품목록보기로 이동함
	
	@Autowired
	OrdersDao ordersDao;
	@Autowired
	OrderDetailsDao odetailsDao;
	@Autowired
	ProductDao productDao;
	@Autowired
	MemberDao memberDao;
	
	// cartList.jsp 에서 결제하기 -> calculate.mall요청함.
	@RequestMapping(value = command)
	public String doAction(HttpSession session) {
		// 로그인한 사람의 id 정보 필요
		// 장바구니 정보 필요 (orderlists)
		// orders 테이블 : OID 시퀀스, MID 로그인아이디, ORDERDAT 오늘날짜
		// orderdetails 테이블 : ODID 시퀀스, OID 주문테이블의 OID(가장최근번호), PNUM(상품번호), QTY(주문수량)
		
		// 로그인 정보
		String ordersId = ((MemberBean)session.getAttribute("loginInfo")).getId();
		/* orders 테이블 삽입 */
		int cnt = ordersDao.insertOrders(ordersId);
		System.out.println("cnt : " + cnt);
		
		int cnt2 = 0;
		if(cnt != -1) { // orders 삽입 작업 성공
			
			/* orderdetails 테이블 삽입 */
			
			// 장바구니 정보 가져오기
			Map<Integer, Integer> mapList = ((MyCartList)session.getAttribute("mycart")).getAllOrder();
			// 주문상품번호
			Set<Integer> keyPnum = mapList.keySet(); 
			// oid 제일 큰값 가져오는거 여기서 해도 됨!
			for(int key : keyPnum) {
				OrderDetailsBean odb = new OrderDetailsBean();
				odb.setPnum(key);
				odb.setQty(mapList.get(key));
				cnt2 += odetailsDao.insertOrderDetails(odb);
				
				// 상품재고수량 감소
				int pcnt = productDao.stockUpdate(odb.getPnum(), odb.getQty()); // 상품번호와 주문수량 가져가기
				
				if(pcnt != -1) {
					System.out.println("재고수정성공");
				}else {
					System.out.println("재고수정실패");
				}
			}
			System.out.print("cnt2 : " + cnt);
			
			if(cnt2 == mapList.size()) {
				System.out.println("결제성공");
			}else {
				System.out.println("결제실패");
			}
			
			//회원 포인트 100점 추가
			int pointcnt = memberDao.updatePoint(ordersId, 100);
			if(pointcnt != -1) {
				System.out.println("포인트추가성공");
			}else {
				System.out.println("포인트추가실패");
			}
		}
		
		return gotoPage;
	}
}
