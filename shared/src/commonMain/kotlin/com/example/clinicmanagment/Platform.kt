package com.example.clinicmanagment

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform