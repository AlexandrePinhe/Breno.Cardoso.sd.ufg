import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) throws IOException {

    	int Idade = 0;
        char sexo = 'd';
        char maiorIdade = 'a';
      

        ServerSocket servidor = new ServerSocket(2222);


        Socket cliente = servidor.accept();

        System.out.println("conexao com o cliente " + cliente.getInetAddress().getHostAddress());


        ObjectOutputStream resultado = new ObjectOutputStream(cliente.getOutputStream());
        ObjectInputStream dados = new ObjectInputStream(cliente.getInputStream());

        Idade = dados.readInt();
        sexo = dados.readChar();
        

        if (sexo == 'm' || sexo == 'M') {
        	
        	if (Idade < 18){
        		
        		maiorIdade = 'N';
        				
        	}else 
        	
        	{
        		maiorIdade = 'S';
        	}

        } else if (sexo == 'f' || sexo == 'F') {
        	
        	if (Idade < 21){
        		
        		maiorIdade = 'N';
        		
        	}else 
        	
        	{
        		maiorIdade = 'S';
        	}
        
        }

        resultado.writeChar(maiorIdade);
        resultado.flush();

        resultado.close();
        dados.close();
        servidor.close();
    }
}