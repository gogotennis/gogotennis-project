package com.gogotennis.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import com.gogotennis.domain.Member;
import com.gogotennis.dto.LoginForm;
import com.gogotennis.service.KaKaoService;
import com.gogotennis.service.MemberService;
import com.gogotennis.web.SessionConst;

@Controller
@RequestMapping("oauth")
@RequiredArgsConstructor
public class KakaoController {

	private final KaKaoService kaKaoService;
	private final MemberService memberService;

	@GetMapping("/kakao")
	public String getCI(@RequestParam String code, Model model,
		HttpServletRequest request) throws IOException {

		String access_token = kaKaoService.getToken(code);
		Map<String, Object> userInfo = kaKaoService.getUserInfo(access_token);

		if (memberService.findByEmail(userInfo.get("email").toString()).isEmpty()) {
			Member member = memberService.kakaoSignUp(userInfo, access_token);
			request.getSession().setAttribute(SessionConst.LOGIN_MEMBER, member);
		} else {
			Member member = memberService.findByEmail(userInfo.get("email").toString()).get();
			memberService.renewAccessToken(member, access_token);
			request.getSession().setAttribute(SessionConst.LOGIN_MEMBER, member);
		}

		return "redirect:/";
	}

	@GetMapping("/kakao/logout")
	public String logout(HttpServletRequest request, Model model) {
		model.addAttribute("loginForm", new LoginForm()); //카카오 로그인 용
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "redirect:/";
	}
}
