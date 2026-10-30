package jairo.com.herram.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import jairo.com.herram.model.Product
import jairo.com.herram.repository.ProductRepository

@Service
open class ProductService {

    @Autowired
    private lateinit var productRepository: ProductRepository

    open fun getAllProducts(): List<Product> {
        return productRepository.findAll()
    }

    open fun getProductById(id: Int): Product? {
        return productRepository.findById(id).orElse(null)
    }

    open fun saveProduct(product: Product): Product {
        return productRepository.save(product)
    }

    open fun deleteProduct(id: Int) {
        productRepository.deleteById(id)
    }
}