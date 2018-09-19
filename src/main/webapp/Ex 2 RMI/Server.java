package RMI;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

public class Server {
	
	static String IP = "10.73.12.247";
	static int PORTA = 1048;
	
	Server() {
		try{
			System.setProperty("java.rmi.server.hostname", IP);
			LocateRegistry.createRegistry(PORTA);
			CalculoInterface cal = new CalculoImple();
			Naming.bind("CalculoService", (Remote) cal);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		new Server();
		System.out.println("Servidor esta em funcionamento ");
	}
	

}
