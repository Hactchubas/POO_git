package Q5.transactions

import Q5.user_account.Account
import Q5.utilities.NotificationService
import Q5.utilities.TransactionResult
import java.text.SimpleDateFormat

// Implementação de depósito
class DepositTransaction(
    amount: Double,
    sourceAccount: Account
) : BaseTransaction(amount, sourceAccount) {

    override fun process() {
        sourceAccount.addTransaction(this)
        if (!validate()) {
            status = TransactionStatus.FAILED
            return
        }
        sourceAccount.deposit(amount)
        status = TransactionStatus.SUCCESS
        logger.info("DepositTransaction successful: $amount deposited to account ${sourceAccount.id}")
        NotificationService.notify(sourceAccount.user, "Depósito de $amount realizado com sucesso.")
    }

    override fun toString(): String {
        return "    Deposit of $amount on $date: $status"
    }

    override fun rollback() {
        sourceAccount.deposit(amount)
        status = TransactionStatus.ROLLED_BACK
        logger.info("WithdrawTransaction rolled back: $amount returned to account ${sourceAccount.id}")

        sourceAccount.addTransaction(this)
    }
}
