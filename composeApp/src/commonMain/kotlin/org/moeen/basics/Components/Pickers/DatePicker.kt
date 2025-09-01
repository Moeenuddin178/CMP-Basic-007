package org.moeen.basics.Components.Pickers

import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlin.time.ExperimentalTime
import androidx.navigation.NavController
import org.moeen.basics.Components.BackButton

@Composable
fun DatePickerEx(navController: NavController) {
    // Add BackButton at the top
    BackButton(navController)
    
    var selectedDate by remember { mutableStateOf<Long?>(null) }
    var showModal by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        OutlinedTextField(
            value = selectedDate?.let { convertMillisToDateString(it) } ?: "",
            onValueChange = {},
            label = { Text("DoB") },
            placeholder = { Text("MM/DD/YYYY") },
            trailingIcon = { Icon(Icons.Default.DateRange, contentDescription = "Select date") },
            modifier = Modifier
                .fillMaxWidth()
                .pointerInput(selectedDate) {
                    awaitEachGesture {
                        awaitFirstDown(pass = PointerEventPass.Initial)
                        val upEvent = waitForUpOrCancellation(pass = PointerEventPass.Initial)
                        if (upEvent != null) showModal = true
                    }
                }
        )
    }

    if (showModal) {
        DatePickerModal(
            onDateSelected = {
                selectedDate = it
                showModal = false
            },
            onDismiss = { showModal = false }
        )
    }
}

@OptIn(ExperimentalTime::class)
private fun convertMillisToDateString(millis: Long): String {
    val localDate = Instant.fromEpochMilliseconds(millis)
        .toLocalDateTime(TimeZone.currentSystemDefault())
        .date
    val day = localDate.dayOfMonth.toString().padStart(2, '0')
    val month = localDate.monthNumber.toString().padStart(2, '0')
    val year = localDate.year.toString()
    return "$day/$month/$year"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerModal(
    onDateSelected: (Long?) -> Unit,
    onDismiss: () -> Unit
) {
    val datePickerState = rememberDatePickerState()

    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = { onDateSelected(datePickerState.selectedDateMillis) }) {
                Text("OK")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) { Text("Cancel") }
        }
    ) {
        DatePicker(state = datePickerState)
    }
}

//package org.moeen.basics.dumy
//
//
//import androidx.compose.foundation.gestures.awaitEachGesture
//import androidx.compose.foundation.gestures.awaitFirstDown
//import androidx.compose.foundation.gestures.waitForUpOrCancellation
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.DateRange
//import androidx.compose.material3.DatePicker
//import androidx.compose.material3.DatePickerDialog
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.Icon
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextButton
//import androidx.compose.material3.rememberDatePickerState
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.input.pointer.PointerEventPass
//import androidx.compose.ui.input.pointer.pointerInput
//import androidx.compose.ui.tooling.preview.Preview
//import com.example.newjetpackcomposecourse.`21_Switch`.SwitchEx
//import java.text.SimpleDateFormat
//import java.util.Date
//import java.util.Locale
//
//@Composable
//fun DatePicker() {
//    var selectedDate by remember { mutableStateOf<Long?>(null) }
//
//    var showModal by remember { mutableStateOf(false) }
//
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ){
//
//        OutlinedTextField(
//
//            value = selectedDate?.let { convertMillisToDateString(it) } ?: "",
//            onValueChange = {
//            },
//            label = {
//                Text("DoB")
//            },
//            placeholder = { Text("MM/DD/YYYY") },
//            trailingIcon = {
//                Icon(Icons.Default.DateRange, contentDescription = "Select date")
//
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .pointerInput(selectedDate) {
//
//                    awaitEachGesture {
//                        awaitFirstDown(pass = PointerEventPass.Initial)
//                        val upEvent = waitForUpOrCancellation(pass = PointerEventPass.Initial)
//                        if (upEvent != null) {
//
//                            showModal = true
//                        }
//                    }
//                }
//
//
//        )
//
//    }
//
//
//    if (showModal) {
//        DatePickerModal(
//            onDateSelected = {
//                selectedDate = it
//
//            },
//            onDismiss = {
//
//                showModal = false
//
//
//            }
//
//        )
//    }
//
//
//}
//
//fun convertMillisToDateString(millis: Long): String {
//    val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
//    return formatter.format(Date(millis))
//}
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun DatePickerModal(
//
//    onDateSelected: (Long?) -> Unit,
//    onDismiss: () -> Unit
//) {
//    val datePickerState = rememberDatePickerState()
//
//    DatePickerDialog(
//        onDismissRequest = onDismiss,
//        confirmButton = {
//
//            TextButton(
//                onClick = {
//                    onDateSelected(datePickerState.selectedDateMillis)
//                    onDismiss
//                }
//            ) {
//                Text("OK")
//
//            }
//        },
//        dismissButton = {
//            TextButton(
//
//                onClick = onDismiss
//            ) {
//                Text("Cancel")
//
//            }
//        }
//    ) {
//        DatePicker(state = datePickerState)
//    }
//
//}
//
//
//
//
//
