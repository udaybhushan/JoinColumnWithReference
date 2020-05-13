package com.example.demo.repositories;

import java.io.Serializable;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;
@Transactional(readOnly = true)
public class NaturalRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID>
		implements NaturalRepository<T, ID> {

	private final EntityManager entityManager;

	public NaturalRepositoryImpl(JpaEntityInformation entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}


	@Override
	public T findBySimpleNaturalId(ID refNo) {
        return entityManager.unwrap(Session.class)
                .bySimpleNaturalId(this.getDomainClass())
                .load(refNo);
	}

}
