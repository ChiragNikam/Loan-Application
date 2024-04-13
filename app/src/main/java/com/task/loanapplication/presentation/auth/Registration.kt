package com.task.loanapplication.presentation.auth

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.task.loanapplication.R

@Composable
fun RegistrationScreen(
    onRegisterClick: () -> Unit
) {
    var userName by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var panNumber by remember { mutableStateOf("") }
    var mobileNo by remember { mutableStateOf("") }
    var electricBillNo by remember { mutableStateOf("") }
    var bankingStatementAct by remember { mutableStateOf("") }
    var housingReciptNo by remember { mutableStateOf("") }
    var selectedPhotoUri by remember { mutableStateOf<Uri?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        // Photo Selector
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Select Photo",
            modifier = Modifier
                .size(140.dp)
                .background(Color.LightGray, shape = RoundedCornerShape(12.dp))
                .clickable {
                    // Open photo selector here
                }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Username Field
        OutlinedTextField(
            value = userName,
            onValueChange = { userName = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Address Field
        OutlinedTextField(
            value = address,
            onValueChange = { address = it },
            label = { Text("Address") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // PAN Number Field
        OutlinedTextField(
            value = panNumber,
            onValueChange = { panNumber = it },
            label = { Text("PAN Number") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Mobile Number Field
        OutlinedTextField(
            value = mobileNo,
            onValueChange = { mobileNo = it },
            label = { Text("Mobile Number") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Electric Bill Number Field
        OutlinedTextField(
            value = electricBillNo,
            onValueChange = { electricBillNo = it },
            label = { Text("Electric Bill Number") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Banking Statement Account Field
        OutlinedTextField(
            value = bankingStatementAct,
            onValueChange = { bankingStatementAct = it },
            label = { Text("Banking Statement Account") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Housing Receipt Number Field
        OutlinedTextField(
            value = housingReciptNo,
            onValueChange = { housingReciptNo = it },
            label = { Text("Housing Receipt Number") },
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(28.dp))

        // Register Button
        Button(
            onClick = { onRegisterClick() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Register")
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview(showSystemUi = true)
@Composable
private fun RegistrationScreenPreview() {
    Surface(modifier = Modifier.verticalScroll(rememberScrollState())) {
        RegistrationScreen {}
    }
}