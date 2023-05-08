package com.spring.ex;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class MemberBean {
	
	// ��������� �ȵȴٴ� �ǹ�. �ٷ� �ؿ����� ����� ����
	@NotEmpty(message = "���̵� �Է� ����")
	private String id;
	
	//@NotEmpty(message = "��й�ȣ �Է� ����")
	@Size(min = 3, max = 5, message = "3~5 �ڸ� �Է� ����")
	// ����ǥ���Ŀ� ������ �Ⱦ�
	@Pattern(regexp = "^[0-9]+$", message = "���ڸ� �Է� ����")
	private String passwd;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
