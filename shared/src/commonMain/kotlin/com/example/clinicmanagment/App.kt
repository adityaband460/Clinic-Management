package com.example.clinicmanagment

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun App() {

    var selectedScreen by remember { mutableStateOf("Dashboard") }

    MaterialTheme {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {

            // Sidebar
            Sidebar(
                selectedScreen = selectedScreen,
                onScreenSelected = { selectedScreen = it }
            )

            // Main content
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
            ) {

                when (selectedScreen) {

                    "Dashboard" -> DashboardScreen()

                    else -> PlaceholderScreen(selectedScreen)
                }
            }
        }
    }
}
@Composable
fun Sidebar(
    selectedScreen: String,
    onScreenSelected: (String) -> Unit
) {

    val menuItems = listOf(
        "Dashboard",
        "Patients",
        "Appointments",
        "Consultations",
        "Payments",
        "Prescriptions",
        "Settings"
    )

    Column(
        modifier = Modifier
            .width(220.dp)
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(16.dp)
    ) {

        Text(
            text = "Clinic Management",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(24.dp))

        menuItems.forEach { item ->

            TextButton(
                onClick = {
                    onScreenSelected(item)
                },
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = item,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
@Composable
fun DashboardScreen() {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Text(
            text = "Good afternoon, Doctor",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Today's overview",
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            SummaryCard(
                title = "Today's Patients",
                value = "7"
            )

            SummaryCard(
                title = "Waiting",
                value = "2"
            )

            SummaryCard(
                title = "Completed",
                value = "3"
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Upcoming Appointments",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        AppointmentRow(
            time = "12:00 PM",
            patient = "Rahul",
            type = "New",
            status = "Scheduled"
        )

        AppointmentRow(
            time = "01:00 PM",
            patient = "Amit",
            type = "Follow-up",
            status = "Waiting"
        )

        AppointmentRow(
            time = "01:45 PM",
            patient = "Priya",
            type = "New",
            status = "Scheduled"
        )
    }
}
@Composable
fun SummaryCard(
    title: String,
    value: String
) {

    Card(
        modifier = Modifier
            .width(180.dp)
            .height(120.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = value,
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}
@Composable
fun AppointmentRow(
    time: String,
    patient: String,
    type: String,
    status: String
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Text(time)

            Text(patient)

            Text(type)

            Text(status)
        }
    }
}
@Composable
fun PlaceholderScreen(screenName: String) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        Text(
            text = screenName,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "$screenName screen will be implemented later."
        )
    }
}