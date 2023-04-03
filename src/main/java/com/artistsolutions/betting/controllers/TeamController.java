package com.artistsolutions.betting.controllers;
import com.artistsolutions.betting.dto.TeamDTO;
import com.artistsolutions.betting.entity.Team;
import com.artistsolutions.betting.repository.TeamRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired private TeamRepository teamRepository;
    @Autowired private ModelMapper modelMapper;

    @GetMapping()
    public List<TeamDTO> getTeams() {
        List<Team> teams = teamRepository.findAll();
        return teams.stream().map(team -> modelMapper.map(team,TeamDTO.class)).collect(Collectors.toList());
    }

    @PostMapping("/add")
    public void addTeams(@RequestBody TeamDTO teamDto) {
        Team team = modelMapper.map(teamDto, Team.class);
        teamRepository.save(team);
        System.out.println("Team successfully added: " + team.getName() + ", id: " + team.getId());
    }

    @PutMapping("/{id}")
    public void updateTeam(@PathVariable int id, @RequestBody TeamDTO teamDTO) {
        Team existingTeam = teamRepository.findById(id).get();
        modelMapper.map(teamDTO,existingTeam);
        Team updatedTeam = teamRepository.save(existingTeam);

        System.out.println("Team successfully update, id: " + id + ", name: " + teamDTO.getName());
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable int id) {
        teamRepository.deleteById(id);
        System.out.println("Team is successfully deleted, id: " + id);
    }
}
