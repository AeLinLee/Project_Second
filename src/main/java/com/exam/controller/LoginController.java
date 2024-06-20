package com.exam.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.exam.dto.GoodsDTO;
import com.exam.dto.MemberDTO;
import com.exam.service.GoodsService;
import com.exam.service.MemberService;

import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
public class LoginController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	//서비스연동
	MemberService memberService;
	public LoginController(MemberService memberService) {
		this.memberService = memberService;
	}

	//로그인화면 보여주기
	@GetMapping("/login")
	public String loginForm() {
		return "loginForm";    //loginForm 와꾸x버전
	}
	
//	@PostMapping("/login")
//	public String login(@RequestParam Map<String, String> m, ModelMap model) {
//		
//		MemberDTO dto = memberService.login(m);
//		
//		if(dto!=null) {
//			//세션에 저장
//			model.addAttribute("login", dto);
//			return "redirect:main";
//		}
//		model.addAttribute("errorMessage", "아이디 및 비밀번호를 다시 확인 해주세요.");
//		return "loginForm";
//	}
//	

	// 로그아웃처리는 SecurityFilterChain.java 여기로 가면됨.
	
	
	//로그인실패시 로그인페이지로 돌아가기
	@PostMapping(value={"/login_fail"})
	public String showlogin_failPage(RedirectAttributes redirectAttributes) {
		logger.info("logger:showlogin_failPage");
		redirectAttributes.addFlashAttribute("errormessage", "아이디 및 비밀번호를 다시 확인해주세요.");
		return "redirect:login";
	}
	
	//로그인성공시 메인으로 돌아가기
	@GetMapping(value={"/login_success"})
	public String showlogin_successPage() {
		logger.info("logger:showlogin_successPage");
		return "redirect:main";
	}

}