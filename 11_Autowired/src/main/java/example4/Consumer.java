package example4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("Consumer")
public class Consumer implements Person {
	
	// 고객정보
	private String name;
	private int age;

	// 구매자동차
	@Autowired
	@Qualifier("Sonata")
	private Car car; // sonata, morning객체 들어갈수 있다. car의 자식이니까

	public Consumer() {
		System.out.println("Consumer() 생성자");
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
