package com.drpicox.game.testSteps.blog;

import com.drpicox.game.blog.Post;
import com.drpicox.game.blog.api.ListPostsResponse;
import com.drpicox.game.blog.api.ListPostsResponseEntry;
import com.drpicox.game.testPost.SnapshotService;
import com.drpicox.game.testSteps.screenStack.Screen;
import com.drpicox.game.testSteps.screenStack.ScreenStackTestView;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlogTestView implements Screen {

    private final ScreenStackTestView screenStackTestView;
    private final SnapshotService snapshotService;

    public BlogTestView(ScreenStackTestView screenStackTestView, SnapshotService snapshotService) {
        this.screenStackTestView = screenStackTestView;
        this.snapshotService = snapshotService;
    }

    private ListPostsResponse listPostsResponse;
    private Post post;

    /////////// --- NavigableScreen

    @Override
    public String getScreenName() {
        return "blog";
    }

    @Override
    public void show() {}

    /////////// --- RestMethods

    public void fetchPosts() {
        listPostsResponse = snapshotService.get("/api/v1/posts", null, ListPostsResponse.class);
        screenStackTestView.pushScreenName("blog");
    }

    public List<ListPostsResponseEntry> getListPostsResponse() {
        return listPostsResponse.getPosts();
    }

    public void fetchPost(String postId) {
        this.post = snapshotService.get("/api/v1/posts/" + postId, null, Post.class);
        screenStackTestView.pushScreenName("post");
    }
}
