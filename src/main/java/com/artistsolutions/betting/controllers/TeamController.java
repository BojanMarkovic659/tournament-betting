package com.artistsolutions.betting.controllers;

import com.artistsolutions.betting.dto.TeamDTO;
import com.artistsolutions.betting.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping()
    public List<TeamDTO> getTeams() {
        return teamService.getTeams();
    }

    @PostMapping("/add")
    public void addTeams(@RequestBody TeamDTO teamDTO) {
        teamService.addTeams(teamDTO);
    }

    @PutMapping("/{id}")
    public void updateTeam(@PathVariable int id, @RequestBody TeamDTO teamDTO) {
        teamService.updateTeam(id, teamDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable int id) {
        teamService.deleteTeam(id);
    }
}
