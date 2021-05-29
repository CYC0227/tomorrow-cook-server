package tomorrowcook.mp.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import tomorrowcook.mp.domain.Ingredients;
import tomorrowcook.mp.domain.TodaySale;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class IngredRepository {

    private final EntityManager em;

    public void save(Ingredients ingredients) {
        em.persist(ingredients);
    }
//
//    public TodaySale findOne(String email) {
//        return em.find(TodaySale.class, email);
//    }

    public List<Ingredients> findAll() {
        return em.createQuery("select i from Ingredients i", Ingredients.class)
                .getResultList();
    }

//    public List<TodaySale> findByEmail(String email) {
//        return em.createQuery("select m from Member m where m.email = :email",
//                TodaySale.class)
//                .setParameter("email", email)
//                .getResultList();
//    }
}