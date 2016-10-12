package edu.mum.estore.repository.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.estore.domain.Product;
import edu.mum.estore.repository.ProductRepository;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void addProduct(Product product) {
	 entityManager.persist(product);	
	}

	@Override
	public List<Product> searchProduct(String productName, String productCategory) {
		Query query = entityManager.createQuery(
				"SELECT p from Product p WHERE p.productName LIKE :productName AND p.category.categoryName=:categoryName");
		@SuppressWarnings("unchecked")
		List<Product> products = (List<Product>) query.setParameter(productName, productName)
				.setParameter("categoryName", productCategory).getResultList();
		return products;

	}

	@Override
	public Product getProductByName(long vendorId, String productName) {
		Query query = entityManager.createQuery(
				"SELECT p from Product p WHERE p.productName=:productName AND p.vendor.vendor_id=:vendorId");
		Product product=(Product) query.setParameter(productName, productName).setParameter("vendorId", vendorId).getSingleResult();
        return product;
	}

	@Override
	public Product get(long productId) {
		return entityManager.find(Product.class, productId);
	}

	@Override
	public Product update(Product product) {
		Query query = entityManager.createQuery(
				"UPDATE Product p SET p.lockNumber=:lockNumber WHERE p.productId=:productId");
		query.setParameter("productId", product.getProductId()).setParameter("lockNumber", product.getLockNumber());
        return product;
	}

}
