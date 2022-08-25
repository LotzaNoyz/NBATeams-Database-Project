package com.project.NBATeams.dto;

import javax.persistence.Column;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
@Getter
@Setter
@NoArgsConstructor
*/

public class teamsDTO {
	
	private int playerNumber;
	  
	private String playerName;
	 
	private String team;  
	 
	private int height;  
}

