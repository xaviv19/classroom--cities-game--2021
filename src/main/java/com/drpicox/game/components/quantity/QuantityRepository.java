package com.drpicox.game.components.quantity;

import com.drpicox.game.components.typeds.Typed;
import com.drpicox.game.games.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface QuantityRepository extends JpaRepository<Quantity, String> {
    List<Quantity> findAllByGameAndQuantity(Game game, int quantity);
}
