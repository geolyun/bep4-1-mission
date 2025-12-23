package com.back.boundedContext.post.event;

import com.back.boundedContext.member.entity.Member;
import com.back.boundedContext.post.entity.PostComment;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class PostCommentCreatedEvent extends ApplicationEvent {
    private final Member author;
    private final PostComment postComment;

    public PostCommentCreatedEvent(Object source, PostComment postComment, Member author) {
        super(source);
        this.postComment = postComment;
        this.author = author;
    }
}