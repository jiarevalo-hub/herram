package jairo.com.herram.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import jairo.com.herram.model.Product
import jairo.com.herram.service.ProductService

@RestController
@RequestMapping("/product")
open class ProductController {

    @Autowired
    open lateinit var productService: ProductService

    @GetMapping
    open fun getAllProducts(): List<Product> {
        return productService.getAllProducts()
    }

    @GetMapping("/{id}")
    open fun getProductById(@PathVariable id: Int): ResponseEntity<Product> {
        val product = productService.getProductById(id)
        return if (product != null) {
            ResponseEntity.ok(product)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PostMapping
    open fun createProduct(@RequestBody product: Product): Product {
        return productService.saveProduct(product)
    }

    @PutMapping("/{id}")
    open fun updateProduct(@PathVariable id: Int, @RequestBody productDetails: Product): ResponseEntity<Product> {
        val existingProduct = productService.getProductById(id)
        return if (existingProduct != null) {
            val updatedProduct = existingProduct.copy(
                description = productDetails.description,
                price = productDetails.price,
                stock = productDetails.stock
            )
            ResponseEntity.ok(productService.saveProduct(updatedProduct))
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    open fun deleteProduct(@PathVariable id: Int): ResponseEntity<Void> {
        return if (productService.getProductById(id) != null) {
            productService.deleteProduct(id)
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}