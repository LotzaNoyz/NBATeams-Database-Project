package com.project.NBATeams.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.NBATeams.exceptions.TeamNotFoundID;
import com.project.NBATeams.model.teams;
import com.project.NBATeams.repo.teamsrepo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class teamService {

	//wiring the repo 
			@Autowired  
			teamsrepo teamsRepository;  
			
			private ModelMapper mapper;
			
			//getting all team records by using the method findAll() of CrudRepository  
			public List<teams> getAllTeams()   
			{  
			List<teams> teams1 = new ArrayList<teams>();  
			teamsRepository.findAll().forEach(teams2 -> teams1.add(teams2));
			return teams1;  
			}  
			
			//getting a specific record by using the method findById() of CrudRepository  
			public Optional<teams> getTeamById(int playerNumber)   
			{  
				//teams found = this.teamRepository.findById(id).orElseThrow(BookNotFoundID::new);
				return teamsRepository.findById(playerNumber);
			}  

			//saving a specific record by using the method save() of CrudRepository  
			public teams saveOrUpdate(teams teams1)   
			{  
			return teamsRepository.save(teams1);  
			}  
			
			//deleting a specific record by using the method deleteById() of CrudRepository  
			public void delete(int playerNumber)   
			{  
			teamsRepository.deleteById(playerNumber);
			} 
			
			//updating a record  
			public void update(teams teams1, int playerNumber)   
			{  
			teamsRepository.save(teams1);
			}  
			
			//CustomQuery Sorted Grouping
			public List<teams> SortedByName()   
			{  
			//List<teams> teams1 = new ArrayList<teams>(); 
			return teamsRepository.findAllSortedByName();	
			}
			
			//CustomQuery find player by name or number
			public teams findteamby(String playerName,int playerNumber)
			{
				teams found = this.teamsRepository.findById(playerNumber).orElseThrow(TeamNotFoundID::new);
				return teamsRepository.findTeamsByNameAndNumberJPQL(playerName, found.getPlayerNumber());
			}

		}  
