package com.example.domain.model

data class LoginModel(
    var id : Int? = null,
    var userName : String? = "",
    var email : String? = "",
    var firstName : String? ="",
    var lastName : String? = "",
    var gender : String? ="",
    var image : String? ="",
    var token : String? = ""
)