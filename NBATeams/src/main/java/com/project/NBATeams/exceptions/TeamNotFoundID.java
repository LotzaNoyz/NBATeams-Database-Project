package com.project.NBATeams.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
(code = HttpStatus.NOT_FOUND, reason = "Team does not exist with that Name")
public class TeamNotFoundID extends EntityNotFoundException{

}
