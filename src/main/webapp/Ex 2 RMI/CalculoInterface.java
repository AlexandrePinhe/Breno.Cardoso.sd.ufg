package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculoInterface extends  Remote {

 String VerificaIdade(String nome, String sexo, int idade) throws RemoteException;

}
