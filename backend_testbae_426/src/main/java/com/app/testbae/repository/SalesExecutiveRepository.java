package com.app.testbae.repository;

import com.app.testbae.model.SalesExecutive;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class SalesExecutiveRepository extends SimpleJpaRepository<SalesExecutive, String> {
    private final EntityManager em;
    public SalesExecutiveRepository(EntityManager em) {
        super(SalesExecutive.class, em);
        this.em = em;
    }
    @Override
    public List<SalesExecutive> findAll() {
        return em.createNativeQuery("Select * from \"testbae\".\"SalesExecutive\"", SalesExecutive.class).getResultList();
    }
}