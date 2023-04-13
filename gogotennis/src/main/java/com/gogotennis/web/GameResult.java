package com.gogotennis.web;

import lombok.Getter;

@Getter
public enum GameResult {

	WIN("승리"),
	LOSE("패배"),
	NORECORD("결과미등록"),
	PENALTY("무효");

	private final String title;

	GameResult(String title) {
		this.title = title;
	}
}
