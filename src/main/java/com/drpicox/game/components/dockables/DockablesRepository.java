package com.drpicox.game.components.dockables;

import com.drpicox.game.games.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface DockablesRepository extends JpaRepository<Dockable, String> {
    List<Dockable> findAllByGame(Game game);
}
