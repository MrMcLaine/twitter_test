package ua.proxyband.twitter.service.impl;

import org.springframework.stereotype.Service;
import ua.proxyband.twitter.model.Like;
import ua.proxyband.twitter.repository.LikeRepository;
import ua.proxyband.twitter.service.LikeService;

@Service
class LikeServiceImpl implements LikeService {
    private final LikeRepository likeRepository;

    LikeServiceImpl(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @Override
    public Like createLike(Like like) {

        return likeRepository.save(like);
    }

    @Override
    public boolean deleteLike(String likeId) {
        Like existingLike = likeRepository.findById(likeId).orElse(null);
        if (existingLike != null) {
            likeRepository.delete(existingLike);

            return true;
        }
        return false;
    }
}

