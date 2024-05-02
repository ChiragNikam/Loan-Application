package com.task.loanapplication.domain

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel: ViewModel() {
    private var _selectedLoan = MutableStateFlow("")
    val selectedLoan get() = _selectedLoan

    private var _isLivingOnRent = MutableStateFlow(false)
    val isLivingOnRent get() = _isLivingOnRent

    fun updateSelectedLoan(loan: String){
        _selectedLoan.value = loan
    }

    fun updateOnRent(value: Boolean){
        _isLivingOnRent.value = value
    }
}