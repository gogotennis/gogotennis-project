package com.gogotennis.web;

import lombok.Getter;

@Getter
public enum MatchingCondition {

	AVAILABLE("신청가능"),
	DONE("신청마감"),
	FAIL("매칭실패");

	private final String title;

	MatchingCondition(String title) {
		this.title = title;
	}
}
