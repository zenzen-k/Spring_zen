package example3;

public class Main {
	
	public static void main(String[] args) {
		// ����, 30. morning
		
		Car car = new Morning();
		Consumer con = new Consumer();
		con.setName("����");
		con.setAge(30);
		con.setCar(car);
		
		//System.out.println(con.getCar().driver());
		
	}
	
}
