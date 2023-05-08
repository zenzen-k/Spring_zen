package com.spring.ex.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.spring.ex.DTO.PDto;
import com.spring.ex.Dao.PDao;

public class PListCommand implements PCommand{

	@Override
	public void execute(Model model) {
		PDao pdao = PDao.getInstance();
		ArrayList<PDto> plist = pdao.getAllPerson();
		model.addAttribute("plist", plist);
	}
	
}
