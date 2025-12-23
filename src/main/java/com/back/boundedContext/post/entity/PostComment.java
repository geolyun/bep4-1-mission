package com.back.boundedContext.post.entity;

import com.back.boundedContext.member.entity.Member;
import com.back.global.jpa.entity.BaseIdAndTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class PostComment extends BaseIdAndTime {
    @ManyToOne(fetch = FetchType.LAZY)
    private com.back.boundedContext.post.entity.Post post;
    @ManyToOne(fetch = FetchType.LAZY)
    private Member author;
    @Column(columnDefinition = "TEXT")
    private String content;

    public PostComment(com.back.boundedContext.post.entity.Post post, Member author, String content) {
        this.post = post;
        this.author = author;
        this.content = content;
    }
}
