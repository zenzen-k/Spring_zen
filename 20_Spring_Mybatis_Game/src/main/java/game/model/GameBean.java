package game.model;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

public class GameBean {
	
	private final String msg = " �ʼ� �Է�";
	
	private int num;
	@NotBlank(message = "����" + msg)
	private String title;
	@NotBlank(message = "ȸ��" + msg)
	private String company;
	@NotBlank(message = "���" + msg)
	private String device;
	@NotBlank(message = "�÷���" + msg)
	private String platform;
	@NotBlank(message = "�帣" + msg)
	private String genre;
	@NotBlank(message = "���" + msg)
	private String grade;
	@NotBlank(message = "����" + msg)
	@Pattern(regexp = "^[0-9]+$", message = "���ڸ� �Է��ϼ���")
	private String price;

	public GameBean() {
		super();
	}

	public GameBean(int num, String title, String company, String device, String platform, String genre, String grade,
			String price) {
		super();
		this.num = num;
		this.title = title;
		this.company = company;
		this.device = device;
		this.platform = platform;
		this.genre = genre;
		this.grade = grade;
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

}
