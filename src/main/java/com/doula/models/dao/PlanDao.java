package com.doula.models.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.doula.models.Plan;

@Transactional
@Repository
public interface PlanDao extends CrudRepository<Plan, Integer>{

	Plan findByUid(int uid);
	
	void deleteByUid(int uid);
	
}
