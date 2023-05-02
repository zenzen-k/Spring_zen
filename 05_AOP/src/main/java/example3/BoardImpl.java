package example3;

import example2.Login;
import example2.Logout;

public class BoardImpl implements Board{

	@Override
	public void board() {
		String msg = "게시물 등록";
		
		System.out.println(msg + " 하기");
		
	}

}
