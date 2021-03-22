package org.hse.robowar.repository;

import org.hse.robowar.model.League;
import org.hse.robowar.model.Robot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface LeagueRepository extends JpaRepository<League, UUID> {
    @Override
    Optional<League> findById(UUID uuid);
}
