package RMI;

import java.rmi.Naming;
import java.util.Scanner;


public class Client {
	
	public static void main(String args[]){
		 
		 String nome,sexo;
		 int idade = 0;
		 
		 try{
		   CalculoInterface cal = (CalculoInterface) Naming.lookup("rmi://127.0.0.1:1048/CalculoService");
			  
						System.out.println("Informe o nome do usuario: \n");
		                Scanner scan;
						nome = scan.nextLine();
		                System.out.println("Informe o sexo do usuario (F ou M): \n");
		                sexo = scan.nextLine();
		                System.out.println("Informe a idade do usuario: \n");
		                idade = scan.nextInt();
					
					cal.VerificaIdade(nome, sexo, idade);
		            
					System.out.println(VerificaIdade);
					
					  }
		            catch(Exception e){
		                  e.printStackTrace();
		            }
		      }

}
