package com.gogotennis.web;

import lombok.Getter;

@Getter
public enum MatchingType {

	SINGLE("단식", "2"),
	DOUBLE("복식", "4");

	private final String title;
	private final String code;

	MatchingType(String title, String code) {
		this.title = title;
		this.code = code;
	}
}
