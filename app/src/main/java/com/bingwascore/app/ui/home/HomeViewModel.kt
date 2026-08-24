package com.bingwascore.app.ui.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

data class DashboardStats(
    val successfulCount: Int = 631,
    val failedCount: Int = 0,
    val tokensRemaining: String = "23h 50min",
    val airtimeUsedToday: String = "Ksh 18,069.00",
    val airtimeBalance: String = "Ksh 30,241.52",
    val weeklyCommission: String = "Ksh 0.00"
)

data class TransactionItem(
    val id: String,
    val customerName: String,
    val bundleName: String,
    val timeAgo: String,
    val amount: String,
    val status: String // "SUCCESS", "PENDING", "FAILED"
)

data class HomeState(
    val stats: DashboardStats = DashboardStats(),
    val recentTransactions: List<TransactionItem> = listOf(
        TransactionItem("1", "HASSAN WARDERE NOOR", "250Mbs, 24hrs!", "2min ago", "Ksh 20", "SUCCESS"),
        TransactionItem("2", "ABIGAEL CHEPNGENO", "250Mbs, 24hrs!", "2min ago", "Ksh 20", "PENDING"),
        TransactionItem("3", "samuel thairu kariuki", "250MBS, 24Hrs Multiple", "3min ago", "Ksh 20", "SUCCESS"),
        TransactionItem("4", "VALENTINE NJERI MWANGI", "250Mbs, 24hrs!", "4min ago", "Ksh 20", "SUCCESS"),
        TransactionItem("5", "Katra Kassim Abdi", "250Mbs, 24hrs!", "5min ago", "Ksh 20", "SUCCESS"),
        TransactionItem("6", "Evaline Achieng Obiero", "250Mbs, 24hrs!", "6min ago", "Ksh 20", "SUCCESS")
    )
)

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state.asStateFlow()
}
