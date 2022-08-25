package com.project.NBATeams.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.project.NBATeams.dto.teamsDTO;
import com.project.NBATeams.model.teams;
import com.project.NBATeams.repo.teamsrepo;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class teamsDTOService {
	
	private teamsrepo repo;
	private ModelMapper mapper;
	private teamsDTO mapToDTO(teams teams1) {
		
        teamsDTO dto = new teamsDTO();
//        dto.setHeight(teams1.getHeight());
//        dto.setPlayerNumber(teams1.getPlayerNumber());
        dto.setPlayerName(teams1.getPlayerName());
        
        return dto;
    }
	
	public teamsDTO addTeam(teams teams1) {
  //      teams saved =  this.repo.save(teams1) ;
  //      return this.mapToDTO(saved);
    }
	
	public List<teams> getAllTeams()   
	{  
//	List<teams> teams1 = new ArrayList<teams>();  
//	repo.findAll().forEach(teams2 -> teams1.add(teams2));  
//	return teams1;  
	} 
	
	public teamsDTO updateTeam(int id, teams team1) {
  //      Optional<teams> existingOptional = this.repo.findById(id);
  //      teams existing = existingOptional.get();

  //      existing.setHeight(team1.getHeight());
  //      existing.setPlayerName(team1.getPlayerName());

        teams updated =  this.repo.save(existing);
        return this.mapToDTO(updated);
    }

    public boolean removeTeam(int id) {
 //       this.repo.deleteById(id);
  //      boolean exists = this.repo.existsById(id);
  //      return !exists;
    }
}  
