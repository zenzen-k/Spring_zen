package example3;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class AopMain {
	public static void main(String[] args) {
		// �ٽɱ�� ȣ��.
		// �ٽɱ���� ȣ���ϸ� �˾Ƽ� �޼��尡 ȣ��ǵ��� xml���Ͽ��� �ۼ���.
		
		AbstractApplicationContext context =  new GenericXmlApplicationContext("aopExam.xml");
		Board myboard = (Board)context.getBean("myboard");
		myboard.board(); // �ٽɱ��
		
		System.out.println("----------");
		
		Order myorder = (Order)context.getBean("myorder");
		myorder.order();
	}
}
