package Q5.transactions

import Q5.user_account.Account
import Q5.utilities.Log
import Q5.utilities.TransactionResult
import java.time.LocalDateTime
import java.util.*

abstract class BaseTransaction(
    override val amount: Double,
    override val sourceAccount: Account
) : Transaction {

    override val id: String = UUID.randomUUID().toString()
    override val date: LocalDateTime = LocalDateTime.now()
    override var status: TransactionStatus = TransactionStatus.PENDING

    protected val logger = Log()

    override fun validate(): Boolean {
        if (amount <= 0) {
            logger.error("Transaction validation failed: amount must be greater than zero.")
            return false
        }
        if (sourceAccount.balance < amount) {
            logger.error("Transaction validation failed: insufficient funds.")
            return false
        }
        return true
    }

    abstract override fun rollback()
    abstract override fun process()

    abstract override fun toString(): String
}
