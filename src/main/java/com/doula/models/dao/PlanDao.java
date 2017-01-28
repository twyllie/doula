package com.doula.models.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.doula.models.Plan;
import com.doula.models.User;

@Transactional
@Repository
public interface PlanDao extends CrudRepository<User, Integer>{

	Plan findByUid(int uid);
	
	void deleteByUid(int uid);
	
}
