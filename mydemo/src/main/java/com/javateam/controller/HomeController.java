package com.javateam.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.javateam.domain.MemberVO;
import com.javateam.service.MemberService;

import lombok.extern.java.Log;

@Log
@Controller
@SessionAttributes("MemberVO")
public class HomeController {
	
	@Inject
	private MemberService service;
	
	@RequestMapping(value="list")
	public String home(Locale locale, Model model)throws Exception {
		
		log.info("******************************** list ********************************");
		
		List<MemberVO> memberList = service.list();
		
		model.addAttribute("memberList", memberList);
		
		return "list";
	}
	
	@RequestMapping(value="/read/{no}")
	public String read(Model model, @PathVariable int no)throws Exception {
		
		log.info("******************************** read ********************************");
		
		model.addAttribute("MemberVO",service.read(no));
		
		return "read";
	}
	
	
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public String write(Model model)throws Exception {
		
		log.info("******************************** write ********************************");
		
		model.addAttribute("MemberVO",new MemberVO());
		
		return "write";
	}
	
	@RequestMapping(value="/write",method=RequestMethod.POST)
	public String write(@Valid @ModelAttribute("MemberVO")MemberVO memberVO,
			BindingResult bindingResult,SessionStatus sessionStatus)throws Exception {
		
		log.info( "******************************** write validator Error! ********************************");
		
		if(bindingResult.hasErrors()) {
			return "write";
		}else {
			service.write(memberVO);
			sessionStatus.setComplete();
			return "redirect:list";
		}
		
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(@ModelAttribute MemberVO memberVO) throws Exception{
		
		log.info( "******************************** edit ********************************");
		
		return "edit";
	}
	
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("MemberVO")MemberVO memberVO,
		BindingResult bindingResult,String password,SessionStatus sessionStatus,Model model) throws Exception {
		
		log.info("******************************** edit vaildation start ********************************");
		
		
		if(bindingResult.hasErrors()){
			model.addAttribute("msg","비밀번호가 일치하지 않습니다");
			return "edit";
		
		}else {
			
			if(memberVO.getPassword()==password) {
				
				service.edit(memberVO);
				sessionStatus.setComplete();
				return "redirect:list";
			}
			return "edit";
		}
	}
	
	@RequestMapping(value="/delete/{no}",method=RequestMethod.GET)
	public String delete(@PathVariable int no,Model model)throws Exception {
		
		log.info("**************************** delete GET *********************************");
		
		model.addAttribute("no",no);
		return "delete";
		
	}
	
	
	@RequestMapping(value="delete/{no}",method=RequestMethod.POST)
	public String delete(int no,String password,Model model) throws Exception{
		
		log.info("*************************** delete POST *********************************");
		
		int rowCount;
		MemberVO memberVO = new MemberVO();
		memberVO.setNo(no);
		memberVO.setPassword(password);
		
		rowCount = service.delete(memberVO);
		
		if(rowCount == 0) {
			model.addAttribute("no",no);
			model.addAttribute("msg","비밀번호가 일치하지 않습니다");
			return "delete";
		}else {
			return "redirect:/list";
		}
	}
	
	
}
