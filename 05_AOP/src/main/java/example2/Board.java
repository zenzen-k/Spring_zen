package example2;

public class Board {
	
	public void board() { // �����ڰ� �ƴ� �޼����.
		String msg = "�Խù� ���";
		
		//System.out.println(msg + "�� ���� �α��� ����"); // ����
		Login.login(msg); // static �̱� ������ Ŭ�����̸����� �޼��忡 ������ �� ����.
		
		System.out.println(msg + "�ϱ�"); // �ٽ�
		
		//System.out.println(msg + "�� DB�� ����"); // ����
		
		//System.out.println(msg + "�� ���� �α׾ƿ�"); // ����
		Logout.logout(msg);
	}
}
