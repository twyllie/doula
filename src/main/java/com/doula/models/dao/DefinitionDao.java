package com.doula.models.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.doula.models.Definition;

@Transactional
@Repository
public interface DefinitionDao extends CrudRepository<Definition, Integer> {
	
	Definition findByUid(int uid);
	
	List<Definition> findAll();
	
	List<Definition> findAllByOrderByCreated();

}
