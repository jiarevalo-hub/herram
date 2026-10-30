package jairo.com.herram.model

import jakarta.persistence.*

@Entity
@Table(name = "product")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column(name = "description", length = 100)
    val description: String? = null,

    @Column(name = "price", length = 100)
    val price: String? = null,

    @Column(name = "stock")
    val stock: Int? = null
)