package com.drpicox.game.components.informeds;

import com.drpicox.game.games.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface InformedsRepository extends JpaRepository<Informed, String> {
    List<Informed> findAllByGame(Game game);
}
