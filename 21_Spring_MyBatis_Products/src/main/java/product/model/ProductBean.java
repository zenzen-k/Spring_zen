package product.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class ProductBean {
	private int num;

	@Size(min = 3, max = 10, message = "3~10 자리 입력")
	private String name;
	private String company;

	@NotEmpty(message = "파일 선택 필수")
	private String image;
	private int stock;

	@Min(value = 3000, message = "최소 3000원 이상 입력")
	private int price;
	private String category;

	@Length(min = 3, max = 10, message = "3~10 자리 입력")
	private String contents;
	private int point;
	private String inputdate;
	
	// 파일을 담을 임시 변수
	private MultipartFile upload;
	private String upload2;

	public ProductBean() {
		super();
	}

	public ProductBean(int num, String name, String company, String image, int stock, int price, String category,
			String contents, int point, String inputdate) {
		super();
		this.num = num;
		this.name = name;
		this.company = company;
		this.image = image;
		this.stock = stock;
		this.price = price;
		this.category = category;
		this.contents = contents;
		this.point = point;
		this.inputdate = inputdate;
	}
	
	public String getUpload2() {
		return upload2;
	}

	public void setUpload2(String upload2) {
		this.upload2 = upload2;
	}

	public MultipartFile getUpload() {
		return upload;
	}

	public void setUpload(MultipartFile upload) {
		System.out.println("setUpload");
		this.upload = upload;
		
		System.out.println("upload : " + upload); // upload에는 내가 선택한 화일의 정보가 들어간다.
		
		// 파일의 오리지널 이름을 가져온다.
		String fileName = upload.getOriginalFilename();
		System.out.println("fileName : " + fileName);
		
		// this 안붙여도 ㄱㅊ지만 멤버변수 확실히 하기 위해서!
		// 파일명을 image 변수에 넣는다
		this.image = fileName;
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getInputdate() {
		return inputdate;
	}

	public void setInputdate(String inputdate) {
		this.inputdate = inputdate;
	}

}
