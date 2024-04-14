package com.task.loanapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.task.loanapplication.presentation.auth.LoginScreen
import com.task.loanapplication.presentation.auth.RegistrationScreen
import com.task.loanapplication.presentation.auth.UploadDocumentsScreen
import com.task.loanapplication.presentation.details.PaymentConfirmationScreen
import com.task.loanapplication.presentation.details.PaymentHistoryScreen
import com.task.loanapplication.presentation.details.RateAppScreen
import com.task.loanapplication.presentation.details.getSamplePaymentHistory
import com.task.loanapplication.presentation.loan.SelectLoanAmountScreen
import com.task.loanapplication.presentation.loan.TermsAndConditionsScreen
import com.task.loanapplication.presentation.payment.QRCodeScreen
import com.task.loanapplication.presentation.payment.RepaymentOptionScreen

@Composable
fun NavigationForApp(
    navHostController: NavHostController
) {
    NavHost(navController = navHostController, startDestination = "auth") {
        navigation(startDestination = "auth/login", route = "auth") {
            composable("auth/login") {
                LoginScreen(onLoginClick = {
                    navHostController.navigate("loan")
                }) {
                    navHostController.navigate("auth/register")
                }
            }
            composable("auth/register") {
                RegistrationScreen {
                    navHostController.navigate("auth/upload_docs")
                }
            }
            composable("auth/upload_docs"){
                UploadDocumentsScreen {
                    navHostController.navigate("loan")
                }
            }
        }
        navigation(startDestination = "loan/amount", route = "loan") {
            composable("loan/amount") {
                SelectLoanAmountScreen {
                    navHostController.navigate("loan/t_and_c")
                }
            }
            composable("loan/t_and_c") {
                TermsAndConditionsScreen {
                    navHostController.navigate("payment")
                }
            }
        }
        navigation(startDestination = "payment/repayment", route = "payment") {
            composable("payment/repayment") {
                RepaymentOptionScreen {
                    navHostController.navigate("payment/qr_code")
                }
            }
            composable("payment/qr_code") {
                QRCodeScreen(onDoneClick = {
                    navHostController.navigate("details")
                }) {
                    navHostController.popBackStack()
                }
            }
        }
        navigation(startDestination = "details/pay_conform", route = "details"){
            composable("details/pay_conform"){
                PaymentConfirmationScreen(
                    loanAmount = "5 Lakhs",
                    instalment = "4th",
                    dateTime = "12 Dec 2023, 1:00 PM"
                ) {
                    navHostController.navigate("details/pay_history")
                }
            }
            composable("details/pay_history"){
                PaymentHistoryScreen(paymentList = getSamplePaymentHistory()) {
                    navHostController.navigate("details/rate_us")
                }
            }
            composable("details/rate_us"){
                RateAppScreen {

                }
            }
        }
    }
}