package example3;

public class Morning implements Car{
	
	public Morning() {
		System.out.println("Morning()");
	}
	
	@Override
	public String driver() {
		return "Morning-drive";
	}
	
}
