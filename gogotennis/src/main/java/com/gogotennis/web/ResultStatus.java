package com.gogotennis.web;

import lombok.Getter;

@Getter
public enum ResultStatus {

	RESULTYES("결과등록완료"),
	RESULTNO("결과미등록");

	private final String title;

	ResultStatus(String title) {
		this.title = title;
	}
}