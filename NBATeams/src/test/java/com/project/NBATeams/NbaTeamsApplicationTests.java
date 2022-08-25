package com.project.NBATeams;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.NBATeams.dto.teamsDTO;
import com.project.NBATeams.model.teams;
import com.project.NBATeams.repo.teamsrepo;
import com.project.NBATeams.service.teamService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:teams-schema.sql",
"classpath:teams-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("developer")

// @ContextConfiguration(classes ={teamService.class})

class NbaTeamsApplicationTests {

	@Autowired
    private teamService service;
    @MockBean
    private teamsrepo repo;
    
    @Autowired
    private MockMvc mock;
    
    private final teams TEST_TEAM = new teams(1111,"TestPlayer", "TestTeam",1000);
    
    @Autowired
    private ModelMapper mapper;
    
    @Autowired
	private ObjectMapper obmapper;
    
    private teamsDTO mapToDTO(teams teams1) {
        return this.mapper.map(teams1, teamsDTO.class);
    }
    
    @Test
    void testCreate(){
    	
        // GIVEN is our testing data - you can make this a final local variable if you want, e.g.:
        final teams TEST_TEAM = new teams(0, "TestPlayer", "TestTeam",1000);
        final teams TEST_SAVED_TEAM = new teams(1111,"TestPlayer", "TestTeam",1000);
        
        // WHEN
        Mockito.when(this.repo.save(TEST_TEAM)).thenReturn(TEST_SAVED_TEAM);
        
        // THEN
        Assertions.assertThat(this.service.saveOrUpdate(TEST_TEAM)).isEqualTo(TEST_SAVED_TEAM);
        
        // verify that our repo was accessed exactly once
        Mockito.verify(this.repo, Mockito.times(1)).save(TEST_TEAM);
        
        System.out.println("Test Completed Successfully");
    }
        
  //Unit Test 2
    @Test
    void testGetByNumber() {
    	
    	// Setup the mock repo

        int teamId = 1001;
        final teams TEST_TEAM = new teams(teamId, "TestPlayer", "TestTeam",1000);
        //final Optional<teams> TEST_SAVED_TEAM = Optional.empty();

        // Make the service call
    	Mockito.when(this.repo.findById(teamId)).thenReturn(Optional.of(TEST_TEAM)); 
		
       System.out.println("Test for Get Player By Number Successful");
       
    }   
        
    //Unit Test 3
    @Test
    public void testDeletePlayerByNumber() {
    	
    	
    	int teamId = 1001;
        final teams TEST_TEAM = new teams(0, "TestPlayer", "TestTeam",1000);
        final teams TEST_SAVED_TEAM = new teams(teamId,"TestPlayer", "TestTeam",1000);
        
    	service.delete(TEST_SAVED_TEAM.getPlayerNumber());

        Mockito.verify(repo, Mockito.times(1))
                .deleteById(TEST_SAVED_TEAM.getPlayerNumber());
        
        System.out.println("Test for Delete Player By Number Successful");
        
    }
    
    //Unit Test 4
    @Test
    public void testFindAll() {

    	final teams TEST_SAVED_TEAM = new teams(1001,"TestPlayer", "TestTeam",1000);
        List<teams> foundteams = service.getAllTeams();
        foundteams.add(TEST_SAVED_TEAM);

        assertNotNull(foundteams);
        assertEquals(1, foundteams.size());
        
        System.out.println("Test To Find All Teams Successful");
    }

    
    //---------- Integration Test----------//
        
    
  //Integration Test 1
    @Test
	public void IntTestCreate() throws Exception {
		final teams newTeam = new teams(13, "Miami Heat", "Bam Adebayo",69);
		
		this.mock
				.perform(post("/saveorupdateTeam").contentType(MediaType.APPLICATION_JSON)
						.content(this.obmapper.writeValueAsString(newTeam)))
				.andExpect(status().isCreated());
	}
    
    
    //Integration Test 2
    @Test
	public void IntTestReadAll() throws Exception {
		final String resultString = this.mock
				.perform(request(HttpMethod.GET, "/allteams").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

		List<teams> results = Arrays.asList(obmapper.readValue(resultString, teams[].class));
		assertEquals(new ArrayList<>(Arrays.asList()), results);
		System.out.println(results.size());
	}
    
}
