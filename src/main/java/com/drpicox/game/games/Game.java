package com.drpicox.game.games;

import com.drpicox.game.players.Player;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Game {
    @Id
    private String id;

    private String gameName;

    @ManyToOne
    private Player creator;

    @ManyToMany
    private List<Player> joinedPlayers = new ArrayList<>();

    public Game(String id, String gameName, Player creator) {
        this.id = id;
        this.gameName = gameName;
        this.creator = creator;
    }

    protected Game() {}

    public Player getCreator() {
        return creator;
    }

    public String getGameName() {
        return gameName;
    }

    public void joinPlayer(Player joiningPlayer) {
        joinedPlayers.add(joiningPlayer);
    }

    public boolean isPlayerJoined(Player player) {
        return joinedPlayers.contains(player);
    }

    public List<Player> getJoinedPlayers() {
        return this.joinedPlayers;
    }
}
