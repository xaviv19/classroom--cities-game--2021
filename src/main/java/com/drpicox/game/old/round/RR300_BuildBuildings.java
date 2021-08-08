package com.drpicox.game.old.round;

import com.drpicox.game.old.cards.Card;
import com.drpicox.game.old.cards.CardController;
import com.drpicox.game.old.cards.CardListFilter;
import com.drpicox.game.old.players.OldPlayer;
import com.drpicox.game.old.players.PlayerController;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RR300_BuildBuildings extends EachPlayerRoundRule {

    public RR300_BuildBuildings(PlayerController playerController, CardController cardController) {
        super(playerController, cardController);
    }

    @Override
    protected void runPlayer(OldPlayer oldPlayer, CardListFilter<Card> allCards) {
        var scenario = oldPlayer.getGame().getScenario();
        var buildCards = allCards.atPile("build").ofOwner(oldPlayer);
        if (buildCards.isEmpty()) return;

        var combination = buildCards.stream()
                .map(c -> c.toSimpleString()).sorted()
                .collect(Collectors.joining(","));

        var mayKey = scenario.findKey("build.", ($, value) -> value.equals(combination));

        var parts = mayKey.get().split("\\.");
        var type = parts[1];
        var name = parts[2];
        cardController.pickCard(oldPlayer, 0, type, name);
        buildCards.forEach(cardController::discardCard);
    }
}
