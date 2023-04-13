package com.gogotennis.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import com.gogotennis.domain.Matching;
import com.gogotennis.domain.Member;
import com.gogotennis.domain.Player;
import com.gogotennis.dto.PlayerAddForm;
import com.gogotennis.repository.MatchingRepository;
import com.gogotennis.repository.MemberRepository;
import com.gogotennis.repository.PlayerRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PlayerService {

	private final MemberRepository memberRepository;

	private final MatchingRepository matchingRepository;

	private final PlayerRepository playerRepository;

	@Transactional
	public void matchingPlayerAdd(PlayerAddForm form) {
		Member member = memberRepository.findById(Long.valueOf(form.getMemberId())).get();
		Matching matching = matchingRepository.findById(Long.valueOf(form.getMatchingId())).get();
		Player player = Player.createPlayerFromForm(form, member, matching);
		playerRepository.save(player);
	}

	public List<Player> findAllByMatchingId(Long matchingId) {
		return playerRepository.findAllByMatchingId(matchingId);
	}

	public List<Player> findByMemberId(Long memberId) {
		return playerRepository.findByMemberId(memberId)
			.stream()
			.filter(list -> list.getMatching().getGameResult() != null)
			.collect(Collectors.toList());
	}

	public List<Player> findByAfterMemberId(Long memberId) {
		return playerRepository.findByMemberId(memberId)
			.stream()
			.filter(list -> list.getMatching().getMatchingStatus().name() == "AFTER")
			.collect(Collectors.toList());
	}

	public List<Player> findByBeforeMemberId(Long memberId) {
		return playerRepository.findByMemberId(memberId).stream().filter(
			list -> list.getMatching().getMatchingStatus().name() == "BEFORE" ||
				list.getMatching().getMatchingStatus().name() == "HOURBEFORE" ||
				list.getMatching().getMatchingStatus().name() == "TWOHOURBEFORE" ||
				list.getMatching().getMatchingStatus().name() == "ONGOING"
		).collect(Collectors.toList());
	}

	public List<Player> findOne(Long memberId) {
		return playerRepository.findByMemberId(memberId);
	}

	public List<Player> findAll() {
		return playerRepository.findAll();
	}
}
