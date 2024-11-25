package com.app.testbae.repository;

import com.app.testbae.model.HOUser;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class HOUserRepository extends SimpleJpaRepository<HOUser, String> {
    private final EntityManager em;
    public HOUserRepository(EntityManager em) {
        super(HOUser.class, em);
        this.em = em;
    }
    @Override
    public List<HOUser> findAll() {
        return em.createNativeQuery("Select * from \"testbae\".\"HOUser\"", HOUser.class).getResultList();
    }
}