package com.artistsolutions.betting.service;

import com.artistsolutions.betting.dto.TeamDTO;

import java.util.List;

public interface TeamService {
    List<TeamDTO> getTeams();

    void addTeams(TeamDTO teamDTO);

    void updateTeam(int id, TeamDTO teamDTO);

    void deleteTeam(int id);
}
