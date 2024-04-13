package com.task.loanapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.task.loanapplication.presentation.auth.LoginScreen
import com.task.loanapplication.presentation.auth.RegistrationScreen
import com.task.loanapplication.presentation.auth.UploadDocumentsScreen
import com.task.loanapplication.presentation.loan.SelectLoanAmountScreen
import com.task.loanapplication.presentation.loan.TermsAndConditionsScreen

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

            }
            composable("payment/qr_code") {

            }
        }
        navigation(startDestination = "details/pay_conform", route = "details"){
            composable("details/pay_conform"){

            }
            composable("details/pay_history"){

            }
            composable("details/rate_us"){

            }
        }
    }
}