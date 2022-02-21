package com.ezetap.sample.model

/**
 * Created by Atif Qamar on 2/1/22.
 */
data class Product(
    var id: Int,
    var productImage : Int,
    var productName: String,
    var productShortDescription: String,
    var productDescription: String,
    var productAmount: Double)