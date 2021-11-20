package com.drpicox.game.testSteps.blog;

import com.drpicox.game.blog.Post;
import com.drpicox.game.testPost.SnapshotService;
import com.drpicox.game.testSteps.screenStack.Screen;
import com.drpicox.game.testSteps.screenStack.ScreenStackTestView;
import org.springframework.stereotype.Component;

@Component
public class PostTestView implements Screen {

    private final ScreenStackTestView screenStackTestView;
    private final SnapshotService snapshotService;

    public PostTestView(ScreenStackTestView screenStackTestView, SnapshotService snapshotService) {
        this.screenStackTestView = screenStackTestView;
        this.snapshotService = snapshotService;
    }

    private Post post;

    /////////// --- NavigableScreen

    @Override
    public String getScreenName() {
        return "post";
    }

    @Override
    public void show() {}

    /////////// --- RestMethods

    public void fetchPost(String postId) {
        this.post = snapshotService.get("/api/v1/posts/" + postId, null, Post.class);
        screenStackTestView.pushScreenName("post");
    }

    public Post getPost() {
        return post;
    }
}
