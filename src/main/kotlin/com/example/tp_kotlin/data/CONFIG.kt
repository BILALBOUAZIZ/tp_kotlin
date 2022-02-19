package com.example.tp_kotlin.data

import com.example.tp_kotlin.dao.CategoryRepository
import com.example.tp_kotlin.dao.ProductRepository
import net.bytebuddy.utility.RandomString
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.*
import java.util.List

@Configuration
class Config {
    @Autowired
    var categoryRepository: CategoryRepository? = null

    @Autowired
    var productRepository: ProductRepository? = null
    @Bean
    fun commandLineRunnerCategory(repository: CategoryRepository): CommandLineRunner {
        return CommandLineRunner { args: Array<String?>? ->
            val category = Category(
                null,
                "Computers",
                null,
                null
            )
            val category1 = Category(
                null,
                "Smartphones",
                null,
                null
            )
            val category2 = Category(
                null,
                "Printers",
                null,
                null
            )
            repository.saveAll(
                List.of(category, category2, category1)
            )
            val rnd = Random()
            categoryRepository?.findAll()?.forEach { cat ->
                for (i in 0..9) {
                    val p = Product()
                    p.setname(RandomString.make(10))
                    p.setcurrentPrice((100 + rnd.nextInt(1000)).toDouble())
                    p.setavailable(rnd.nextBoolean())
                    p.setpromotion(rnd.nextBoolean())
                    p.setselected(rnd.nextBoolean())
                    p.setcategory(cat)
                    p.setphotoName("unknown.png")
                    productRepository?.save(p)
                }
            }
        }
    }
}