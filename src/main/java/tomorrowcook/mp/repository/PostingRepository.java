package tomorrowcook.mp.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import tomorrowcook.mp.domain.Member;
import tomorrowcook.mp.domain.Posting;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostingRepository {

    private final EntityManager em;

    public void save(Posting posting) {
        em.persist(posting);
    }

    public Posting findOne(Long id) {
        return em.find(Posting.class, id);
    }

    public List<Posting> findAll() {
        return em.createQuery("select p from Posting p", Posting.class)
                .getResultList();
    }

    public List<Posting> findUserPosting(String email) {
        Member findMember = em.find(Member.class, email);

        return em.createQuery("select p from Posting p where p.member = :email", Posting.class)
                .setParameter("email", findMember)
                .getResultList();
    }

    public List<Posting> findByCountry (String country) {
        return em.createQuery("select p from Posting p where country = :country", Posting.class)
                .setParameter("country", country)
                .getResultList();
    }

    public List<Posting> findByAnniversary (String anniversary) {
        return em.createQuery("select p from Posting p where anniversary = :anniversary", Posting.class)
                .setParameter("anniversary", anniversary)
                .getResultList();
    }

    public List<Posting> findByName(String name) {
        return em.createQuery("select m from Posting m where m.name = :name",
                Posting.class)
                .setParameter("name", name)
                .getResultList();
    }
}
