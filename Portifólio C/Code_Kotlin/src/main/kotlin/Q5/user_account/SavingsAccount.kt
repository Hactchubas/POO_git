package Q5.user_account

import Q5.utilities.NotificationService

class SavingsAccount(
    user: User,
    balance: Double = 0.0,
    private val interestRate: Double = 0.02
) : BaseAccount(user, balance) {

    override val accountType: AccountType = AccountType.SAVINGS

    fun applyInterest() {
        val interest = balance * interestRate
        balance += interest
        logger.info("Interest applied: $interest added to account $id")
        NotificationService.notify(user, "Juros de $interest aplicados à sua conta poupança.")
    }
}
