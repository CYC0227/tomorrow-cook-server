package tomorrowcook.mp.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import tomorrowcook.mp.domain.TodaySale;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TodaySaleRepository {

    private final EntityManager em;

    public void save(TodaySale todaySale) {
        em.persist(todaySale);
    }
//
//    public TodaySale findOne(String email) {
//        return em.find(TodaySale.class, email);
//    }

    public List<TodaySale> findAll() {
        return em.createQuery("select t from TodaySale t", TodaySale.class)
                .getResultList();
    }

//    public List<TodaySale> findByEmail(String email) {
//        return em.createQuery("select m from Member m where m.email = :email",
//                TodaySale.class)
//                .setParameter("email", email)
//                .getResultList();
//    }
}