package sample3;

public class MyInfo {
	// PersonImple, Studimpl ����� ������ ��� setter
	// ��������� ��� ����� �� �ִ� personPrint()
	// student �߷¤��޼���

	private PersonImpl p;
	private StudentImpl s;
	
	public MyInfo() {
		System.out.println("MyInfo");
	}

	public PersonImpl getP() {
		return p;
	}

	public void setP(PersonImpl p) {
		this.p = p;
	}

	public StudentImpl getS() {
		return s;
	}

	public void setS(StudentImpl s) {
		this.s = s;
	}

	public void personPrint() {
		System.out.println("�̸� : " + p.getName());
		System.out.println("���� : " + p.getAge());
		System.out.println("Ű : " + p.getHeight());

	}

	public void studentPrint() {
		System.out.println("�̸� : " + s.getPer().getName());
		System.out.println("���� : " + s.getPer().getAge());
		System.out.println("Ű : " + s.getPer().getHeight());
		System.out.println("toString : \n" + s.getPer());
		System.out.println("���� : " + s.getKor());
		System.out.println("���� : " + s.getEng());
	}

	public void print() {
		s.studentPrint();
	}
}
