package com.drpicox.game.old.round;

import com.drpicox.game.old.cards.Card;
import com.drpicox.game.old.cards.CardController;
import com.drpicox.game.old.cards.CardListFilter;
import com.drpicox.game.old.players.Player;
import com.drpicox.game.old.players.PlayerController;
import org.springframework.stereotype.Component;

@Component
public class RR500_DiscardExtraHandCards extends EachPlayerRoundRule {

    public RR500_DiscardExtraHandCards(PlayerController playerController, CardController cardController) {
        super(playerController, cardController);
    }

    @Override
    protected void runPlayer(Player player, CardListFilter<Card> allCards) {
        var scenario = player.getGame().getScenario();
        scenario.forEachInteger("limit.hand.", (key, limit) -> {
            var type = key.split("\\.")[2];
            discardExtraCards(allCards.atHand().ofOwner(player).ofType(type), limit);
        });
    }

    private void discardExtraCards(CardListFilter<Card> ownedFoods, int limit) {
        ownedFoods.stream()
                .skip(limit)
                .forEach(cardController::discardCard);
    }
}
