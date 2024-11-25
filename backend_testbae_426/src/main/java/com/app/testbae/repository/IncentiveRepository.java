package com.app.testbae.repository;

import com.app.testbae.model.Incentive;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class IncentiveRepository extends SimpleJpaRepository<Incentive, String> {
    private final EntityManager em;
    public IncentiveRepository(EntityManager em) {
        super(Incentive.class, em);
        this.em = em;
    }
    @Override
    public List<Incentive> findAll() {
        return em.createNativeQuery("Select * from \"testbae\".\"Incentive\"", Incentive.class).getResultList();
    }
}