package com.drpicox.game.cards;

import com.drpicox.game.games.Game;
import com.drpicox.game.players.Player;
import com.drpicox.game.players.PlayerController;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class CardController {
    private final CardRepository cardRepository;
    private final RandomCardPicker randomCardPicker;
    private final PlayerController playerController;

    public CardController(CardRepository cardRepository, RandomCardPicker randomCardPicker, PlayerController playerController) {
        this.cardRepository = cardRepository;
        this.randomCardPicker = randomCardPicker;
        this.playerController = playerController;
    }

    public CardListFilter<Card> findByGame(Game game) {
        return new CardListFilter<>(cardRepository.findByGame(game));
    }

    public void createCards(Game game, String type, String name, int count) {
        for (var i = 0; i < count; i++)
            createCard(game, type, name);
    }

    private void createCard(Game game, String type, String name) {
        var card = new Card(game, type, name);
        saveCard(card);
    }

    public void pickCards(Player player, int position, String type, int count) {
        for (var i = 0; i < count; i++)
            pickCard(player, position, type);
    }

    public Card pickCard(Player player, int square, String type) {
        var cards = findByGame(player.getGame()).withoutOwner().ofType(type).toList();
        var card = randomCardPicker.pickOne(cards);
        card.onPick(player, square);
        saveCard(card);
        return card;
    }

    public Card pickCard(Player player, int square, String type, String name) {
        var card = findByGame(player.getGame()).withoutOwner().ofType(type).ofName(name).getOne();
        card.onPick(player, square);
        saveCard(card);
        return card;
    }

    public void discardCard(Card card) {
        card.discard();
        saveCard(card);
    }

    public void pileCard(Card card, String pile) {
        card.pile(pile);
        saveCard(card);
    }

    public void moveCardToSquare(Card card, int square) {
        card.moveToSquare(square);
        saveCard(card);
    }

    public void moveCardToSquare(Card card, Player player, int square) {
        card.moveToSquare(player, square);
        saveCard(card);
    }

    public void returnCardToHand(Card card) {
        moveCardToSquare(card, 0);
    }

    public void stealCard(Player newOwner, Card card) {
        card.stealCard(newOwner);
        saveCard(card);
    }

    private void saveCard(Card card) {
        var owner = card.getOwner();
        var ownerBeforeSave = card.getBeforeSaveOwner();
        card.resetBeforeSaveOwner();
        cardRepository.save(card);

        if (owner != ownerBeforeSave)
            playerController.receivedCard(owner, card.getSquare(), card.getType(), card.getName());
    }
}
