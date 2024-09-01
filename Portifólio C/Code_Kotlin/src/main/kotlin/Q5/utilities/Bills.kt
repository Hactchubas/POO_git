package Q5.utilities

import java.time.LocalDate

object ExternalPaymentService {

    fun payBill(billDetails: BillDetails, amount: Double) {
        // Lógica de pagamento externo
        println("Bill ${billDetails.billId} paid successfully with amount $amount")
    }

    fun refundBill(billDetails: BillDetails, amount: Double) {
        // Lógica de estorno externo
        println("Bill ${billDetails.billId} refunded successfully with amount $amount")
    }
}

data class BillDetails(
    val billId: String,
    val dueDate: LocalDate,
    val recipient: String
)
