import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {

    public static void main(String[] args) throws IOException {

    	 double n1=0, n2=0, n3=0, media = 0;
         String NF = null;
        
        ServerSocket servidor = new ServerSocket(2222);
        
		Socket cliente = servidor.accept();

        System.out.println("conexao com o cliente " + cliente.getInetAddress().getHostAddress());


        ObjectOutputStream resultado = new ObjectOutputStream(cliente.getOutputStream());
        ObjectInputStream dados = new ObjectInputStream(cliente.getInputStream());

        n1 = dados.readDouble();
        n2 = dados.readDouble();
        
        media = (n1 + n2)/2;
        
        if( media >= 7){
        	
        	NF = " foi aprovado";
        	
        }else if( media < 7 && media > 3  ){
        	
            
            System.out.println(null,"Caso não aprovado realize a N3");
            n3 = Double.parseDouble(System.out.println("Digite a terceira nota: "));
        	
            if((media+n3)/2 >=5){

            	NF = " foi aprovado";
            	
            }else if ((media+n3)/2 < 5){
            	
            	NF = " não foi aprovado";
            }
            
        	
        } else {
        	
        	NF= " não foi aprovado";
        	
        }

        resultado.writeUTF(NF);
        resultado.flush();

        resultado.close();
        dados.close();
        servidor.close();
    }
}