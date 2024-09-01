package Q5.user_account

import Q5.transactions.BaseTransaction
import Q5.transactions.Transaction
import Q5.utilities.NotificationService

class CheckingAccount(
    user: User,
    balance: Double = 0.0,
    private val overdraftLimit: Double = 500.0
) : BaseAccount(user, balance) {

    override val accountType: AccountType = AccountType.CHECKING

    override fun withdraw(amount: Double) {
        if (balance + overdraftLimit >= amount) {
            super.withdraw(amount)
        } else {
            logger.error("Withdrawal failed: insufficient funds and overdraft limit reached.")
            NotificationService.notify(user, "Falha no saque: fundos insuficientes.")
        }
    }
}
