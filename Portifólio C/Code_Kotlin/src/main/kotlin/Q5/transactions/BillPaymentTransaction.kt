package Q5.transactions

import Q5.user_account.Account
import Q5.utilities.BillDetails
import Q5.utilities.ExternalPaymentService
import Q5.utilities.NotificationService
import Q5.utilities.TransactionResult
import java.text.SimpleDateFormat

class BillPaymentTransaction(
    amount: Double,
    sourceAccount: Account,
    private val billDetails: BillDetails
) : BaseTransaction(amount, sourceAccount) {

    override fun process(){
        sourceAccount.addTransaction(this)
        if (!validate()) {
            status = TransactionStatus.FAILED
            return
        }
        sourceAccount.withdraw(amount)
        // Simulação de pagamento da fatura
        ExternalPaymentService.payBill(billDetails, amount)
        status = TransactionStatus.SUCCESS
        logger.info("BillPaymentTransaction successful: $amount paid for bill ${billDetails.billId}")
        NotificationService.notify(sourceAccount.user, "Pagamento de fatura ${billDetails.billId} no valor de $amount realizado com sucesso.")

    }

    override fun toString(): String {
        return "    Bill (${billDetails.billId}) of $amount on $date: $status"
    }

    override fun rollback() {
        sourceAccount.deposit(amount)
        // Lógica adicional para estornar pagamento externo
        ExternalPaymentService.refundBill(billDetails, amount)
        status = TransactionStatus.ROLLED_BACK
        logger.info("BillPaymentTransaction rolled back: $amount refunded for bill ${billDetails.billId}")
        sourceAccount.addTransaction(this)
    }
}
