package com.gogotennis.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gogotennis.domain.Record;

public interface RecordRepository extends JpaRepository<Record, Long> {
}
