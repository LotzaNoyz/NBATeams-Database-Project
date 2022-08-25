package com.project.NBATeams.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.NBATeams.dto.teamsDTO;
import com.project.NBATeams.model.teams;
import com.project.NBATeams.service.teamsDTOService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class TeamControllerDTO {
	
	@Autowired
	private teamsDTOService service;

    public TeamControllerDTO(teamsDTOService service) {
        super();
        this.service = service;
    }

    @PostMapping
    ("/createDTO")
  /*  public teamsDTO addTeam(@RequestBody teams teams1) {
        return this.service.addTeam(teams1);
    } */

    /*  @GetMapping
   ("/getAllDTO")
      public List<teams> getAllTeams() {
        return this.service.getAllTeams();
    } */

    @PutMapping
    ("/updateDTO")
    /*   public teamsDTO updatePerson(@PathParam("id") int id, @RequestBody teams teams1) {
        return this.service.updateTeam(id, teams1);
    } */

    @DeleteMapping
    ("/deleteDTO/{id}")
    /*  public boolean removePerson(@PathVariable int id) {
        return this.service.removeTeam(id);
    } */

    @GetMapping("/test")
     public String test(){
    //   return "Hello, World!";
    }
}
