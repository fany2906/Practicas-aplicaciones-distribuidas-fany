package rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try {
            // Crear el objeto remoto
            Sumador operaciones = new SumadorImpl();

            // Registrar el objeto remoto en el registro RMI
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Operaciones", operaciones);

            System.out.println("Servidor listo...");
        } catch (Exception e) {
            System.err.println("Excepción en el servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}