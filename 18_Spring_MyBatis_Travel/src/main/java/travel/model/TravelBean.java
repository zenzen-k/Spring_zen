package travel.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class TravelBean {
	
	// 상수표현으로 해야된당
	private final String must_input = "필수입력 사항입니다.";
	
	private int num;
	
	@NotEmpty(message = "이름은 " + must_input)
	@Size(max = 10, message = "이름은 10글자 이상 안됨")
	private String name;
	
	@Range(min = 10, max = 100, message = "10 ~ 100살 작성해야 합니다.")
	//Failed to convert property value of type java.lang.String to required type int for property age; nested exception is java.lang.NumberFormatException: For input string: ""
	//null을 숫자로바꿀수없다는 기본 오류 메세지가 뜬다. 따라서 아래 코드 추가
	@NotEmpty(message = "나이는" + must_input) // 누락체크는 int에서 사용할 수 없고 String에서만 가능하다.
	//@Min(value = 10, message = "최소 10살 이상으로 작성해야 합니다.")
	//@Max(value = 100, message = "최대 100살 이하로 작성해야 합니다.")
	private String age;
	
	@NotEmpty(message = "관심지역은 1개 이상 선택해야 합니다")
	private String area; // checkbox
	
	@NotEmpty(message = "원하는 여행 타입을 선택해 주세요")
	private String style; // radio
	
	@NotEmpty(message = "원하는 가격대를 선택하세요")
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
