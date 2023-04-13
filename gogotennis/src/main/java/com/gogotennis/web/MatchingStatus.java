package com.gogotennis.web;

import lombok.Getter;

@Getter
public enum MatchingStatus {

	BEFORE("경기전"),
	TWOHOURBEFORE("두시간전"),
	HOURBEFORE("한시간전"),
	ONGOING("신청마감"),
	AFTER("경기후"),
	WEEKAFTER("일주일후");

	private final String title;

	MatchingStatus(String title) {
		this.title = title;
	}
}
