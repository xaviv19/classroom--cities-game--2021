package com.drpicox.game.testSteps.newPlayer;

import com.drpicox.game.common.api.GlobalRestException;
import com.drpicox.game.common.api.SuccessResponse;
import com.drpicox.game.testPost.SnapshotService;
import com.drpicox.game.testSteps.message.MessageTestView;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class NewPlayerTestView {
    private final SnapshotService snapshotService;
    private final MessageTestView messageTestView;

    public NewPlayerTestView(SnapshotService snapshotService, MessageTestView messageTestView) {
        this.snapshotService = snapshotService;
        this.messageTestView = messageTestView;
    }

    private String playerName;
    private String password;

    public void clear() {
        playerName = "";
        password = "";
    }

    public void addPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void submit() {
        var data = new HashMap<String, String>();
        data.put("playerName", playerName);
        data.put("password", password);

        messageTestView.callApi(() -> snapshotService.post("/api/v1/players", data, SuccessResponse.class));
    }
}
