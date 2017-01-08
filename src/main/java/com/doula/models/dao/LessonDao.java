package com.doula.models.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.doula.models.Lesson;

@Transactional
@Repository
public interface LessonDao extends CrudRepository<Lesson, Integer> {

	Lesson findByUid(int uid);
	
	List<Lesson> findAll();
	
	void deletebyUid(int uid);
}
