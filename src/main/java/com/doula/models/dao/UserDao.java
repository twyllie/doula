package com.doula.models.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.doula.models.User;

@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Integer> {

	User findByUid(int uid);
	
	List<User> findAll();
	
	User findByEmail(String email);
	
	void deletebyUid(int uid);
}
