package edu.mum.estore.repository.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.estore.domain.Category;
import edu.mum.estore.repository.CategoryRepository;
@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
 @PersistenceContext
 EntityManager entityManager;
	@Override
	public List<Category> getAll() {
	Query query=entityManager.createQuery("SELECT c from Category c");
		return (List<Category>)query.getResultList();
	}

}
