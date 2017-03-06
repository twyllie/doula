package com.doula.models.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.doula.models.Article;

@Transactional
@Repository
public interface ArticleDao extends CrudRepository<Article, Integer>{

	Article findByUid(int uid);
	
	List<Article> findAll();
	
	List<Article> findAllByOrderByCreated();
	
}
