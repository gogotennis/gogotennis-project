package com.gogotennis.repository;

import java.util.List;

import com.gogotennis.domain.Matching;
import com.gogotennis.dto.MatchingSearchCondition;

public interface MatchingRepositoryInterface {

	List<Matching> findAll();

	Matching findOne(Long matchingId);

	void increasePlayerNumber(Long matchingId);

	void matchingCondtionCheck(Long matchingId);

	void matchingOngoingCheck(Long matchingId);

	void matchingAfterCheck(Long matchingId);

	void matchingBeforeHourCheck(Long matchingId);

	void matchingBeforeTwoHourCheck(Long matchingId);

	void matchingAfterWeek(Long matchingId);

	//매치 리스트 검색 : 동적 쿼리
	List<Matching> searchMatchingByBuilder(MatchingSearchCondition condition);

	public List<String> getMatchingPlaces(String date);
}
