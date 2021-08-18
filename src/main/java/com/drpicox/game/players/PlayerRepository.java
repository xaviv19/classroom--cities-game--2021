package com.drpicox.game.players;

import org.springframework.data.jpa.repository.JpaRepository;

interface PlayerRepository extends JpaRepository<Player, String> {
}
