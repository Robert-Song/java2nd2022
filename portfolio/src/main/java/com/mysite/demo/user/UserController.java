package com.mysite.demo.user;

import javax.validation.Valid;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {
	private final UserService userService;
	
	@GetMapping("/signup")
	public String signup(UserCreateForm userCreateForm) {
		return "signup_form";
	}
	
	
	@PostMapping("/signup")
	public String signup(@Valid UserCreateForm userCreateForm,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "signup_form";
		}
		if(!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
			bindingResult.rejectValue("password2", "passwordIncorrect", "2개의 패스워드가 일치하지 않습니다.");
			return "signup_form";
		}
		
		//정상적으로 처리될 경우
		try {
			userService.create(userCreateForm.getUsername(),
					userCreateForm.getEmail(), userCreateForm.getPassword1());
		} catch (DataIntegrityViolationException e){
			e.printStackTrace();
			bindingResult.reject("signupFailed", "이미 등록되어있는 사용자, 혹은 등록된 이메일 입니다.");
			return "signup_form";
		} catch (Exception e) {
			e.printStackTrace();
			bindingResult.reject("signupFailed", e.getMessage());
			return "signup_form";
		}
		
		return "redirect:/";	
	}
	
	@GetMapping("/login")
	public String login() {
		return "login_form";
	}
	
	
}


//로그인 구현
//회원가입을 통해 저장된 사용자 정보를
//받아와서 일치한지 확인후 로그인 이라는 절차를 거친다
//
