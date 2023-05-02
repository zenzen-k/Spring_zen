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
		System.out.println(per); // toString 메서드
//		System.out.println("이름 : " + per.getName());
//		System.out.println("나이 : " + per.getAge());
//		System.out.println("키 : " + per.getHeight());
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
	}
}
