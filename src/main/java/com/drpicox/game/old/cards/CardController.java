package com.drpicox.game.old.cards;

import com.drpicox.game.old.games.Game;
import com.drpicox.game.old.players.OldPlayer;
import com.drpicox.game.old.players.PlayerController;
import org.springframework.stereotype.Controller;

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

    public void pickCards(OldPlayer oldPlayer, int position, String type, int count) {
        for (var i = 0; i < count; i++)
            pickCard(oldPlayer, position, type);
    }

    public Card pickCard(OldPlayer oldPlayer, int square, String type) {
        var cards = findByGame(oldPlayer.getGame()).withoutOwner().ofType(type).toList();
        var card = randomCardPicker.pickOne(cards);
        card.onPick(oldPlayer, square);
        saveCard(card);
        return card;
    }

    public Card pickCard(OldPlayer oldPlayer, int square, String type, String name) {
        var card = findByGame(oldPlayer.getGame()).withoutOwner().ofType(type).ofName(name).getOne();
        card.onPick(oldPlayer, square);
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

    public void moveCardToSquare(Card card, OldPlayer oldPlayer, int square) {
        card.moveToSquare(oldPlayer, square);
        saveCard(card);
    }

    public void returnCardToHand(Card card) {
        moveCardToSquare(card, 0);
    }

    public void stealCard(OldPlayer newOwner, Card card) {
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
