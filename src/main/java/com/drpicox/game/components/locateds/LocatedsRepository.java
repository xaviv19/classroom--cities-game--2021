package com.drpicox.game.components.locateds;

import com.drpicox.game.games.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

interface LocatedsRepository extends JpaRepository<Located, String> {
    List<Located> findByLocation(int location);

    List<Located> findAllByLocationIn(Set<Integer> locations);
}
