package com.app.testbae.repository;

import com.app.testbae.model.IncentiveSEExec;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class IncentiveSEExecRepository extends SimpleJpaRepository<IncentiveSEExec, String> {
    private final EntityManager em;
    public IncentiveSEExecRepository(EntityManager em) {
        super(IncentiveSEExec.class, em);
        this.em = em;
    }
    @Override
    public List<IncentiveSEExec> findAll() {
        return em.createNativeQuery("Select * from \"testbae\".\"IncentiveSEExec\"", IncentiveSEExec.class).getResultList();
    }
}