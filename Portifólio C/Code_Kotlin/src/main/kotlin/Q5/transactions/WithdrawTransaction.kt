package Q5.transactions

import Q5.user_account.Account
import Q5.utilities.NotificationService
import Q5.utilities.TransactionResult
import java.text.SimpleDateFormat

class WithdrawTransaction(
    amount: Double,
    sourceAccount: Account
) : BaseTransaction(amount, sourceAccount) {

    override fun process(){
        sourceAccount.addTransaction(this)
        if (!validate()) {
            status = TransactionStatus.FAILED
            return
        }
        sourceAccount.withdraw(amount)
        status = TransactionStatus.SUCCESS
        logger.info("WithdrawTransaction successful: $amount withdrawn from account ${sourceAccount.id}")
        NotificationService.notify(sourceAccount.user, "Saque de $amount realizado com sucesso.")

    }

    override fun toString(): String {
        return "    Withdraw of $amount on $date: $status"
    }

    override fun rollback() {
        sourceAccount.deposit(amount)
        status = TransactionStatus.ROLLED_BACK
        logger.info("WithdrawTransaction rolled back: $amount returned to account ${sourceAccount.id}")
        sourceAccount.addTransaction(this)
    }
}
