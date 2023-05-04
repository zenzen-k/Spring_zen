package example4;

import org.springframework.stereotype.Component;

@Component("Sonata")
public class Sonata implements Car{
	
	public Sonata() {
		System.out.println("Sonata()");
	}

	@Override
	public String driver() {
		return "Sonata-drive";
	}
	
}
