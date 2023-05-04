package com.spring.ex;

import org.hibernate.validator.constraints.NotEmpty;

public class MemberBean {
	
	// ��������� �ȵȴٴ� �ǹ�. �ٷ� �ؿ����� ����� ����
	@NotEmpty(message = "���̵� �Է� ����")
	private String id;
	@NotEmpty(message = "��й�ȣ �Է� ����")
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
