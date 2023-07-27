package ua.proxyband.twitter.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "posts")
@Data
public
class Post extends BaseEntity {
    String authorPostId;
    String content;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Post)) return false;
        if (!super.equals(o)) return false;

        Post post = (Post) o;

        if (getAuthorPostId() != null ? !getAuthorPostId().equals(post.getAuthorPostId()) : post.getAuthorPostId() != null)
            return false;
        return getContent() != null ? getContent().equals(post.getContent()) : post.getContent() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getAuthorPostId() != null ? getAuthorPostId().hashCode() : 0);
        result = 31 * result + (getContent() != null ? getContent().hashCode() : 0);
        return result;
    }
}
