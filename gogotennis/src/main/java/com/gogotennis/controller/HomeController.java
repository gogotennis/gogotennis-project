package com.gogotennis.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.gogotennis.dto.LoginForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeController {

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("loginForm", new LoginForm()); //Modal창 용
		return "home";
	}
}
