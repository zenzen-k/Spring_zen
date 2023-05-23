package com.spring.ex;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class MyBean implements InitializingBean{
	
	@Autowired
	ServletContext servletContext;
	
	// 생성자 이후 자동으로 호출되는 메서드.
	// 아래 어노테이션을 임포트 하기 위한 패키지가 필요하다. -> pom.xml 설정필요
	@PostConstruct
	public void init() {
		System.out.println("-----init-----");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("--afterPropertiesSet--");
		String uploadPath = servletContext.getRealPath("/resources/");
		System.out.println("uploadPath : " + uploadPath);
		
		// 파일객체 생성. 아래는 웹서버 폴더
		File destination = new File(uploadPath);
		
		String str = "c:/tempUpload";
		// 파일객체 생성. 임시 로컬폴더
		File destination_local = new File(str);
		
		// 로컬에 있는 파일을 웹서버로 복사함!
		FileUtils.copyDirectory(destination_local, destination);
	}

}
