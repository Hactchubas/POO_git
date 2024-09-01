package Q5

import Q5.transactions.TransactionFactory
import Q5.transactions.TransactionType
import Q5.user_account.*
import Q5.utilities.BillDetails
import java.time.LocalDate

class Q5 {

    // Lista para armazenar usuários e contas criadas no sistema
    private val users: MutableList<User> = mutableListOf()
    private val accounts: MutableList<Account> = mutableListOf()

    // Função para criar um novo usuário
    fun createUser(id: String, name: String, email: String, phoneNumber: String): User {
        val user = User(id, name, email, phoneNumber)
        users.add(user)
        println("User created: $name")
        return user
    }

    // Função para criar uma nova conta
    fun createAccount(user: User, accountType: AccountType, initialBalance: Double): Account {
        val account: Account = when (accountType) {
            AccountType.CHECKING -> CheckingAccount(user, initialBalance)
            AccountType.SAVINGS -> SavingsAccount(user, initialBalance)
         }
        accounts.add(account)
        println("Account created: ${account.id} for user ${user.name}")
        return account
    }

    // Função para executar uma transação genérica
    fun executeTransaction(transactionType: TransactionType, amount: Double, sourceAccount: Account, destinationAccount: Account? = null, billDetails: BillDetails? = null) {
        val transaction = TransactionFactory.createTransaction(transactionType, amount, sourceAccount, destinationAccount, billDetails)
        transaction.process()
    }

    // Função para aplicar juros em contas de poupança
    fun applyInterest(account: Account) {
        if (account is SavingsAccount) {
            account.applyInterest()
        } else {
            println("Interest application failed: Account is not a savings account.")
        }
    }

    // Função para visualizar o extrato de uma conta
    fun printStatement(account: Account) {
        val statement = account.getStatement()
        println("Statement for account ${account.id}:")
        statement.forEach {
            println(it)
        }
    }
}

fun main() {
    // Instância do sistema financeiro
    val financialSystem = Q5()

    // Criação de usuários
    val userJohn = financialSystem.createUser("user1", "John Doe", "john@example.com", "123456789")
    val userJane = financialSystem.createUser("user2", "Jane Smith", "jane@example.com", "987654321")

    // Criação de contas
    val johnCheckingAccount = financialSystem.createAccount(userJohn, AccountType.CHECKING, 1000.0)
    val janeSavingsAccount = financialSystem.createAccount(userJane, AccountType.SAVINGS, 5000.0)

    // Execução de transações
    financialSystem.executeTransaction(TransactionType.DEPOSIT, 500.0, johnCheckingAccount)
    financialSystem.executeTransaction(TransactionType.TRANSFER, 200.0, johnCheckingAccount, destinationAccount = janeSavingsAccount)
    financialSystem.executeTransaction(TransactionType.TRANSFER, 2000.0, johnCheckingAccount, destinationAccount = janeSavingsAccount)

    // Pagamento de fatura
    val billDetails = BillDetails("bill123", LocalDate.now().plusDays(5), "Electric Company")
    financialSystem.executeTransaction(TransactionType.BILL_PAYMENT, 150.0, johnCheckingAccount, billDetails = billDetails)

    // Aplicação de juros na conta poupança
    financialSystem.applyInterest(janeSavingsAccount)

    // Visualização do extrato
    financialSystem.printStatement(johnCheckingAccount)
    financialSystem.printStatement(janeSavingsAccount)
}
