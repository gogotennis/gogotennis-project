package com.gogotennis.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerAddForm {

	@NotNull
	private String memberId;

	@NotNull
	private String team;

	@NotNull
	private String matchingId;

}
