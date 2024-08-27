
// Classe abstrata Connection
abstract class Connection {
    protected String deviceName;

    public Connection(String deviceName) {
        this.deviceName = deviceName;
    }

    // Método abstrato para conectar ao dispositivo
    public abstract boolean connect();

    // Método abstrato para desconectar do dispositivo
    public abstract void disconnect();

    // Método concreto para exibir o status da conexão
    public void showStatus(String status) {
        System.out.println("Status da conexão com " + deviceName + ": " + status);
    }
}

// Subclasse para conexão via Bluetooth
class BluetoothConnection extends Connection {
    public BluetoothConnection(String deviceName) {
        super(deviceName);
    }

    @Override
    public boolean connect() {
        // Lógica fictícia para conectar via Bluetooth
        System.out.println("Tentando conectar ao dispositivo " + deviceName + " via Bluetooth...");
        boolean success = true; // Supondo que a conexão foi bem-sucedida
        showStatus(success ? "Conectado via Bluetooth" : "Falha na conexão Bluetooth");
        return success;
    }

    @Override
    public void disconnect() {
        // Lógica fictícia para desconectar via Bluetooth
        System.out.println("Desconectando de " + deviceName + " via Bluetooth...");
        showStatus("Desconectado via Bluetooth");
    }
}

// Subclasse para conexão via Wi-Fi Direct
class WifiDirectConnection extends Connection {
    public WifiDirectConnection(String deviceName) {
        super(deviceName);
    }

    @Override
    public boolean connect() {
        // Lógica fictícia para conectar via Wi-Fi Direct
        System.out.println("Tentando conectar ao dispositivo " + deviceName + " via Wi-Fi Direct...");
        boolean success = true; // Supondo que a conexão foi bem-sucedida
        showStatus(success ? "Conectado via Wi-Fi Direct" : "Falha na conexão Wi-Fi Direct");
        return success;
    }

    @Override
    public void disconnect() {
        // Lógica fictícia para desconectar via Wi-Fi Direct
        System.out.println("Desconectando de " + deviceName + " via Wi-Fi Direct...");
        showStatus("Desconectado via Wi-Fi Direct");
    }
}

// Exemplo de uso no main
public class Q3 {
    public static void main(String[] args) {
        Connection bluetoothConnection = new BluetoothConnection("Speaker");
        Connection wifiDirectConnection = new WifiDirectConnection("Smart TV");

        bluetoothConnection.connect();
        wifiDirectConnection.connect();

        bluetoothConnection.disconnect();
        wifiDirectConnection.disconnect();
    }
}
