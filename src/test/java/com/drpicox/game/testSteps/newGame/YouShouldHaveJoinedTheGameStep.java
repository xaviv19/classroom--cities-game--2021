package com.drpicox.game.testSteps.newGame;

import com.drpicox.game.games.api.GamesApi;
import com.drpicox.game.games.api.NewGameForm;
import com.drpicox.game.players.api.LoginForm;
import com.drpicox.game.players.api.PlayersApi;
import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.games.GamesTestView;
import com.drpicox.game.testSteps.player.PlayerTestView;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

import static com.google.common.truth.Truth8.assertThat;

@Component
public class YouShouldHaveJoinedTheGameStep extends AbstractPostLineStep {

    private final PlayerTestView playerTestView;
    private final GamesTestView gamesTestView;

    public YouShouldHaveJoinedTheGameStep(PlayerTestView playerTestView, GamesTestView gamesTestView) {
        this.playerTestView = playerTestView;
        this.gamesTestView = gamesTestView;
    }

    @Override
    protected String getRegex() {
        return "You should have (not )?joined the game \"([^\"]+)\" and creator \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var joinedName = playerTestView.getPlayerName();
        var gameName = match[2];
        var creatorName = match[3];
        var not = match[1];

        var gameFound = gamesTestView.getGames().stream()
                .filter(g -> g.getGameName().equals(gameName))
                .filter(g -> g.getCreatorName().equals(creatorName))
                .findFirst();

        assertThat(gameFound).isPresent();
        var game = gameFound.get();

        Stream<String> joinedPlayerNames = game.getJoinedPlayerNames().stream();
        if (not == null) assertThat(joinedPlayerNames).contains(joinedName);
        else  assertThat(joinedPlayerNames).doesNotContain(joinedName);
    }
}
