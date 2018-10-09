import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) throws IOException {

    	double altura =0;
        double PesoIdeal = 0;
        char sexo;
        
         ServerSocket servidor = new ServerSocket(1055);

'		 Socket cliente = servidor.accept();

         System.out.println("conexao com o cliente " + cliente.getInetAddress().getHostAddress());
         
         ObjectOutputStream resultado = new ObjectOutputStream(cliente.getOutputStream());
         ObjectInputStream dados = new ObjectInputStream(cliente.getInputStream());

        sexo = dados.readChar();
        altura = dados.readDouble();
                
        if( sexo == 'F' || sexo == 'f' ){
        	
        	PesoIdeal = ((72.7*altura) - 58);
        	
        }else if( sexo == 'M' || sexo == 'm' ){
        	
        	PesoIdeal = ((62.1*altura) - 44);
        	
        }
        	

        resultado.writeDouble(PesoIdeal);
        resultado.flush();
		resultado.close();
        dados.close();
        servidor.close();
    }
}