package example3;

public class Sonata implements Car{
	
	public Sonata() {
		System.out.println("Sonata()");
	}

	@Override
	public String driver() {
		return "Sonata-drive";
	}
	
}
