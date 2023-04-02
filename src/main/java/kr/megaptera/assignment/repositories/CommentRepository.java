package kr.megaptera.assignment.repositories;

import kr.megaptera.assignment.domains.Comment;
import kr.megaptera.assignment.domains.CommentId;
import kr.megaptera.assignment.domains.PostId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentRepository {
    Map<CommentId, Comment> comments;

    public CommentRepository() {
        this.comments = new HashMap<>();
    }

    public List<Comment> findAll(PostId postId) {
        List<Comment> commentList = comments.values().stream()
                .filter(comment -> comment.postId().equals(postId))
                .toList();

        return commentList;
    }

    public Comment find(CommentId id, PostId postId) {
        Comment comment = comments.get(id);

        return comment;
    }

    public void save(Comment comment) {
        comments.put(comment.id(), comment);
    }

    public void delete(CommentId commentId) {
        comments.remove(commentId);
    }
}