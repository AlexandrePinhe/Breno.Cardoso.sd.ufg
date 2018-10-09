import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class Cliente {

    public static void main(String[] args) throws UnknownHostException, IOException {
        
    	double altura = 0, pesoIdeal = 0;
        char sexo = 'a';
        
        
        Socket cliente = new Socket("127.0.0.1", 1055);


        ObjectInputStream resultado = new ObjectInputStream(cliente.getInputStream());
        ObjectOutputStream dados = new ObjectOutputStream(cliente.getOutputStream());

        altura = Double.parseDouble(System.out.println("Informe a sua altura: "));
		sexo = System.out.println("Informe qual seu sexo: F - Feminino ou M - Masculino").charAt(0);
		
        dados.writeDouble(altura);
        dados.writeChar(sexo);
        dados.flush();
        
        
        double PesoIdeal = resultado.readDouble();
        	
        System.out.println("Seu peso ideal é " + PesoIdeal);
        	
        resultado.close();
        dados.close();
        cliente.close();
        
        }
    }