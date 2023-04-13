package com.gogotennis.domain;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.gogotennis.dto.PlayerAddForm;
import com.gogotennis.web.ResultStatus;
import com.gogotennis.web.Team;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Player {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "player_id")
	private Long id;

	@NotNull
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "matching_id")
	private Matching matching;

	@NotNull
	@ManyToOne(fetch = LAZY)
	@JoinColumn(name = "member_id")
	private Member member;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Team team;

	@NotNull
	@Enumerated(EnumType.STRING)
	private ResultStatus resultStatus;

	public static Player createPlayerFromForm(PlayerAddForm form, Member member, Matching matching) {
		Player player = new Player();
		player.setMatching(matching);
		player.setMember(member);
		player.setTeam(Team.valueOf(form.getTeam()));
		player.setResultStatus(ResultStatus.RESULTNO);
		return player;
	}

	public static Player createPlayer(Matching matching, Member member) {
		Player player = new Player();
		player.setTeam(Team.A);
		player.setMember(member);
		player.setMatching(matching);
		player.setResultStatus(ResultStatus.RESULTNO);

		return player;
	}

	public static void updateResultStatus(Player player) {
		player.setResultStatus(ResultStatus.RESULTYES);
	}
}
