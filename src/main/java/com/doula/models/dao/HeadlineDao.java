package com.doula.models.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.doula.models.Headline;

@Transactional
@Repository
public interface HeadlineDao extends CrudRepository<Headline, Integer> {
	
	Headline findByUid(int uid);
	
	List<Headline> findAll();
	
	
}
