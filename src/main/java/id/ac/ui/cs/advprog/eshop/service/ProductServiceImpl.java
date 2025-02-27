package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl() {
        productRepository = new ProductRepository();
    }

    @Override
    public Product create(Product product) {
        productRepository.create(product);
        return product;
    }

    @Override
    public Product delete(String productId) {
        return productRepository.delete(productId);
    }

    @Override
    public Product edit(String productId, Product product) {
        productRepository.update(productId, product);
        return product;
    }

    @Override
    public List<Product> findAll() {
        Iterator<Product> productIterator = productRepository.findAll();
        List<Product> allProduct = new ArrayList<>();
        productIterator.forEachRemaining(allProduct::add);
        return allProduct;
    }

    @Override
    public Product findById(String id) {
        return productRepository.findById(id);
    }
}
