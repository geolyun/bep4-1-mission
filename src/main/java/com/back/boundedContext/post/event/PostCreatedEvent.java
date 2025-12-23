package com.back.boundedContext.post.event;

import com.back.boundedContext.member.entity.Member;
import com.back.boundedContext.post.entity.Post;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class PostCreatedEvent extends ApplicationEvent {
    private final Member author;
    private final Post post;

    public PostCreatedEvent(Object source, Post post, Member author) {
        super(source);
        this.post = post;
        this.author = author;
    }
}
