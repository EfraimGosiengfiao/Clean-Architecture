package com.example.domain.model

data class ProductsModel(
    var productsList : List<Products>
)
data class Products(
    var id : Int? = 0,
    var title : String? = "",
    var description : String? = "",
    var price : Int? = null,
    var discountPercentage : Double? = null,
    var rating : Double? = null,
    var stock : Int? = null,
    var brand : String? = ""
)