package sample3;

public class StudentImpl extends PersonImpl implements Student {
	private int kor;
	private int eng;
	private PersonImpl per;

	public StudentImpl() {
		System.out.println("StudentImpl");
	}

	public PersonImpl getPer() {
		return per;
	}

	public void setPer(PersonImpl per) {
		this.per = per;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public void studentPrint() {
		System.out.println(per); // toString �޼���
//		System.out.println("�̸� : " + per.getName());
//		System.out.println("���� : " + per.getAge());
//		System.out.println("Ű : " + per.getHeight());
		System.out.println("���� : " + kor);
		System.out.println("���� : " + eng);
	}
}
