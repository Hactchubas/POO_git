package Q5.user_account

import Q5.transactions.Transaction
import java.time.LocalDateTime

interface Account {
    val id: String
    val user: User
    var balance: Double
    val createdAt: LocalDateTime
    val accountType: AccountType

    fun getStatement(): List<Transaction>

    fun addTransaction(transaction: Transaction): Boolean
    fun deposit(amount: Double)
    fun withdraw(amount: Double)
}

enum class AccountType {
    CHECKING,
    SAVINGS
}