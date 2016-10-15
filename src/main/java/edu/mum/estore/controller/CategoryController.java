package edu.mum.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.estore.domain.Category;
import edu.mum.estore.domain.JsonResponse;
import edu.mum.estore.service.CategoryService;

@RestController
public class CategoryController {
	@Autowired
	CategoryService categoryService;
	@ResponseBody
	@RequestMapping(value="/categories",method=RequestMethod.GET, produces="application/json")
	public JsonResponse<Category> getCategories(){
		JsonResponse<Category> response = new JsonResponse<Category>();
		response.setData(categoryService.getAll());
		return response;		
	}
}
