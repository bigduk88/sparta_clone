package com.sparta.sparta_clone.util;

import com.sparta.sparta_clone.domain.Comment;
import org.springframework.data.jpa.domain.Specification;

public class CommentSpecs {

    public CommentSpecs() {
    }

    public static Specification<Comment> withContents_id(Long contentsId) {
        return ((root, query, builder) ->
                builder.equal(root.get("contentsId"), contentsId)
        );
    }
}
