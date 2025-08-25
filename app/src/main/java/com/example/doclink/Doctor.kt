package com.example.doclink

data class Doctor(
    val name: String,
    val specialty: String,
    val availability: String,
    val imageUrl: String,
    val rating: Float,
    val reviews: Int
)