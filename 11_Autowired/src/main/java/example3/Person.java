package example3;

public interface Person {
	public void setName(String name);
	public String getName();
	
	public void setAge(int age);
	public int getAge();
	
	public void setCar(Car car);
	public Car getCar();
	
	public String personDrive();
}
