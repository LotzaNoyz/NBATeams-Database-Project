package com.project.NBATeams.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.project.NBATeams.model.teams;

public interface teamsrepo extends CrudRepository<teams, Integer>{
	
	@Transactional
	@Modifying
	@Query
	(value = "SELECT b FROM teams b ORDER BY playerName")
	   public List<teams> findAllSortedByName();
	   
	   @Query
	   ("SELECT c from teams c WHERE c.playerName = ?1 and c.playerNumber = ?2")
	   teams findTeamsByNameAndNumberJPQL(String playerName, int playerNumber);
}
