package edu.mum.estore.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.estore.domain.Category;
import edu.mum.estore.repository.CategoryRepository;
import edu.mum.estore.service.CategoryService;
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
@Autowired
CategoryRepository categoryRepository;
	@Override
	public List<Category> getAll() {
		return categoryRepository.getAll();
	}

}
