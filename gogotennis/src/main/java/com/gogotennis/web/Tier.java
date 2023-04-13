package com.gogotennis.web;

import lombok.Getter;

@Getter
public enum Tier {

	IRON("아이언"),
	BRONZE("브론즈"),
	SILVER("실버"),
	GOLD("골드"),
	PLATINUM("플래티넘"),
	DIAMOND("다이아몬드"),
	MASTER("마스터"),
	GRANDMASTER("그랜드마스터"),
	CHALLENGER("챌린저");

	private final String title;

	Tier(String title) {
		this.title = title;
	}
}
