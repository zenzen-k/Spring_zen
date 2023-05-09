package com.spring.ex.dto;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class FDto {
	
	private int num;
	
	@NotBlank(message = "���̵� �Է��ϼ���")
	private String id;
	
	@NotBlank(message = "��й�ȣ�� �Է��ϼ���")
	private String pw;
	
	@NotBlank(message = "��¿��󱹰� �Ѱ� �̻� �����ؾ� �մϴ�.")
	private String win;
	
	@NotBlank(message = "16�� ���� �Ѱ� �̻� �����ؾ� �մϴ�.")
	private String round16;

	public FDto() {
		super();
	}

	public FDto(int num, String id, String pw, String win, String round16) {
		super();
		this.num = num;
		this.id = id;
		this.pw = pw;
		this.win = win;
		this.round16 = round16;
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

	public String getWin() {
		return win;
	}

	public void setWin(String win) {
		this.win = win;
	}

	public String getRound16() {
		return round16;
	}

	public void setRound16(String round16) {
		this.round16 = round16;
	}

}
