package com.example.tp_kotlin.data

import lombok.Data
import lombok.ToString
import java.io.Serializable
import javax.persistence.*

@Entity
@Data
@ToString
class Category : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var name: String? = null
    var description: String? = null

    @OneToMany(mappedBy = "category")
    private var products: Collection<Product>? = null

    constructor(id: Long?, name: String?, description: String?, products: Collection<Product>?) {
        this.id = id
        this.name = name
        this.description = description
        this.products = products
    }

    constructor() {}

    fun getProducts(): Collection<Product>? {
        return products
    }

    fun setProducts(products: Collection<Product>?) {
        this.products = products
    }

    override fun toString(): String {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", products=" + products +
                '}'
    }


}