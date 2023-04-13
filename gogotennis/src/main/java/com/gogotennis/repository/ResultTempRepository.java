package com.gogotennis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.gogotennis.domain.ResultTemp;

public interface ResultTempRepository extends JpaRepository<ResultTemp, Long> {

	@Query("select rt from ResultTemp rt where rt.player.matching.id = :matchingId")
	List<ResultTemp> findResultTempMatching(@Param("matchingId") Long matchingId);

}
