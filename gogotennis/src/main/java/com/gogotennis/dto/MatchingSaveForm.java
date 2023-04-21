package com.gogotennis.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import com.gogotennis.web.CourtType;
import com.gogotennis.web.MatchingType;

@Data
public class MatchingSaveForm {

	@NotNull
	private String title;

	@NotNull
	private String content;

	@NotNull
	@Size(min = 1, max = 40, message = "장소은 1 ~ 40자 이내여야 합니다.")
	private String place;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "매칭 날짜를 선택해주세요.")
	private LocalDate matchingDate;

	@NotNull(message = "매칭 시작 시간을 선택해주세요.")
	private String matchingStartTime;

	@NotNull(message = "매칭 종료 시간을 선택해주세요.")
	private String matchingEndTime;

	@NotNull(message = "매칭 종류를 선택해주세요.")
	private MatchingType matchingType;

	@NotNull(message = "코트 종류를 선택해주세요.")
	private CourtType courtType;

	private String beforeHour;
	private String beforeTwoHour;
	private String team;
	private String lat;
	private String lng;
}
