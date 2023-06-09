package com.gogotennis.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import com.gogotennis.domain.Matching;
import com.gogotennis.domain.Member;
import com.gogotennis.domain.Player;
import com.gogotennis.domain.ResultTemp;
import com.gogotennis.dto.MatchingSaveForm;
import com.gogotennis.dto.MatchingSearchCondition;
import com.gogotennis.dto.MatchingUpdateForm;
import com.gogotennis.dto.ResultAddForm;
import com.gogotennis.repository.MatchingRepository;
import com.gogotennis.repository.PlayerRepository;
import com.gogotennis.repository.ResultTempRepository;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MatchingService {

	private final MatchingRepository matchingRepository;

	private final PlayerRepository playerRepository;

	private final ResultTempRepository resultTempRepository;

	public Matching findOne(Long matchingId) {
		return matchingRepository.findOne(matchingId);
	}

	@Transactional
	public Page<Matching> getMatchingList(Pageable pageable) {
		return matchingRepository.findAll(pageable);
	}

	@Transactional
	public List<Player> getPlayerList(Long matchingId) {
		return playerRepository.findAllByMatchingId(matchingId);
	}

	// 매칭 등록
	@Transactional
	public Long addMatching(MatchingSaveForm form, Member member) {
		Matching matching = Matching.createMatching(form, member);
		Player player = Player.createPlayer(matching, member);
		matchingRepository.save(matching);
		playerRepository.save(player);
		return matching.getId();
	}

	@Transactional
	public void deleteById(Long matchingId, List<Player> players) {
		playerRepository.deleteAllInBatch(players);
		matchingRepository.deleteById(matchingId);
	}

	@Transactional
	public void update(MatchingUpdateForm form, Member member) {
		Matching matching = matchingRepository.findOne(form.getId());
		matching.updateMatching(matching, form, member);
	}

	public void increasePlayerNumber(Long matchingId) {
		matchingRepository.increasePlayerNumber(matchingId);
	}

	public void matchingCondtionCheck(Long matchingId) {
		matchingRepository.matchingCondtionCheck(matchingId);
	}

	public Player playerMemberCheck(Long matchingId, Long memberId) {
		Optional<Player> result = playerRepository.exist(matchingId, memberId);
		if (result.isEmpty()) {
			return null;
		}
		return result.get();
	}

	public void deleteMatchingMember(Long matchingId, Long memberId) {
		Player player = playerMemberCheck(matchingId, memberId);
		playerRepository.delete(player);
		Matching matching = matchingRepository.findOne(matchingId);
		matching.setPlayerNumber(matching.getPlayerNumber() - 1);
	}

	@Transactional
	public void resultTempAdd(ResultAddForm result, Member member) {
		Optional<Player> player = playerRepository.exist(result.getId(), member.getId());
		Player.updateResultStatus(player.get());
		resultTempRepository.save(ResultTemp.createResultTemp(result, player.get()));
	}

	public List<Matching> findAll() {
		return matchingRepository.findAll();
	}

	public List<Matching> findAllByDate(LocalDate date) {
		return matchingRepository.findAllByDate(date);
	}

	public List<Matching> searchMatchingByBuilder(MatchingSearchCondition condition) {
		return matchingRepository.searchMatchingByBuilder(condition);
	}

	public List<String> getMatchingPlaces(String date) {
		return matchingRepository.getMatchingPlaces(date);
	}
}


