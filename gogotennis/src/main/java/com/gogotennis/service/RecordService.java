package com.gogotennis.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.gogotennis.domain.Member;
import com.gogotennis.repository.MemberRepository;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RecordService {

	private final MemberRepository memberRepository;

	public List<Member> findRankTopThree() {
		return memberRepository.findRankTopThree();
	}

	public List<Member> findRankList() {
		return memberRepository.findRankList();
	}
}
