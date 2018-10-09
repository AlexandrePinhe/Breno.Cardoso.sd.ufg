
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class Cliente {

    public static void main(String[] args) throws UnknownHostException, IOException {
        double n1=0, n2=0;
        String Nome;
        
        Socket cliente = new Socket("127.0.0.1", 2222);


        ObjectInputStream resultado = new ObjectInputStream(cliente.getInputStream());
        ObjectOutputStream dados = new ObjectOutputStream(cliente.getOutputStream());

    	Nome = system.out.println("Qual nome do Aluno(a)?");
        n1 = Double.parseDouble(system.out.println("Primeira nota: "));
        n2 = Double.parseDouble(system.out.println("Segunda nota: "));


        
        dados.writeDouble(n1);
        dados.writeDouble(n2);
     
        dados.flush();
        
        	
        String NF = resultado.readUTF();
        	
        	system.out.println("Aluno: " + Nome +  NF);
        
        	resultado.close();
        	dados.close();
        	cliente.close();
        
        }
    }