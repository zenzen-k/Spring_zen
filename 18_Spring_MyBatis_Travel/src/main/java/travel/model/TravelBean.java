package travel.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class TravelBean {
	
	// ���ǥ������ �ؾߵȴ�
	private final String must_input = "�ʼ��Է� �����Դϴ�.";
	
	private int num;
	
	@NotEmpty(message = "�̸��� " + must_input)
	@Size(max = 10, message = "�̸��� 10���� �̻� �ȵ�")
	private String name;
	
	@Range(min = 10, max = 100, message = "10 ~ 100�� �ۼ��ؾ� �մϴ�.")
	//Failed to convert property value of type java.lang.String to required type int for property age; nested exception is java.lang.NumberFormatException: For input string: ""
	//null�� ���ڷιٲܼ����ٴ� �⺻ ���� �޼����� ���. ���� �Ʒ� �ڵ� �߰�
	@NotEmpty(message = "���̴�" + must_input) // ����üũ�� int���� ����� �� ���� String������ �����ϴ�.
	//@Min(value = 10, message = "�ּ� 10�� �̻����� �ۼ��ؾ� �մϴ�.")
	//@Max(value = 100, message = "�ִ� 100�� ���Ϸ� �ۼ��ؾ� �մϴ�.")
	private String age;
	
	@NotEmpty(message = "���������� 1�� �̻� �����ؾ� �մϴ�")
	private String area; // checkbox
	
	@NotEmpty(message = "���ϴ� ���� Ÿ���� ������ �ּ���")
	private String style; // radio
	
	@NotEmpty(message = "���ϴ� ���ݴ븦 �����ϼ���")
	private String price; //select
	
	public TravelBean() {
		super();
	}

	public TravelBean(int num, String name, String age, String area, String style, String price) {
		super();
		this.num = num;
		this.name = name;
		this.age = age;
		this.area = area;
		this.style = style;
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
