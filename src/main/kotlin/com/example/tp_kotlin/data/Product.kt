package com.example.tp_kotlin.data

import lombok.Data
import lombok.ToString
import java.io.Serializable
import javax.persistence.*

@Entity
@Data
@ToString
class Product : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var name: String? = null
    var description: String? = null
    var currentPrice = 0.0
    var promotion = false
    var selected = false
    var available = false
    var photoName: String? = null

    @ManyToOne
    var category: Category? = null

    constructor(
        id: Long?,
        name: String?,
        description: String?,
        currentPrice: Double,
        promotion: Boolean,
        selected: Boolean,
        available: Boolean,
        photoName: String?,
        category: Category?
    ) {
        this.id = id
        this.name = name
        this.description = description
        this.currentPrice = currentPrice
        this.promotion = promotion
        this.selected = selected
        this.available = available
        this.photoName = photoName
        this.category = category
    }

    constructor() {}

    override fun toString(): String {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", currentPrice=" + currentPrice +
                ", promotion=" + promotion +
                ", selected=" + selected +
                ", available=" + available +
                ", photoName='" + photoName + '\'' +
                ", category=" + category +
                '}'
    }

    fun getid(): Long? {
        return id
    }

    fun setid(id: Long?) {
        this.id = id
    }

    fun getname(): String? {
        return name
    }

    fun setname(name: String?) {
        this.name = name
    }

    fun getdescription(): String? {
        return description
    }

    fun setdescription(description: String?) {
        this.description = description
    }

    fun getcurrentPrice(): Double {
        return currentPrice
    }

    fun setcurrentPrice(currentPrice: Double) {
        this.currentPrice = currentPrice
    }

    fun ispromotion(): Boolean {
        return promotion
    }

    fun setpromotion(promotion: Boolean) {
        this.promotion = promotion
    }

    fun isselected(): Boolean {
        return selected
    }

    fun setselected(selected: Boolean) {
        this.selected=selected
    }

    fun isavailable(): Boolean {
        return available
    }

    fun setavailable(available: Boolean) {
        this.available = available
    }

    fun getphotoName(): String? {
        return photoName
    }

    fun setphotoName(photoName: String?) {
        this.photoName = photoName
    }

    fun getcategory(): Category? {
        return category
    }

    fun setcategory(category: Category?) {
        this.category = category
    }

}