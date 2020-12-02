package com.drpicox.game.forms;

import com.drpicox.game.cards.CardListFilter;
import com.drpicox.game.games.Game;

import java.util.*;

public class VisibleGameForm {

    private String gameName;
    private String currentPlayerName;
    private int round;
    private Map<String, VisiblePlayerForm> players = new TreeMap<>();
    private List<VisibleCardForm> cards = new LinkedList<>();

    public VisibleGameForm(String currentPlayerName, Game game) {
        this.gameName = game.getName();
        this.round = game.getRound();
        this.currentPlayerName = currentPlayerName;
    }

    public String getGameName() {
        return gameName;
    }

    public String getCurrentPlayerName() {
        return currentPlayerName;
    }

    public int getRound() {
        return round;
    }

    public void addPlayer(VisiblePlayerForm visiblePlayerForm) {
        players.put(visiblePlayerForm.getName(), visiblePlayerForm);
    }

    public CardListFilter<VisibleCardForm> getCards() {
        return new CardListFilter<>(cards);
    }

    public void addCard(VisibleCardForm visibleCardForm) {
        cards.add(visibleCardForm);
    }

    public PlayGameForm createPlayForm(String playerName) {
        if (!playerName.equals(this.currentPlayerName)) return null;
        return createPlayForm();
    }

    public PlayGameForm createPlayForm() {
        var result = new PlayGameForm(currentPlayerName);
        var cards = getCards().ofOwner(currentPlayerName).atAnyPile();
        result.addCards(cards);

        return result;
    }

    public Collection<String> getPlayersName() {
        return players.keySet();
    }
}
