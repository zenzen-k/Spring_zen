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
	
	// ������ ���� �ڵ����� ȣ��Ǵ� �޼���.
	// �Ʒ� ������̼��� ����Ʈ �ϱ� ���� ��Ű���� �ʿ��ϴ�. -> pom.xml �����ʿ�
	@PostConstruct
	public void init() {
		System.out.println("-----init-----");
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("--afterPropertiesSet--");
		String uploadPath = servletContext.getRealPath("/resources/");
		System.out.println("uploadPath : " + uploadPath);
		
		// ���ϰ�ü ����. �Ʒ��� ������ ����
		File destination = new File(uploadPath);
		
		String str = "c:/tempUpload";
		// ���ϰ�ü ����. �ӽ� ��������
		File destination_local = new File(str);
		
		// ���ÿ� �ִ� ������ �������� ������!
		FileUtils.copyDirectory(destination_local, destination);
	}

}
