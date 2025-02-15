package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product) {
        productData.add(product);
        return product;
    }

    // boolean is used to check whether the deletion has been successful
    public boolean delete(Product product) {
        Product currentProduct = findById(product.getProductId());
        if (currentProduct != null) {
            productData.remove(currentProduct);
            return true;
        }
        return false;
    }

    // boolean is used to check whether the product has been updated successfully
    public boolean edit(Product product) {
        Product currentProduct = findById(product.getProductId());
        if (currentProduct != null) {
            currentProduct.setProductName(product.getProductName());
            currentProduct.setProductQuantity(product.getProductQuantity());
            return true;
        }
        return false;
    }

    public Iterator<Product> findAll() {
        return productData.iterator();
    }

    // Opted for a simpler for-loop implementation instead of using iterator
    // This aims to help people understand the code better
    public Product findById(String id) {
        Product currentProduct = productData.getFirst();
        if (currentProduct.getProductId().equals(id)) {
            return currentProduct;
        } else {
            for (Product product : productData) {
                if (product.getProductId().equals(id)) {
                    return product;
                }
            }
        }
        return null;
    }
}
