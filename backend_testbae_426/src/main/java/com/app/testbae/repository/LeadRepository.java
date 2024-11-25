package com.app.testbae.repository;

import com.app.testbae.model.Lead;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class LeadRepository extends SimpleJpaRepository<Lead, String> {
    private final EntityManager em;
    public LeadRepository(EntityManager em) {
        super(Lead.class, em);
        this.em = em;
    }
    @Override
    public List<Lead> findAll() {
        return em.createNativeQuery("Select * from \"testbae\".\"Lead\"", Lead.class).getResultList();
    }
}