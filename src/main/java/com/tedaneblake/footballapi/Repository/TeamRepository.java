package com.tedaneblake.footballapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tedaneblake.footballapi.Model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {

    @Query(value = "call sp_add_team(?1, ?2, ?3, ?4)", nativeQuery = true)
    Integer sp_add_team(String longName, String shortName, String logo, int leagueId);
    
    
}
