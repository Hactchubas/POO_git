package Q5.user_account

import Q5.transactions.DepositTransaction
import Q5.transactions.Transaction
import Q5.transactions.WithdrawTransaction
import Q5.utilities.Log
import java.time.LocalDateTime
import java.util.*

abstract class BaseAccount(
    override val user: User,
    override var balance: Double
) : Account {
    override val id: String = UUID.randomUUID().toString()
    override val createdAt: LocalDateTime = LocalDateTime.now()
    protected val transactions: MutableList<Transaction> = mutableListOf()
    protected val logger = Log()
    override fun deposit(amount: Double) {
        balance += amount
    }

    override fun withdraw(amount: Double) {
        balance -= amount
    }

    override fun getStatement(): List<Transaction> {
        return transactions.toList()
    }
    override fun addTransaction(transaction: Transaction): Boolean{
        return transactions.add(transaction)
    }
}
