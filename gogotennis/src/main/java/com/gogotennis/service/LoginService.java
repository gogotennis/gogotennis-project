package com.gogotennis.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import com.gogotennis.domain.Member;
import com.gogotennis.repository.MemberRepository;
import com.gogotennis.web.PasswordEncrypt;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LoginService {

	private final MemberRepository memberRepository;

	public Member login(String loginId, String password) throws NoSuchAlgorithmException {
		PasswordEncrypt passwordEncrypt = new PasswordEncrypt();
		String encryptedPassword = passwordEncrypt.encrypt(password);
		return memberRepository.findByLoginId(loginId).filter(m -> m.getPassword()
			.equals(encryptedPassword)).orElse(null);
	}
}
