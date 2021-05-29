package tomorrowcook.mp.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tomorrowcook.mp.domain.Ingredients;
import tomorrowcook.mp.domain.Member;
import tomorrowcook.mp.repository.IngredRepository;
import tomorrowcook.mp.repository.MemberRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class IngredService {

    private final IngredRepository ingredRepository;


    /**
     * 회원가입
     */
    @Transactional //변경
    public Long join(Ingredients ingredients) {
        ingredRepository.save(ingredients);
        return ingredients.getId();
    }

    /**
     * 전체 회원 조회
     */
    public List<Ingredients> findAll() {
        return ingredRepository.findAll();
    }
}