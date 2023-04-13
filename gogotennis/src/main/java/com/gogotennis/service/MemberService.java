package com.gogotennis.service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import com.gogotennis.domain.Member;
import com.gogotennis.domain.Record;
import com.gogotennis.dto.MemberSaveForm;
import com.gogotennis.dto.MemberUpdateForm;
import com.gogotennis.dto.UpdatePasswordForm;
import com.gogotennis.repository.MemberRepository;
import com.gogotennis.repository.RecordRepository;
import com.gogotennis.web.PasswordEncrypt;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

	private final MemberRepository memberRepository;
	private final RecordRepository recordRepository;

	@Transactional
	public Long signUp(MemberSaveForm form) throws NoSuchAlgorithmException {
		Record record = Record.createRecord();
		recordRepository.save(record);
		Member member = Member.createMember(form, record);
		memberRepository.save(member);
		return member.getId();
	}

	public Optional<Member> findByLoginId(String loginId) {
		return memberRepository.findByLoginId(loginId);
	}

	public Optional<Member> findByNickname(String nickname) {
		return memberRepository.findByNickname(nickname);
	}

	public Optional<Member> findByEmail(String email) {
		return memberRepository.findByEmail(email);
	}

	public Member findById(Long memberId) {
		return memberRepository.findById(memberId).get();
	}

	public List<Member> findAll() {
		return memberRepository.findAll();
	}

	@Transactional
	public Member kakaoSignUp(Map<String, Object> userInfo, String access_token) {
		Record record = Record.createRecord();
		Member member = Member.createKakaoMember(userInfo, access_token, record);
		recordRepository.save(record);
		memberRepository.save(member);
		return member;
	}

	@Transactional
	public void renewAccessToken(Member member, String access_token) {
		member.setAccessToken(access_token);
	}

	@Transactional
	public void updatePassword(UpdatePasswordForm form, Member member) throws NoSuchAlgorithmException {
		PasswordEncrypt passwordEncrypt = new PasswordEncrypt();
		member.setPassword(passwordEncrypt.encrypt(form.getUpdatePassword()));
		memberRepository.save(member);
	}

	public Optional<Member> findByPhoneNum(String phoneNum) {
		return memberRepository.findByPhoneNum(phoneNum);
	}

	@Transactional
	public Long updateMember(MemberUpdateForm form, MultipartFile file) throws IOException {

		Member member = findById(form.getId());
		member.updateMember(form, member);

		return member.getId();
	}

	@Transactional
	public Long memberWithDrawl(Long memberId, String uuid) {

		Member member = findById(memberId);

		member.memberWithdrawl(member, uuid);

		return member.getId();
	}

	@Transactional
	public void setProfileImage(String s, MemberUpdateForm form) {
		Member member = memberRepository.findById(form.getId()).get();
		member.setImage(s);
	}

	@Transactional
	public void setBasicProfileImage(String s, Long memberId) {
		Member member = memberRepository.findById(memberId).get();
		member.setImage(s);
	}
}


