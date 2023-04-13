package com.gogotennis.controller;

import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import com.gogotennis.service.CertificationService;
import com.gogotennis.service.MemberService;

@RestController
@RequestMapping("api/sms")
@RequiredArgsConstructor
public class SmsApiController {

	private final CertificationService certificationService;
	private final MemberService memberService;

	@GetMapping("/check/sendSMS")
	public String sendSMS(String phoneNumber, HttpServletResponse response) {
		Random rand = new Random();
		String numStr = "";
		for (int i = 0; i < 4; i++) {
			String ran = Integer.toString(rand.nextInt(10));
			numStr += ran;
		}

		if (phoneNumber != null) {
			certificationService.certifiedPhoneNumber(phoneNumber, numStr);
		}
		return numStr;
	}
}
