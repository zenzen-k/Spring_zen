package example3;

public class Main {
	
	public static void main(String[] args) {
		// ����, 30. morning
		Person per = new Consumer();
		
		Car m = new Morning();
		per.setName("����");
		per.setAge(30);
		per.setCar(m);
		
		System.out.println(per.getName());
		System.out.println(per.getAge());
		System.out.println(per.personDrive());
		
		
		System.out.println("-------------------------");
		
		
		// ����,0,sonata
		Person per2 = new Consumer();
		per2.setName("����");
		per2.setAge(30);
		per2.setCar(new Sonata());
		
		System.out.println(per2.getName());
		System.out.println(per2.getAge());
		System.out.println(per2.personDrive());
		
	}
	
}
