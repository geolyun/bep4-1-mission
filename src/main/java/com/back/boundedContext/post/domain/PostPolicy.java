package com.back.boundedContext.post.domain;

import com.back.boundedContext.member.domain.Member;
import com.back.global.exception.DomainException;
import org.springframework.stereotype.Service;

@Service
public class PostPolicy {

    public void checkCanDeletePost(Post post, Member requester) {
        if (!post.getAuthor().equals(requester)) {
            throw new DomainException("403", "작성자만 삭제할 수 있습니다.");
        }

        if (post.hasComments()) {
            throw new DomainException("409", "댓글이 달린 게시글은 삭제할 수 없습니다.");
        }
    }

    public void validatePostContent(String title, String content) {
        if (title.contains("비속어")) {
            throw new DomainException("400", "제목에 부적절한 단어가 포함되어 있습니다.");
        }
    }
}


