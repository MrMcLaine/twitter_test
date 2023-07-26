package ua.proxyband.twitter.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "comments")
@Data
public  class Comment extends BaseEntity {
    String authorId;
    String postId;
    String content;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comment)) return false;
        if (!super.equals(o)) return false;

        Comment comment = (Comment) o;

        if (getAuthorId() != null ? !getAuthorId().equals(comment.getAuthorId()) : comment.getAuthorId() != null)
            return false;
        if (getPostId() != null ? !getPostId().equals(comment.getPostId()) : comment.getPostId() != null) return false;
        return getContent() != null ? getContent().equals(comment.getContent()) : comment.getContent() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getAuthorId() != null ? getAuthorId().hashCode() : 0);
        result = 31 * result + (getPostId() != null ? getPostId().hashCode() : 0);
        result = 31 * result + (getContent() != null ? getContent().hashCode() : 0);
        return result;
    }
}
