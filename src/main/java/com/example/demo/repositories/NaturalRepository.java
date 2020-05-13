package com.example.demo.repositories;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface NaturalRepository<T, ID extends Serializable> extends JpaRepository<T, ID>  {
	
	T findBySimpleNaturalId(ID refNo);

}
