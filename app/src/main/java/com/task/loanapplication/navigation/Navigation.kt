package com.task.loanapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.task.loanapplication.data.util.User
import com.task.loanapplication.domain.MainViewModel
import com.task.loanapplication.presentation.auth.LoginScreen
import com.task.loanapplication.presentation.auth.RegistrationScreen
import com.task.loanapplication.presentation.auth.UploadDocumentsScreen
import com.task.loanapplication.presentation.details.PaymentConfirmationScreen
import com.task.loanapplication.presentation.details.PaymentHistoryScreen
import com.task.loanapplication.presentation.details.RateAppScreen
import com.task.loanapplication.presentation.details.getSamplePaymentHistory
import com.task.loanapplication.presentation.home.HomeScreen
import com.task.loanapplication.presentation.home.LoanDetailsScreen
import com.task.loanapplication.presentation.loan.SelectLoanAmountScreen
import com.task.loanapplication.presentation.loan.TermsAndConditionsScreen
import com.task.loanapplication.presentation.payment.QRCodeScreen
import com.task.loanapplication.presentation.payment.RepaymentOptionScreen
import com.task.loanapplication.presentation.home.RepaymentScheduleScreen
import com.task.loanapplication.presentation.home.UserProfileScreen
import com.task.loanapplication.presentation.home.getListOfSchedulePayment

@Composable
fun NavigationForApp(
    navHostController: NavHostController,
    viewModel: MainViewModel
) {
    NavHost(navController = navHostController, startDestination = "auth") {
        navigation(startDestination = "auth/login", route = "auth") {
            composable("auth/login") {
                LoginScreen(onLoginClick = {
                    navHostController.navigate("home")
                }) {
                    navHostController.navigate("auth/register")
                }
            }
            composable("auth/register") {
                RegistrationScreen {
                    navHostController.navigate("auth/upload_docs")
                }
            }
            composable("auth/upload_docs") {
                UploadDocumentsScreen {
                    navHostController.navigate("loan")
                }
            }
        }
        navigation(startDestination = "loan/amount", route = "loan") {
            composable("loan/amount") {
                SelectLoanAmountScreen(viewModel = viewModel, onNext = {
                    navHostController.navigate("loan/t_and_c")
                })
            }
            composable("loan/t_and_c") {
                TermsAndConditionsScreen {
                    navHostController.navigate("payment")
                }
            }
        }
        navigation(startDestination = "payment/repayment", route = "payment") {
            composable("payment/repayment") {
                RepaymentOptionScreen (viewModel = viewModel){
                    navHostController.navigate("payment/qr_code")
                }
            }
            composable("payment/qr_code") {
                QRCodeScreen(onDoneClick = {
                    navHostController.navigate("home")
                }) {
                    navHostController.popBackStack()
                }
            }
        }
        navigation(startDestination = "details/pay_conform", route = "details") {
            composable("details/pay_conform") {
                PaymentConfirmationScreen(
                    loanAmount = "5 Lakhs",
                    instalment = "4th",
                    dateTime = "12 Dec 2023, 1:00 PM"
                ) {
                    navHostController.navigate("home/options")
                }
            }
            composable("details/pay_history") {
                PaymentHistoryScreen(paymentList = getSamplePaymentHistory())
            }
            composable("details/rate_us") {
                RateAppScreen {}
            }
        }
        // after login
        navigation(startDestination = "home/options", route = "home") {
            composable("home/options") {
                HomeScreen(navController = navHostController)
            }
            composable("home/repayment_schedule") {
                RepaymentScheduleScreen(repaymentSchedule = getListOfSchedulePayment()) {
                    navHostController.navigate("home/options")
                }
            }
            composable("home/user_profile") {
                UserProfileScreen(
                    user = User(
                        name = "John Doe",
                        phoneNo = "1234567890",
                        address = "123 Main Street, City, Country",
                        panNumber = "ABCDE1234F",
                        aadharNumber = "1234 5678 9012",
                        electricBillNo = "EB1234567890",
                        bankName = "ABC Bank"
                    )
                )
            }
            composable("home/loan_details") {
                LoanDetailsScreen(
                    loanSanctioned = "4 Dec 2018",
                    loanDistributedDate = "8 Dec 2018",
                    loanEndDate = "9 Dec 2030"
                ) {

                }
            }
        }
    }
}