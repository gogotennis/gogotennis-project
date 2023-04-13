package com.gogotennis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gogotennis.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryInterface {

}
