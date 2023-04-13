package com.gogotennis.repository;

import static com.gogotennis.domain.QMember.*;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;
import com.gogotennis.domain.Member;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl {

	@PersistenceContext
	private final EntityManager em;

	private final JPAQueryFactory queryFactory;

	public List<Member> findAll() {         //Member entity 전체를 리스트로 반환
		return em.createQuery("select m from Member m", Member.class).getResultList();
	}

	public Optional<Member> findByLoginId(String loginId) {
		return findAll().stream().filter(m -> m.getLoginId().equals(loginId)).findFirst();
	}

	public Optional<Member> findByNickname(String nickname) {
		return findAll().stream().filter(m -> m.getNickname().equals(nickname)).findFirst();
	}

	public Optional<Member> findByEmail(String email) {
		return findAll().stream().filter(m -> m.getEmail().equals(email)).findFirst();
	}

	public Optional<Member> findByPhoneNum(String phoneNum) {
		return findAll().stream().filter(m -> m.getPhoneNumber().equals(phoneNum)).findFirst();
	}

	public List<Member> findRankTopThree() {
		return queryFactory
			.select(member)
			.from(member)
			.orderBy(member.record.points.desc())
			.limit(3)
			.fetch();
	}

	public List<Member> findRankList() {
		return queryFactory
			.select(member)
			.from(member)
			.orderBy(member.record.points.desc())
			.fetch();
	}
}
