package Q5.transactions

import Q5.user_account.Account
import Q5.utilities.NotificationService
import Q5.utilities.TransactionResult
import java.text.SimpleDateFormat

class TransferTransaction(
    amount: Double,
    sourceAccount: Account,
    private val destinationAccount: Account
) : BaseTransaction(amount, sourceAccount) {

    override fun validate(): Boolean {
        if (!super.validate()) return false
        if (sourceAccount.id == destinationAccount.id) {
            logger.error("TransferTransaction validation failed: source and destination accounts are the same.")
            return false
        }
        return true
    }

    override fun process() {
        sourceAccount.addTransaction(this)
        destinationAccount.addTransaction(this)
        if (!validate()) {
            status = TransactionStatus.FAILED
            return
        }
        sourceAccount. withdraw(amount)
        destinationAccount.deposit(amount)
        status = TransactionStatus.SUCCESS
        logger.info("TransferTransaction successful: $amount transferred from ${sourceAccount.id} to ${destinationAccount.id}")
        NotificationService.notify(sourceAccount.user, "Transferência de $amount para a conta ${destinationAccount.id} realizada com sucesso.")
        NotificationService.notify(destinationAccount.user, "Recebimento de $amount da conta ${sourceAccount.id}.")

    }

    override fun toString(): String {
        return "    Transfer of $amount to ${destinationAccount.user.name} on $date: $status "
    }

    override fun rollback(){
        sourceAccount.deposit(amount)
        destinationAccount.withdraw(amount)
        status = TransactionStatus.ROLLED_BACK
        logger.info("TransferTransaction rolled back: $amount returned from ${destinationAccount.id} to ${sourceAccount.id}")
        sourceAccount.addTransaction(this)
        destinationAccount.addTransaction(this)
    }
}
