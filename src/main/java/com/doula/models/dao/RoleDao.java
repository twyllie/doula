package com.doula.models.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.doula.models.Role;

@Transactional
@Repository
public interface RoleDao extends CrudRepository<Role, Integer>{
	
	List<Role> findAll();
}
