package com.example.clinicmanagment.database

fun createDatabase(): ClinicDatabase {
    val driver = DatabaseDriverFactory().createDriver()
    return ClinicDatabase(driver)
}