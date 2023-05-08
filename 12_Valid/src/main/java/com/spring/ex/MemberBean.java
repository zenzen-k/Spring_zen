package com.spring.ex;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class MemberBean {
	
	// 비어있으면 안된다는 의미. 바로 밑에꺼만 적용됨 ㅇㅇ
	@NotEmpty(message = "아이디 입력 누락")
	private String id;
	
	//@NotEmpty(message = "비밀번호 입력 누락")
	@Size(min = 3, max = 5, message = "3~5 자리 입력 가능")
	// 정규표현식에 슬래시 안씀
	@Pattern(regexp = "^[0-9]+$", message = "숫자만 입력 가능")
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
