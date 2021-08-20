package com.drpicox.game.testSteps.newGame;

import com.drpicox.game.common.api.GlobalRestException;
import com.drpicox.game.common.api.SuccessResponse;
import com.drpicox.game.testPost.SnapshotService;
import com.drpicox.game.testSteps.message.MessageTestView;
import com.drpicox.game.testSteps.player.PlayerTestView;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class NewGameTestView {
    private final MessageTestView messageTestView;
    private final PlayerTestView playerTestView;
    private final SnapshotService snapshotService;

    public NewGameTestView(MessageTestView messageTestView, PlayerTestView playerTestView, SnapshotService snapshotService) {
        this.messageTestView = messageTestView;
        this.playerTestView = playerTestView;
        this.snapshotService = snapshotService;
    }

    private String gameName;

    public void clear() {
        gameName = "";
    }

    public void addGameName(String gameName) {
        this.gameName = gameName;
    }

    public void submit() {
        var token = playerTestView.getToken();

        var data = new HashMap<String, String>();
        data.put("gameName", gameName);
        data.put("token", token);

        messageTestView.callApi(() -> snapshotService.post("/api/v1/games", data, SuccessResponse.class));
    }
}
