package swm.s3.coclimb.api.adapter.out.persistence.media;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import swm.s3.coclimb.api.application.port.out.persistence.media.MediaLoadPort;
import swm.s3.coclimb.api.application.port.out.persistence.media.MediaUpdatePort;
import swm.s3.coclimb.domain.media.Media;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MediaRepository implements MediaLoadPort, MediaUpdatePort {

    private final MediaJpaRepository mediaJpaRepository;

    @Override
    public void save(Media media) {
        mediaJpaRepository.save(media);
    }

    @Override
    public Optional<Media> findByInstagramMediaId(String instagramMediaId) {
        return mediaJpaRepository.findByInstagramMediaInfoId(instagramMediaId);
    }

    @Override
    public Page<Media> findAllPaged(PageRequest pageRequest) {
        return mediaJpaRepository.findByIdNotNull(pageRequest);
    }

    @Override
    public Page<Media> findPagedByUserId(Long userId, PageRequest pageRequest) {
        return mediaJpaRepository.findPagedByUserId(userId, pageRequest);
    }

    @Override
    public Optional<Media> findById(Long mediaId) {
        return mediaJpaRepository.findById(mediaId);
    }

    @Override
    public void delete(Media media) {
        mediaJpaRepository.delete(media);
    }
}
