package ua.proxyband.twitter.service;

import ua.proxyband.twitter.model.Like;

public interface LikeService {
    Like createLike(Like like);
    boolean deleteLike(String likeId);
}
