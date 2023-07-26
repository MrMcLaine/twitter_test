package ua.proxyband.twitter.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "subscriptions")
@Data
public class Subscription extends BaseEntity {
    String followerId;
    String ownerUserId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subscription)) return false;
        if (!super.equals(o)) return false;

        Subscription that = (Subscription) o;

        if (getFollowerId() != null ? !getFollowerId().equals(that.getFollowerId()) : that.getFollowerId() != null)
            return false;
        return getOwnerUserId() != null ? getOwnerUserId().equals(that.getOwnerUserId()) : that.getOwnerUserId() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getFollowerId() != null ? getFollowerId().hashCode() : 0);
        result = 31 * result + (getOwnerUserId() != null ? getOwnerUserId().hashCode() : 0);
        return result;
    }
}
