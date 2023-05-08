package example3;

public class Consumer implements Person {

	// ��������
	private String name;
	private int age;

	// �����ڵ���
	private Car car; // sonata, morning��ü ���� �ִ�. car�� �ڽ��̴ϱ�

	public Consumer() {
		System.out.println("Consumer() ������");
	}

	@Override
	public String personDrive() {
		return car.driver();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

}