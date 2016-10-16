package edu.mum.estore.repository.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.estore.domain.Product;
import edu.mum.estore.exception.ProductNotFoundException;
import edu.mum.estore.repository.ProductRepository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

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
		List<Product> products = (List<Product>) query.setParameter("productName", "%" + productName + "%")
				.setParameter("categoryName", productCategory).getResultList();
		return products;

	}

	@Override
	public Product getProductByName(long vendorId, String productName) {
		try {
			Query query = entityManager.createQuery(
					"SELECT p from Product p WHERE p.productName=:productName AND p.vendor.vendor_sn=:vendorId");
			Product product = (Product) query.setParameter("productName", productName)
					.setParameter("vendorId", vendorId).getSingleResult();
			return product;

		} catch (Exception ex) {
			return null;
		}
	}

	@Override
	public Product get(long productId) {
		return entityManager.find(Product.class, productId);
	}

	@Override
	public Product update(Product product) {
		Query query = entityManager
				.createQuery("UPDATE Product p SET p.lockNumber=:lockNumber WHERE p.productId=:productId");
		System.out.println(product.getLockNumber());
		query.setParameter("productId", product.getProductId()).setParameter("lockNumber", product.getLockNumber())
				.executeUpdate();
		return product;
	}

	@Override
	public List<Product> findProductsByVendorId(long vendorId) {
		try{
		Query query = entityManager.createQuery(
		"SELECT p from Product p WHERE p.vendor_VENDOR_SN=:vendorId");
		List<Product> products = (List<Product>)query.setParameter("vendorId", vendorId).getResultList();
		return products;
		}catch(Exception ex){
		throw new ProductNotFoundException("No product found under this vendor.");
		}
}
}
