package com.drpicox.game.forms;

import com.drpicox.game.cards.CardController;
import com.drpicox.game.games.Game;
import com.drpicox.game.games.GameController;
import com.drpicox.game.players.Player;
import com.drpicox.game.players.PlayerController;
import com.drpicox.game.scenarios.Scenario;
import com.drpicox.game.scenarios.ScenarioController;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class NewGameBuilder {

    private final CardController cardController;
    private final PlayerController playerController;
    private final GameController gameController;
    private final ScenarioController scenarioController;

    public NewGameBuilder(CardController cardController, PlayerController playerController, GameController gameController, ScenarioController scenarioController) {
        this.cardController = cardController;
        this.playerController = playerController;
        this.gameController = gameController;
        this.scenarioController = scenarioController;
    }

    public void replace(NewGameForm newGameForm) {
        var gameName = newGameForm.getGameName();
        var scenario = scenarioController.find(newGameForm.getScenario()).get();

        var game = replaceGame(gameName);
        var players = replaceGamePlayers(game, newGameForm);
        replaceGameCards(game, scenario);
        pickGamePlayersCards(scenario, players);
    }

    private Game replaceGame(String gameName) {
        return gameController.replace(gameName);
    }

    private List<Player> replaceGamePlayers(Game game, NewGameForm newGameForm) {
        return newGameForm.getPlayers().stream()
                .map(p -> playerController.create(game, p.getName()))
                .collect(Collectors.toList());
    }

    private void replaceGameCards(Game game, Scenario scenario) {
        scenario.forEach("cards.", (key, countAsString) -> {
            var parts = key.split("\\.");
            var type = parts[1];
            var name = parts[2];
            var count = Integer.parseInt(countAsString);

            cardController.createCards(game, type, name, count);
        });
    }

    private void pickGamePlayersCards(Scenario scenario, List<Player> players) {
        players.forEach(p -> pickPlayerCards(p, scenario));
    }

    public void pickPlayerCards(Player player, Scenario scenario) {
        scenario.forEach("picks.", (key, scount) -> {
            var parts = key.split("\\.");
            var position = Integer.parseInt(parts[1]);
            var type = parts[2];
            var count = Integer.parseInt(scount);

            cardController.pickCards(player, position, type, count);
        });
    }

}
