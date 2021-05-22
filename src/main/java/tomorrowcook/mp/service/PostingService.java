package tomorrowcook.mp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tomorrowcook.mp.domain.Member;
import tomorrowcook.mp.domain.Posting;
import tomorrowcook.mp.repository.PostingRepository;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class PostingService {

    private final PostingRepository postingRepository;


    /**
     * 회원가입
     * @param posting
     */
    @Transactional //변경
    public Long join(Posting posting) {
        postingRepository.save(posting);
        return posting.getId();
    }

    /**
     * 전체 회원 조회
     */
    public List<Posting> findPostings() {
        return postingRepository.findAll();
    }
    public Posting findOne(Long postingId) {
        return postingRepository.findOne(postingId);
    }
    public List<Posting> findUserPostings(String email){return postingRepository.findUserPosting(email);}
}
