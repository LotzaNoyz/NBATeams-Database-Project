package com.project.NBATeams.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Marked class as an Entity   
	@Entity  
//Defining class name as Table name  
	@Table  

	@AllArgsConstructor
	@NoArgsConstructor
	@Getter
	@Setter
public class teams {
	
		//Lombok getters and setters for all items in database
		
		@Id  
		@Column
		private int playerNumber;
		
		@Column  
		private String playerName;
		
		@Column  
		private String team;  
		
		@Column  
		private int height;  
	}
