package com.back.boundedContext.post.service;

import com.back.boundedContext.member.entity.Member;
import com.back.boundedContext.post.entity.Post;
import com.back.boundedContext.post.entity.PostComment;
import com.back.boundedContext.post.event.PostCommentCreatedEvent;
import com.back.boundedContext.post.event.PostCreatedEvent;
import com.back.boundedContext.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final ApplicationEventPublisher publisher;

    public long count() {
        return postRepository.count();
    }

    public Post write(Member author, String title, String content) {
        Post post = new Post(author, title, content);

        publisher.publishEvent(new PostCreatedEvent(this, post, author));

        return postRepository.save(post);
    }

    public Optional<Post> findById(int id) {
        return postRepository.findById(id);
    }

    @Transactional
    public PostComment addComment(Post post, Member author, String content) {
        PostComment postComment = post.addComment(author, content);

        publisher.publishEvent(new PostCommentCreatedEvent(this, postComment, author));

        return postComment;
    }
}
