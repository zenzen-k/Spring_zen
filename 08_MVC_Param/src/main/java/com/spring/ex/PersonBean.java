package com.spring.ex;

public class PersonBean {
	private String id;
	private String passwd;
	private String addr;

	public PersonBean() {
		super();
	}

	public PersonBean(String id, String passwd, String addr) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.addr = addr;
	}

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

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}
