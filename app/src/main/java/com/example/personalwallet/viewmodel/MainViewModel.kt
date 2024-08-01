package com.example.personalwallet.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

data class FinancialSummaryState (
    val totalIncome: Double = 0.0,
    val totalExpense: Double = 0.0,
    val totalBalance: Double = 0.0
)

class MainViewModel: ViewModel() {
    private val _financialSummaryState = MutableStateFlow<FinancialSummaryState>(FinancialSummaryState())
    val financialSummaryState: StateFlow<FinancialSummaryState> = _financialSummaryState
    fun updateIncoming(incoming: Double) {
        val currentState = _financialSummaryState.value
        _financialSummaryState.value = currentState.copy(totalIncome = incoming)
    }
    fun updateExpense(expense: Double) {
        val currentState = _financialSummaryState.value
        _financialSummaryState.value = currentState.copy(totalExpense = expense)
    }
}