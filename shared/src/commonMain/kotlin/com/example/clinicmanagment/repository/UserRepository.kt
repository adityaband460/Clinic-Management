package com.example.clinicmanagment.repository

import com.example.clinicmanagment.database.ClinicDatabase

class UserRepository(
    private val database: ClinicDatabase
) {

    fun getAllUsers() =
        database.coreSchemaQueries
            .selectAllUsers()
            .executeAsList()

    fun createUser(
        id: String,
        username: String,
        passwordHash: String,
        fullName: String,
        role: String
    ) {
        val now = kotlin.time.Clock.System.now().toEpochMilliseconds()

        database.coreSchemaQueries.insertUser(
            id = id,
            username = username,
            password_hash = passwordHash,
            full_name = fullName,
            role = role,
            is_active = 1,
            created_at = now,
            updated_at = now
        )
    }
}