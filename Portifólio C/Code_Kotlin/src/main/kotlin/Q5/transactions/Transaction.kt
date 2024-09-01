package Q5.transactions

import Q5.user_account.Account
import Q5.utilities.TransactionResult
import java.time.LocalDateTime

// Definição da interface Transaction
interface Transaction {
    val id: String
    val amount: Double
    val date: LocalDateTime
    val sourceAccount: Account
    val status: TransactionStatus

    fun validate(): Boolean
    fun process()
    fun rollback()
}



