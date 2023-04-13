package com.gogotennis.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import com.gogotennis.web.GameResult;

@Getter
@Setter
public class ResultAddForm {

	@NotNull
	private GameResult gameResult;

	// 매칭 아이디
	private Long id;
}
