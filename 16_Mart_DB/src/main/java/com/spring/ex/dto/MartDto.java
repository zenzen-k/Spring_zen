package com.spring.ex.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class MartDto {
	
	private int num;
	
	@NotBlank(message = "id �Է� ����")
	private String id;
	@NotBlank(message = "pw �Է� ����")
	private String pw;
	@NotBlank(message = "��ǰ �Է� ����")
	private String product;
	//@NotEmpty(message = "time �Է� ����") ��
	//@NotBlank(message = "time �Է� ����") ��
	//@NotNull(message = "time �Է� ����") �ȵ�
	//@Length(min = 1, message = "time �Է� ����") // �� 
	@Size(min = 1, message = "time �Է� ����1")// �� 
	private String time;
	@NotBlank(message = "approve �Է� ����")
	private String approve;
	//@NotBlank(message = "agree �Է� ����")
	private String agree;

	public MartDto() {
		super();
	}

	public MartDto(int num, String id, String pw, String product, String time, String approve, String agree) {
		super();
		this.num = num;
		this.id = id;
		this.pw = pw;
		this.product = product;
		this.time = time;
		this.approve = approve;
		this.agree = agree;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
	}

	public String getAgree() {
		return agree;
	}

	public void setAgree(String agree) {
		this.agree = agree;
	}

}
