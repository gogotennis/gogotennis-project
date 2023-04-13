package com.gogotennis.web;

import lombok.Getter;

@Getter
public enum CourtType {

	INDOOR("실내"),
	OUTDOOR("실외");

	private final String title;

	CourtType(String title) {
		this.title = title;
	}
}
