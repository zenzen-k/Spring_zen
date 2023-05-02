package example1;

public class Board {
	
	public void board() { // 생성자가 아닌 메서드다.
		String msg = "게시물 등록";
		System.out.println(msg + "을 위한 로그인 수행"); // 공통
		System.out.println(msg + "하기"); // 핵심
		System.out.println(msg + "을 DB에 저장"); // 공통
		System.out.println(msg + "을 위한 로그아웃"); // 공통
	}
}
