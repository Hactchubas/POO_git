package Q5.utilities

class Log {

    // Método para registrar mensagens de informação
    fun info(message: String) {
        println("INFO: $message")
    }

    // Método para registrar mensagens de erro
    fun error(message: String) {
        println("ERROR: $message")
    }

    // Método para registrar mensagens de aviso
    fun warn(message: String) {
        println("WARN: $message")
    }

    // Método para registrar mensagens de debug
    fun debug(message: String) {
        println("DEBUG: $message")
    }

    // Método para registrar mensagens customizadas
    fun custom(level: String, message: String) {
        println("$level: $message")
    }
}
