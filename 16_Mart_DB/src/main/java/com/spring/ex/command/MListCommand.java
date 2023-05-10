package com.spring.ex.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.spring.ex.dao.MartDao;
import com.spring.ex.dto.MartDto;

public class MListCommand implements MCommand {

	@Override
	public void execute(Model model) {
		MartDao mdao = MartDao.getInstance();
		ArrayList<MartDto> lists = mdao.getAllMart();
		model.addAttribute("lists", lists);
	}

}
