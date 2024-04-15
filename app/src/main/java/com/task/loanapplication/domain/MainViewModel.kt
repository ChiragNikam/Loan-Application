package com.task.loanapplication.domain

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainViewModel: ViewModel() {
    private var _selectedLoan = MutableStateFlow("")
    val selectedLoan get() = _selectedLoan

    fun updateSelectedLoan(loan: String){
        _selectedLoan.value = loan
    }
}