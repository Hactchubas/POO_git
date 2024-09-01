package Q5.transactions

import Q5.user_account.Account
import Q5.utilities.BillDetails

object TransactionFactory {
    fun createTransaction(
        transactionType: TransactionType,
        amount: Double,
        sourceAccount: Account,
        destinationAccount: Account? = null,
        billDetails: BillDetails? = null
    ): Transaction {
        return when (transactionType) {
            TransactionType.DEPOSIT -> DepositTransaction(amount, sourceAccount)
            TransactionType.WITHDRAW -> WithdrawTransaction(amount, sourceAccount)
            TransactionType.TRANSFER -> {
                if (destinationAccount == null) throw IllegalArgumentException("Destination account is required for transfer.")
                TransferTransaction(amount, sourceAccount, destinationAccount)
            }
            TransactionType.BILL_PAYMENT -> {
                if (billDetails == null) throw IllegalArgumentException("Bill details are required for bill payment.")
                BillPaymentTransaction(amount, sourceAccount, billDetails)
            }
        }
    }
}

enum class TransactionType {
    DEPOSIT,
    WITHDRAW,
    TRANSFER,
    BILL_PAYMENT
}

enum class TransactionStatus {
    FAILED,
    SUCCESS,
    ROLLED_BACK,
    PENDING
}
