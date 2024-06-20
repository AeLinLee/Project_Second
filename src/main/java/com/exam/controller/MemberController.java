package com.exam.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.exam.dto.MemberDTO;
import com.exam.service.MemberService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class MemberController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	//서비스연동
	MemberService memberService;
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
	@GetMapping("/idCheck")
	public @ResponseBody  String idCheck(@RequestParam String userid) {
		MemberDTO dto = memberService.idCheck(userid);
		String mesg = "사용가능";
		if(dto!=null) {
			mesg = "사용불가";
		}
		return mesg;
	}
	

	@GetMapping("/signup")
	public String signupForm(ModelMap m) {
		
		MemberDTO dto = new MemberDTO();
		m.addAttribute("memberDTO", dto);
		
		return "memberForm";
	}
	
	@PostMapping("/signup")
	public String signup(@Valid MemberDTO  dto, BindingResult result) {
		
		if(result.hasErrors()) {
			return "memberForm";
		}
		
		//비번암호화 필수
				String encptPw = new BCryptPasswordEncoder().encode(dto.getPasswd());
				dto.setPasswd(encptPw);
				
		//DB연동
		logger.info("logger:signup:{}", dto);
		
		int n = memberService.memberAdd(dto);
		
		return "redirect:main";
	}
	
	
	@GetMapping("/mypage")
	public String mypage(ModelMap m) {
		
		//AuthProvider에 저장된 Authentication 얻자
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		logger.info("logger:Authentication:{}", auth);
		
		        // 모델에 회원 정보 추가
		        MemberDTO xxx = (MemberDTO) auth.getPrincipal();
		        logger.info("logger:Member:{}", xxx);
		        String userid = xxx.getUserid();
		       
		    	MemberDTO searchDTO = memberService.mypage(userid);
				m.addAttribute("login", searchDTO);
		  
		
		return "mypage";
		

	}
	
//	@GetMapping("/update")
//	public String updateForm(ModelMap m) {
//		
//		MemberDTO dto = new MemberDTO();
//		m.addAttribute("memberDTO", dto);
//		
//		return "mypage";
//	}
//	
//	@PostMapping("/update")
//	public String update(@Valid MemberDTO  dto, BindingResult result) {
//		
//		if(result.hasErrors()) {
//			return "mypage";
//		}
//				
//		//DB연동
//		logger.info("logger:update:{}", dto);
//		
//		int n = memberService.update(dto);
//		
//		return "redirect:mypage";
//	}
	
//	@PostMapping("/update")
//	public String update(ModelMap m) {
//		
//		MemberDTO dto = new MemberDTO();
//		m.addAttribute("memberDTO", dto);
//		
//        String userid = dto.getUserid();
//    	String username = dto.getUsername();
//        String post = dto.getPost();
//        dto.setPost(post);
//        String addr1 = dto.getAddr1();
//        dto.setAddr1(addr1);
//    	String addr2 = dto.getAddr2();
//    	dto.setAddr2(addr2);
//    	String phone1 = dto.getPhone1();
//    	dto.setPhone1(phone1);
//    	String phone2 = dto.getPhone2();
//    	dto.setPhone2(phone2);
//    	String phone3 = dto.getPhone3();
//    	dto.setPhone3(phone3);
//    	String email1 = dto.getEmail1();
//    	dto.setEmail1(email1);
//    	String email2 = dto.getEmail2();
//    	dto.setEmail2(email2);
//    	
//    	int n = memberService.update(dto);
//		m.addAttribute("mypage", n);
//				
//		return "mypage";
//	}
	
//	@PostMapping("/update")
//	public String update(@Valid MemberDTO dto) {
//        String userid = dto.getUserid();
//  	    String username = dto.getUsername();
//		memberService.update(dto);
//		return "redirect:mypage";
//	}
	
	@PostMapping("/update")
	public String update( MemberDTO dto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
	    if (bindingResult.hasErrors()) {
	        redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
	        return "redirect:mypage";  // Redirect back to the form with error messages
	    }

	    try {
	    	logger.info("logger:update:{}", dto);
	        memberService.update(dto);
	        redirectAttributes.addFlashAttribute("successMessage", "Update successful!");
	    } catch (Exception e) {
	        redirectAttributes.addFlashAttribute("errorMessage", "Update failed: " + e.getMessage());
	    }

	    return "redirect:mypage";
	}
	
}