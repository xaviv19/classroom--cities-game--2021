package com.drpicox.game.typed;

import com.drpicox.game.games.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface TypedsRepository extends JpaRepository<Typed, String> {
    List<Typed> findAllByGame(Game game);
}
