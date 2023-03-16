package com.artistsolutions.betting.controllers;

import com.artistsolutions.betting.dto.Team;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teams")
public class TeamController {

    @GetMapping()
    public void getTeams() {
        System.out.println("All teams returned");
    }

    @PostMapping("/add")
    public void addTeams(@RequestBody Team request) {
        System.out.println("Team successfully added: " + request.getName() + ", id: " + request.getId());
    }

    @PutMapping("/{id}")
    public void updateTeam(@PathVariable int id, @RequestBody Team request) {
        System.out.println("Team successfully update, id: " + id + ", name: " + request.getName());
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable int id) {
        System.out.println("Team is successfully deleted, id: " + id);
    }
}
