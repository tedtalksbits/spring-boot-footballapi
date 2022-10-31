package com.tedaneblake.footballapi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tedaneblake.footballapi.Model.Response;
import com.tedaneblake.footballapi.Model.Team;
import com.tedaneblake.footballapi.Service.TeamService;

@RestController
@RequestMapping("/api/v1/team")

public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<Team> getTeams() {
        return teamService.getAllTeams();
    }

    // a POST request to /api/v1/team that should have a request body of a Team
    // object
    @PostMapping("/add")
    public Response addTeam(@RequestBody Team team) {
        return teamService.addTeam(team, "/api/v1/team/add");
    }

    // a GET request to /api/v1/team/find?id={id} that should return a Team
    // object
    @GetMapping("/find")
    public Response getTeamById(@RequestParam int id) {
        return teamService.getTeamById(id, "/api/v1/team/find");
    }
    

}
