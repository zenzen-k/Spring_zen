package example4;

import org.springframework.stereotype.Component;

// Morning Morning = new Morning();
@Component("Morning")
public class Morning implements Car{
	
	public Morning() {
		System.out.println("Morning()");
	}
	
	@Override
	public String driver() {
		return "Morning-drive";
	}
	
}
