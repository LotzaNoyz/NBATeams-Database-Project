package com.project.NBATeams.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.NBATeams.model.teams;
import com.project.NBATeams.service.teamService;

@RestController
public class TeamController {
	
	//auto-wire the teamsService class  
			@Autowired  
			teamService teamService;  
			
			@GetMapping("/")
			public String greeting() { return "Welcome to the NBA DataBase. Please go to \"/allteams\" for all Players and Teams";}
			
			//creating a get mapping that retrieves all the team details from the database   
			@GetMapping("/allteams")  
			private List<teams> getAllTeams()   
			{  
			return teamService.getAllTeams();  
			}  
			
			//creating a get mapping that retrieves the detail of a specific team  
			@GetMapping("/teams/{playerNumber}")  
			private Optional<teams> getTeamByID(@PathVariable("playerNumber") int playerNumber)   
			{  
			return teamService.getTeamById(playerNumber);  
			}  
			
			//creating a delete mapping that deletes a specified player  
			@DeleteMapping("/deleteplayer/{playerNumber}")  
			private void deleteteam(@PathVariable("playerNumber") int playerNumber)   
			{  
			teamService.delete(playerNumber);  
			}  
			
			//creating post mapping that post the team detail in the database  
			@PostMapping("/saveorupdateTeam")  
			private ResponseEntity<teams> saveTeam(@RequestBody teams teams1)   
			{  
				return new ResponseEntity<>(this.teamService.saveOrUpdate(teams1), HttpStatus.CREATED);
			}  
			
			//creating put mapping that updates the team detail   
			@PutMapping("/saveTeams")  
			private teams update(@RequestBody teams teams1)   
			{  
			teamService.saveOrUpdate(teams1);  
			return teams1;  
			}  
			
			@GetMapping("/sortedbyname")  
			private List<teams> SortedByName()   
			{  
			return teamService.SortedByName();  
			}
			
			@GetMapping("/findby/{playerName}and{playerNumber}")
			private teams findteamby(@PathVariable("playerName") String playerName, @PathVariable("playerNumber") int playerNumber)
			{
				return teamService.findteamby(playerName, playerNumber);
			}
		}