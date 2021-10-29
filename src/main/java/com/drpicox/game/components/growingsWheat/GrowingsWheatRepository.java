package com.drpicox.game.components.growingsWheat;

import com.drpicox.game.games.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface GrowingsWheatRepository extends JpaRepository<GrowingWheat, String> {
    List<GrowingWheat> findAllByGame(Game game);
}

