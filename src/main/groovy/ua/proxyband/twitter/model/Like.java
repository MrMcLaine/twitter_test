package ua.proxyband.twitter.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "likes")
@Data
class Like extends BaseEntity {
    String userId;
    String postId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Like)) return false;
        if (!super.equals(o)) return false;

        Like like = (Like) o;

        if (getUserId() != null ? !getUserId().equals(like.getUserId()) : like.getUserId() != null) return false;
        return getPostId() != null ? getPostId().equals(like.getPostId()) : like.getPostId() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getUserId() != null ? getUserId().hashCode() : 0);
        result = 31 * result + (getPostId() != null ? getPostId().hashCode() : 0);
        return result;
    }
}