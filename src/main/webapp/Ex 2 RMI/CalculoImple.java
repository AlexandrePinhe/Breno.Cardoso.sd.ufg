package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculoImple extends UnicastRemoteObject implements CalculoInterface {
	String nome, sexo;
	int idade = 0;

	protected CalculoImple() throws RemoteException{
			super();
		}
		
		public String VerificaIdade(String nome, String sexo, int idade, String status) throws RemoteException{
			switch (sexo){
	        case "M":
		        if(idade < 18){
			        status = "menor de Idade";
	        	}
	        	else{
	        		 status = "maior de idade";
	        	}
	        break;
	        case "F":
	        	if(idade < 21){
			        status = "menor de idade";
	        	}
	        	else{
	        		 status = "maior de idade";
	        	}
	        }
			return status;
			
			
			
			
		}

		@Override
		public String VerificaIdade(String nome, String sexo, int idade) throws RemoteException {
			// TODO Auto-generated method stub
			return null;
		}

}
