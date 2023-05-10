package com.spring.ex.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.spring.ex.dao.MartDao;
import com.spring.ex.dto.MartDto;

public class MInsertCommand implements MCommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		MartDto mdto = (MartDto)map.get("martDto");
		
		// 체크하면 on -> 동의함
		if(mdto.getAgree() == null) {
			mdto.setAgree("동의안함");
		}
		
		MartDao mdao = MartDao.getInstance();
		mdao.insertProduct(mdto);
	}

}
