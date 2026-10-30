package jairo.com.herram.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import jairo.com.herram.model.Product

@Repository
interface ProductRepository : JpaRepository<Product, Int> {
}