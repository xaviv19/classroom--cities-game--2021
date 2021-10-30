package com.drpicox.game.testSteps.game;

import com.drpicox.game.components.owneds.OwnedsController;
import com.drpicox.game.components.quantity.QuantityController;
import com.drpicox.game.components.typeds.TypedsController;
import com.drpicox.game.ecs.EcsComponent;
import com.drpicox.game.games.GamesController;
import com.drpicox.game.players.PlayersController;
import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.google.common.truth.Truth;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShouldHaveHouseStep extends AbstractPostLineStep {


    private final GameTestView gameTestView;
    private final PlayersController playersController;
    private final GamesController gamesController;
    private final OwnedsController ownedsController;
    private final TypedsController typedsController;
    private final QuantityController quantityController;

    public ShouldHaveHouseStep(GameTestView gameTestView, PlayersController playersController, GamesController gamesController, OwnedsController ownedsController, TypedsController typedsController, QuantityController quantityController) {
        this.gameTestView = gameTestView;
        this.playersController = playersController;
        this.gamesController = gamesController;
        this.ownedsController = ownedsController;
        this.typedsController = typedsController;
        this.quantityController = quantityController;
    }

    @Override
    protected String getRegex() {
        return "\"([^\"]+)\" should have a quantity of (\\d+) house";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var ownerName = match[1];
        var count = Integer.parseInt(match[2]);

        var gameResponse = gameTestView.getGame();
        String gameName = gameResponse.getGameName();
        var creator = playersController.findPlayer(gameResponse.getCreatorName()).get();
        var game = gamesController.findGame(gameName, creator).get();

        var owner = playersController.findPlayer(ownerName).get();
        var owneds = getIds(ownedsController.findAllByGameAndOwner(game, owner));
        var types = getIds(typedsController.findAllByGameAndType(game, "HOUSE"));
        var quantity = getIds(quantityController.findAllByGameAndQuantity(game, count));

        var intersection = owneds.stream()
                .filter(types::contains)
                .filter(quantity::contains)
                .collect(Collectors.toSet());
        Truth.assertThat(intersection).hasSize(1);
    }

    private <T extends EcsComponent> List<String> getIds(List<T> components) {
        return components.stream().map(c -> c.getEntityId()).collect(Collectors.toList());
    }
}
