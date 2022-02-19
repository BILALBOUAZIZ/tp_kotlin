package com.example.tp_kotlin.dao

import com.example.tp_kotlin.data.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface ProductRepository : JpaRepository<Product?, Long?>