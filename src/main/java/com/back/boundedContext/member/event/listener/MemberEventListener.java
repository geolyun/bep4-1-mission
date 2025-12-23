package com.back.boundedContext.member.event.listener;

import com.back.boundedContext.member.entity.Member;
import com.back.boundedContext.post.event.PostCommentCreatedEvent;
import com.back.boundedContext.post.event.PostCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class MemberEventListener {

    @EventListener
    @Transactional
    public void listen(PostCreatedEvent event) {
        Member author = event.getAuthor();
        author.increaseActivityPoint(3); // 게시글 작성 시 +3점
    }

    @EventListener
    @Transactional
    public void listen(PostCommentCreatedEvent event) {
        Member author = event.getAuthor();
        author.increaseActivityPoint(1); // 댓글 작성 시 +1점
    }

}
