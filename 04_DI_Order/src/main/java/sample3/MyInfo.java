package sample3;

public class MyInfo {
	// PersonImple, Studimpl 멤버를 변수로 모두 setter
	// 사람정보를 모두 출력할 수 있는 personPrint()
	// student 추력ㄱ메서드

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
		System.out.println("이름 : " + p.getName());
		System.out.println("나이 : " + p.getAge());
		System.out.println("키 : " + p.getHeight());

	}

	public void studentPrint() {
		System.out.println("이름 : " + s.getPer().getName());
		System.out.println("나이 : " + s.getPer().getAge());
		System.out.println("키 : " + s.getPer().getHeight());
		System.out.println("toString : \n" + s.getPer());
		System.out.println("국어 : " + s.getKor());
		System.out.println("영어 : " + s.getEng());
	}

	public void print() {
		s.studentPrint();
	}
}
