package com.spring.ex.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.spring.ex.dao.MartDao;

public class MDeleteCommand implements MCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		String num = (String)map.get("num");
		// �ٿ�ĳ�����Ҷ� ���࿡ int �Ť������� Integer �� �ٿ�ĳ���� ��
		MartDao mdao = MartDao.getInstance();
		mdao.delete(num);
	}

}
