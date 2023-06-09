package com.gogotennis.repository;

import static com.gogotennis.domain.QMatching.*;
import static org.springframework.util.StringUtils.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import com.gogotennis.domain.Matching;
import com.gogotennis.dto.MatchingSearchCondition;
import com.gogotennis.web.CourtType;
import com.gogotennis.web.MatchingType;

@Repository
@RequiredArgsConstructor
public class MatchingRepositoryImpl implements MatchingRepositoryInterface {

	@PersistenceContext
	private final EntityManager em;

	private final JPAQueryFactory queryFactory;

	public List<Matching> findAll() {
		return em.createQuery("select m from Matching m", Matching.class).getResultList();
	}

	public Matching findOne(Long matchingId) {
		return em.find(Matching.class, matchingId);
	}

	@Override
	public void increasePlayerNumber(Long matchingId) {
		Matching matching = findOne(matchingId);
		matching.increasePlayerNumber(matching);
	}

	@Override
	public void matchingCondtionCheck(Long matchingId) {
		Matching matching = findOne(matchingId);
		matching.matchingConditionCheck(matching);
	}

	public void matchingOngoingCheck(Long matchingId) {
		Matching matching = findOne(matchingId);
		matching.matchingOngoingCheck(matching);
	}

	public void matchingAfterCheck(Long matchingId) {
		Matching matching = findOne(matchingId);
		matching.matchingAfterCheck(matching);
	}

	public void matchingBeforeHourCheck(Long matchingId) {
		Matching matching = findOne(matchingId);
		matching.matchingBeforeHourCheck(matching);
	}

	public void matchingBeforeTwoHourCheck(Long matchingId) {
		Matching matching = findOne(matchingId);
		matching.matchingBeforeTwoHourCheck(matching);
	}

	public void matchingAfterWeek(Long matchingId) {
		Matching matching = findOne(matchingId);
		matching.matchingAfterWeek(matching);
	}

	public List<Matching> searchMatchingByBuilder(MatchingSearchCondition condition) {
		BooleanBuilder builder = new BooleanBuilder();
		if (hasText(condition.getDate()) && !condition.getDate().equals("none")) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(condition.getDate(), dtf);
			builder.and(matching.matchingDate.eq(date));
		}
		if (hasText(condition.getMatchType()) && !condition.getMatchType().equals("none")) {
			MatchingType matchType = MatchingType.valueOf(condition.getMatchType());
			builder.and(matching.matchingType.eq(matchType));
		}
		if (hasText(condition.getCourtType()) && !condition.getCourtType().equals("none")) {
			CourtType courtType = CourtType.valueOf(condition.getCourtType());
			builder.and(matching.courtType.eq(courtType));
		}
		if (hasText(condition.getMatchingPlace()) && !condition.getMatchingPlace().equals("none")) {
			builder.and(matching.place.eq(condition.getMatchingPlace()));
		}

		return queryFactory
			.selectFrom(matching)
			.where(builder)
			.orderBy(matching.matchingStartTime.asc())
			.fetch();
	}

	public List<String> getMatchingPlaces(String date) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate condition = LocalDate.parse(date, dtf);

		return queryFactory
			.select(matching.place)
			.from(matching)
			.where(matching.matchingDate.eq(condition))
			.distinct()
			.fetch();
	}
}
