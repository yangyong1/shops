package com.yang.framework.Repository;

/**
 * Created by zen on 2015/4/3.
 */

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;

@NoRepositoryBean
public class MyCustomRepository<T, ID extends Serializable>
        extends SimpleJpaRepository<T, ID> implements MyRepository<T, ID> {


    private final EntityManager entityManager;

    public MyCustomRepository(Class<T> domainClass, EntityManager em) {
        super(domainClass, em);
        // TODO Auto-generated constructor stub

        entityManager=em;
    }

    public MyCustomRepository(final JpaEntityInformation<T, ?> entityInformation, final EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }


    public String sharedCustomMethod() {
        return "hello sharedCustomMethod";
        // implementation goes here
    }
}