package com.drpicox.game.components.growingsGold;

import com.drpicox.game.components.growingsGold.GrowingGold;
import com.drpicox.game.games.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface GrowingsGoldRepository extends JpaRepository<GrowingGold, String> {
    List<GrowingGold> findAllByGame(Game game);
}
