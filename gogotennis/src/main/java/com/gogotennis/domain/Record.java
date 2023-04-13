package com.gogotennis.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Record implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "record_id")
	private Long id;

	private Integer win;

	private Integer lose;

	private Integer penalty;

	private Double rate;

	private Integer points;

	public static Record createRecord() {
		Record record = new Record();
		record.setWin(0);
		record.setLose(0);
		record.setPenalty(0);
		record.setRate(0.0);
		record.setPoints(100);
		return record;
	}
}


