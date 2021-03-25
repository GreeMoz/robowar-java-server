package org.hse.robowar.repository;

import org.hse.robowar.model.League;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface LeagueRepository extends JpaRepository<League, UUID> {

    @Query(value = "select * from league where minmmr<= :mmr and maxmmr >= :mmr limit 1", nativeQuery = true)
    League findLeagueByMrr(@Param("mmr") int mmr);
}
