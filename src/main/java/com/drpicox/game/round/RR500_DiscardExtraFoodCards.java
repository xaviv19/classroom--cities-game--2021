package com.drpicox.game.round;

import com.drpicox.game.cards.Card;
import com.drpicox.game.cards.CardController;
import com.drpicox.game.cards.CardListFilter;
import com.drpicox.game.games.Game;
import com.drpicox.game.players.PlayerController;
import org.springframework.stereotype.Component;

@Component
public class RR500_DiscardExtraFoodCards implements RoundRule {

    private final PlayerController playerController;
    private final CardController cardController;

    public RR500_DiscardExtraFoodCards(PlayerController playerController, CardController cardController) {
        this.playerController = playerController;
        this.cardController = cardController;
    }

    @Override
    public void run(Game game) {
        var foodCards = cardController.findByGame(game).atHand().ofType("food");
        var players = playerController.findByGame(game);
        for (var player: players)
            discardExtraCards(foodCards.ofOwner(player));
    }

    private void discardExtraCards(CardListFilter<Card> ownedFoods) {
        ownedFoods.stream()
                .skip(10)
                .forEach(cardController::discardCard);
    }
}
