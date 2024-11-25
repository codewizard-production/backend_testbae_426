package com.app.testbae.repository;

import com.app.testbae.model.Agent;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class AgentRepository extends SimpleJpaRepository<Agent, String> {
    private final EntityManager em;
    public AgentRepository(EntityManager em) {
        super(Agent.class, em);
        this.em = em;
    }
    @Override
    public List<Agent> findAll() {
        return em.createNativeQuery("Select * from \"testbae\".\"Agent\"", Agent.class).getResultList();
    }
}