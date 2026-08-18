package com.example.clinicmanagment.database

import app.cash.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory {

    actual fun createDriver(): SqlDriver {
        throw NotImplementedError(
            "iOS database driver has not been implemented yet"
        )
    }
}