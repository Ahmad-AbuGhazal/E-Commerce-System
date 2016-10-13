package edu.mum.estore.repository;

import java.util.List;

import edu.mum.estore.domain.Category;

public interface CategoryRepository {
	List<Category> getAll();
}
