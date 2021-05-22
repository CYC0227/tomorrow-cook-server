package tomorrowcook.mp.repository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import tomorrowcook.mp.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);
    }

    public Member findOne(String email) {
        return em.find(Member.class, email);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByEmail(String email) {
        return em.createQuery("select m from Member m where m.email = :email",
                Member.class)
                .setParameter("email", email)
                .getResultList();
    }
}