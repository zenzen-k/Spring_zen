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
	private final String gotoPage = "redirect:/list.prd"; // ��ǰ��Ϻ���� �̵���
	
	@Autowired
	OrdersDao ordersDao;
	@Autowired
	OrderDetailsDao odetailsDao;
	@Autowired
	ProductDao productDao;
	@Autowired
	MemberDao memberDao;
	
	// cartList.jsp ���� �����ϱ� -> calculate.mall��û��.
	@RequestMapping(value = command)
	public String doAction(HttpSession session) {
		// �α����� ����� id ���� �ʿ�
		// ��ٱ��� ���� �ʿ� (orderlists)
		// orders ���̺� : OID ������, MID �α��ξ��̵�, ORDERDAT ���ó�¥
		// orderdetails ���̺� : ODID ������, OID �ֹ����̺��� OID(�����ֱٹ�ȣ), PNUM(��ǰ��ȣ), QTY(�ֹ�����)
		
		// �α��� ����
		String ordersId = ((MemberBean)session.getAttribute("loginInfo")).getId();
		/* orders ���̺� ���� */
		int cnt = ordersDao.insertOrders(ordersId);
		System.out.println("cnt : " + cnt);
		
		int cnt2 = 0;
		if(cnt != -1) { // orders ���� �۾� ����
			
			/* orderdetails ���̺� ���� */
			
			// ��ٱ��� ���� ��������
			Map<Integer, Integer> mapList = ((MyCartList)session.getAttribute("mycart")).getAllOrder();
			// �ֹ���ǰ��ȣ
			Set<Integer> keyPnum = mapList.keySet(); 
			// oid ���� ū�� �������°� ���⼭ �ص� ��!
			for(int key : keyPnum) {
				OrderDetailsBean odb = new OrderDetailsBean();
				odb.setPnum(key);
				odb.setQty(mapList.get(key));
				cnt2 += odetailsDao.insertOrderDetails(odb);
				
				// ��ǰ������ ����
				int pcnt = productDao.stockUpdate(odb.getPnum(), odb.getQty()); // ��ǰ��ȣ�� �ֹ����� ��������
				
				if(pcnt != -1) {
					System.out.println("����������");
				}else {
					System.out.println("����������");
				}
			}
			System.out.print("cnt2 : " + cnt);
			
			if(cnt2 == mapList.size()) {
				System.out.println("��������");
			}else {
				System.out.println("��������");
			}
			
			//ȸ�� ����Ʈ 100�� �߰�
			int pointcnt = memberDao.updatePoint(ordersId, 100);
			if(pointcnt != -1) {
				System.out.println("����Ʈ�߰�����");
			}else {
				System.out.println("����Ʈ�߰�����");
			}
		}
		
		return gotoPage;
	}
}
