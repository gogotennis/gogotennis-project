package com.gogotennis.domain;

import static javax.persistence.FetchType.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.gogotennis.dto.ResultAddForm;
import com.gogotennis.web.GameResult;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ResultTemp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "result_temp_id")
	private Long id;

	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "player_id")
	private Player player;

	@Enumerated(EnumType.STRING)
	private GameResult gameResult;

	public static ResultTemp createResultTemp(ResultAddForm resultAddForm, Player player) {
		ResultTemp resultTemp = new ResultTemp();
		resultTemp.setGameResult(resultAddForm.getGameResult());
		resultTemp.setPlayer(player);

		return resultTemp;
	}
}
