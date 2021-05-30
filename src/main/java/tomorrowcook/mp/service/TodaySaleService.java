package tomorrowcook.mp.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tomorrowcook.mp.domain.Posting;
import tomorrowcook.mp.domain.TodaySale;
import tomorrowcook.mp.repository.TodaySaleRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TodaySaleService {

    private final TodaySaleRepository todaySaleRepository;

    @Transactional //변경
    public Long join(TodaySale todaySale) {
        todaySaleRepository.save(todaySale);
        return todaySale.getId();
    }

    public List<TodaySale> findTodaySales() {
        return todaySaleRepository.findAll();
    }

    public List<TodaySale> findByRegion(String region){return todaySaleRepository.findByRegion(region);}

}
