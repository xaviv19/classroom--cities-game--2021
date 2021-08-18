package com.drpicox.game.testViews;

import com.drpicox.game.common.api.GlobalRestException;
import com.drpicox.game.common.api.SuccessResponse;
import com.drpicox.game.testPost.SnapshotService;
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

        try {
            var response = snapshotService.post("/api/v1/players", data, SuccessResponse.class);
            messageTestView.reportMessage(response.getMessage());
        } catch (GlobalRestException g) {
            messageTestView.reportError(g);
        }
    }
}
