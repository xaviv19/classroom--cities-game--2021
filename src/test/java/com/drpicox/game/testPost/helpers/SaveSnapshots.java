package com.drpicox.game.testPost.helpers;

import com.drpicox.game.testPost.SnapshotService;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileWriter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@Component
public class SaveSnapshots {

    private final SnapshotService snapshotService;

    public SaveSnapshots(SnapshotService snapshotService) {
        this.snapshotService = snapshotService;
    }

    public void save(String postId) {
        var snapshots = snapshotService.listJsonSnapshots();
        try {
            var uri = getSnapshotUri(postId);
            try (var fw = new FileWriter(new File(uri))) {
                fw.append(snapshots);
                fw.flush();
            }
        } catch (Exception reason) {
            throw new RuntimeException("Cannot write post snapshots for " + postId, reason);
        }
    }

    private URI getSnapshotUri(String postId) throws MalformedURLException, URISyntaxException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        var directoryUrl = loader.getResource("snapshots");
        var snapshotsUrl = new URL(directoryUrl, "snapshots/" + postId + ".json");
        return snapshotsUrl.toURI();
    }
}
