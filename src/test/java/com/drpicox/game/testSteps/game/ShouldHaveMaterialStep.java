package com.drpicox.game.testSteps.game;

import com.drpicox.game.components.nameds.NamedsController;
import com.drpicox.game.components.owneds.OwnedsController;
import com.drpicox.game.components.quantity.QuantityController;
import com.drpicox.game.components.sails.SailsController;
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

import static com.drpicox.game.testSteps.game.TypedTestView.byType;
import static com.drpicox.game.testSteps.nameds.NamedTestView.toName;
import static com.drpicox.game.testSteps.owneds.OwnedTestView.byOwner;
import static com.google.common.truth.Truth8.assertThat;

@Component
public class ShouldHaveMaterialStep extends AbstractPostLineStep {


    private final GameTestView gameTestView;
    private final PlayersController playersController;
    private final GamesController gamesController;
    private final OwnedsController ownedsController;
    private final TypedsController typedsController;
    private final NamedsController namedsController;
    private final SailsController sailsController;
    private final QuantityController quantityController;

    public ShouldHaveMaterialStep(GameTestView gameTestView, PlayersController playersController, GamesController gamesController, OwnedsController ownedsController, TypedsController typedsController, NamedsController namedsController, SailsController sailsController, QuantityController quantityController) {
        this.gameTestView = gameTestView;
        this.playersController = playersController;
        this.gamesController = gamesController;
        this.ownedsController = ownedsController;
        this.typedsController = typedsController;
        this.namedsController = namedsController;
        this.sailsController = sailsController;
        this.quantityController = quantityController;
    }

    @Override
    protected String getRegex() {
        return "\"([^\"]+)\" should have a quantity of (\\d+) ([a-z]+) \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var ownerName = match[1];
        var count = Integer.parseInt(match[2]);
        var type = match[3];
        var name = match[4];

        var gameResponse = gameTestView.getGame();
        String gameName = gameResponse.getGameName();
        var creator = playersController.findPlayer(gameResponse.getCreatorName()).get();
        var game = gamesController.findGame(gameName, creator).get();

        var owner = playersController.findPlayer(ownerName).get();
        var owneds = getIds(ownedsController.findAllByGameAndOwner(game, owner));
        var types = getIds(typedsController.findAllByGameAndType(game, type));
        var nameds = getIds(namedsController.findAllByGameAndName(game, name));
        var quantity = getIds(quantityController.findAllByGameAndQuantity(game, count));

        var intersection = owneds.stream()
                .filter(types::contains)
                .filter(nameds::contains)
                .filter(quantity::contains)
                .collect(Collectors.toSet());
        Truth.assertThat(intersection).hasSize(1);
    }

    private <T extends EcsComponent> List<String> getIds(List<T> components) {
        return components.stream().map(c -> c.getEntityId()).collect(Collectors.toList());
    }
}
