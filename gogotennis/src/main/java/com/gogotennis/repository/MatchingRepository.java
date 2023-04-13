package com.gogotennis.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gogotennis.domain.Matching;

public interface MatchingRepository extends JpaRepository<Matching, Long>, MatchingRepositoryInterface {

	@Query("select m from Matching m where m.matchingDate = :date")
	List<Matching> findAllByDate(@Param("date") LocalDate date);
}
