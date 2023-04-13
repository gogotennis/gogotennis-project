package com.gogotennis.web;

import lombok.Getter;

@Getter
public enum Status {

	RECRUITING("모집 중"),
	END("모집 마감");

	private final String title;

	Status(String title) {
		this.title = title;
	}
}