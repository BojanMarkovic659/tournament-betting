package com.artistsolutions.betting.service;

import com.artistsolutions.betting.dto.TeamDTO;
import com.artistsolutions.betting.entity.Team;
import com.artistsolutions.betting.repository.TeamRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<TeamDTO> getTeams() {
        List<Team> teams = teamRepository.findAll();
        List<TeamDTO> teamDTOS = modelMapper.map(teams, new TypeToken<List<TeamDTO>>() {
        }.getType());
        return teamDTOS;
        //return teams.stream().map(team -> modelMapper.map(team,TeamDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void addTeams(@RequestBody TeamDTO teamDTO) {
        Team team = modelMapper.map(teamDTO, Team.class);
        teamRepository.save(team);
        System.out.println("Team successfully added: " + team.getName() + ", id: " + team.getId());
    }

    @Override
    public void updateTeam(@PathVariable int id, @RequestBody TeamDTO teamDTO) {
        Team existingTeam = teamRepository.findById(id).get();
        modelMapper.map(teamDTO, existingTeam);
        Team updatedTeam = teamRepository.save(existingTeam);

        System.out.println("Team successfully update, id: " + id + ", name: " + teamDTO.getName());
    }

    @Override
    public void deleteTeam(@PathVariable int id) {
        teamRepository.deleteById(id);
        System.out.println("Team is successfully deleted, id: " + id);
    }
}
