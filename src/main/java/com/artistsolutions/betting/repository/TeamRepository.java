package com.artistsolutions.betting.repository;

import com.artistsolutions.betting.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team,Integer> {

}
