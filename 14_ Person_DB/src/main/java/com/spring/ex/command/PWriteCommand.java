package com.spring.ex.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.spring.ex.Dao.PDao;

public class PWriteCommand implements PCommand{

	@Override
	public void execute(Model model) {
		// PController�� write()�޼��忡�� ȣ����.
		// Map �� key, value �ѽ�. �� model �� Mapó�� ����ϰڴٴ� �ǹ̴�.
		Map<String, Object> map = model.asMap(); // Ű. ��
		HttpServletRequest request = (HttpServletRequest)map.get("req"); // ��Ʈ�ѷ����� request ��ü�� req�� �����.
		
		System.out.println("PWriteCommand");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		System.out.println(id + "/" + name + "/" + age + "\n");
		
		PDao pdao = PDao.getInstance();
		pdao.write(id, name, Integer.parseInt(age));
		// ���� �۾� �Ϸ��ϸ� �ٽ� ȣ���� ��Ʈ�ѷ��� ����.
	}

}
