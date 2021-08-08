package com.drpicox.game.old.players;

import com.drpicox.game.old.games.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<OldPlayer, String> {
    // see https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
    List<OldPlayer> findByGame(Game game);
    List<OldPlayer> findByGameAndName(Game game, String name);
}
