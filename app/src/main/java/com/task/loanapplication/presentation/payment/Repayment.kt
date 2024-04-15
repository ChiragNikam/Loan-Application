package com.task.loanapplication.presentation.payment

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.task.loanapplication.domain.MainViewModel

@Composable
fun RepaymentOptionScreen(
    viewModel: MainViewModel,
    onConfirmClick: () -> Unit
) {
    val loanAmount by viewModel.selectedLoan.collectAsState()
    val dailyPayment = when(loanAmount){
        "3 Lakhs" -> "1000"
        "4 Lakhs" -> "1500"
        "5 Lakhs" -> "1750"
        "8 Lakhs" -> "2000"
        else -> " "
    }

    Scaffold(
        bottomBar = {
            Row(Modifier.padding(horizontal = 16.dp, vertical = 8.dp)) {
                Spacer(modifier = Modifier.weight(1f))
                // Confirm button
                Button(
                    modifier = Modifier.weight(0.4f),
                    onClick = onConfirmClick
                ) {
                    Text(text = "Confirm")
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = it.calculateTopPadding(),
                    bottom = it.calculateBottomPadding(),
                    start = 16.dp,
                    end = 16.dp
                ),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Info message
            Text(
                text = "Repayment Schedule and Timing",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 28.dp)
            )
            // Duration input field
            Text(
                text = "Loan Amount: $loanAmount",
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Daily payment input field
            Text(
                text = "Daily Payment: $dailyPayment",
                style = MaterialTheme.typography.bodyLarge
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Timing (display only)
            Text(
                text = "Timing: 8:00 PM",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            // SMS checkbox
            var isChecked by remember { mutableStateOf(false) }
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = { isChecked = it },
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = "I hereby agree to receive SMS from the application",
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun RepaymentScreenPreview() {
    RepaymentOptionScreen (viewModel = viewModel()){

    }
}