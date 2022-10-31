package com.tedaneblake.footballapi.Service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedaneblake.footballapi.Constants.ResponseStatus;
import com.tedaneblake.footballapi.Model.Response;
import com.tedaneblake.footballapi.Model.Team;
import com.tedaneblake.footballapi.Repository.TeamRepository;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;
    

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Response getTeamById(int id, String path) {
        Response response = new Response();
        Team team = teamRepository.findById(id).orElse(null);
        if (team != null) {
            response.setStatus(ResponseStatus.SUCCESS.getStatus());
            response.setMessage("Team found");
            response.setData(List.of(team));
            response.setTimestamp(Instant.now());
            response.setPath(path);
        } else {
            response.setStatus(ResponseStatus.ERROR.getStatus());
            response.setMessage("Team not found");
            response.setTimestamp(Instant.now());
            response.setPath(path);
        }

        return response;
    }

    public Response addTeam(Team team, String path) {
        Response response = new Response();
        try {
            Integer isSucess = teamRepository.sp_add_team(team.getLongName(), team.getShortName(), team.getLogo(),
                    team.getLeagueId());

            if (isSucess == 1) {
                response.setMessage("Team added successfully");
                response.setStatus(ResponseStatus.SUCCESS.getStatus());
                response.setTimestamp(Instant.now());
                response.setPath(path);

            } else {
                response.setMessage("Team not added, there might already be a team name: " + team.getLongName());
                response.setStatus(ResponseStatus.ERROR.getStatus());
                response.setTimestamp(Instant.now());
                response.setPath(path);
            }

        } catch (Exception e) {
            response.setMessage("Error adding team");
            response.setMessage("Oops, something went wrong. Please try again later.");
            response.setStatus(ResponseStatus.ERROR.getStatus());
        }

        return response;

    }

    public void deleteTeam(int id) {
        teamRepository.deleteById(id);
    }

    public Team updateTeam(Team team) {
        Team existingTeam = teamRepository.findById(team.getId()).orElse(null);
        existingTeam.setShortName(team.getShortName());
        existingTeam.setLongName(team.getLongName());
        existingTeam.setLogo(team.getLogo());
        existingTeam.setLeagueId(team.getLeagueId());
        return teamRepository.save(existingTeam);
    }
}
