package com.drpicox.game.components.typeds;

import com.drpicox.game.games.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface TypedsRepository extends JpaRepository<Typed, String> {
    List<Typed> findAllByType(String type);
}
