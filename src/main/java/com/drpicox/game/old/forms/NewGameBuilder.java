package com.drpicox.game.old.forms;

import com.drpicox.game.old.cards.CardController;
import com.drpicox.game.old.games.Game;
import com.drpicox.game.old.games.GameController;
import com.drpicox.game.old.players.OldPlayer;
import com.drpicox.game.old.players.PlayerController;
import com.drpicox.game.old.scenarios.Scenario;
import com.drpicox.game.old.scenarios.ScenarioController;
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

    public void create(NewGameForm newGameForm) {
        var gameName = newGameForm.getGameName();
        String scenarioName = newGameForm.getScenario();
        var scenario = scenarioController.find(scenarioName).get();

        var game = createGame(gameName, scenario);
        var players = createGamePlayers(game, newGameForm);
        createGameCards(game, scenario);
        pickCardsForEachPlayer(scenario, players);
    }

    private Game createGame(String gameName, Scenario scenario) {
        return gameController.create(gameName, scenario);
    }

    private List<OldPlayer> createGamePlayers(Game game, NewGameForm newGameForm) {
        return newGameForm.getPlayers().stream()
                .map(p -> playerController.create(game, p.getName()))
                .collect(Collectors.toList());
    }

    private void createGameCards(Game game, Scenario scenario) {
        scenario.forEach("cards.", (key, countAsString) -> {
            var parts = key.split("\\.");
            var cardType = parts[1];
            var cardName = parts[2];
            var count = Integer.parseInt(countAsString);

            cardController.createCards(game, cardType, cardName, count);
        });
    }

    private void pickCardsForEachPlayer(Scenario scenario, List<OldPlayer> oldPlayers) {
        oldPlayers.forEach(p -> pickPlayerCards(p, scenario));
    }

    public void pickPlayerCards(OldPlayer oldPlayer, Scenario scenario) {
        scenario.forEachInteger("picks.", (key, count) -> {
            var parts = key.split("\\.");
            var position = Integer.parseInt(parts[1]);
            var type = parts[2];

            cardController.pickCards(oldPlayer, position, type, count);
        });
    }

}
