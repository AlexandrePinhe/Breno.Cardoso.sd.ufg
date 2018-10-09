import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

    public static void main(String[] args) throws IOException {

        double salarioNovo, salarioReajuste =0; 
        int cargo;


        ServerSocket servidor = new ServerSocket(2222);


        Socket cliente = servidor.accept();

        System.out.println("conexao com o cliente " + cliente.getInetAddress().getHostAddress());


        ObjectOutputStream resultado = new ObjectOutputStream(cliente.getOutputStream());
        ObjectInputStream dados = new ObjectInputStream(cliente.getInputStream());

        cargo = dados.readInt();
        salarioNovo = dados.readDouble();

        if (cargo == 1) {

            salarioReajuste = (salarioNovo*1.2);

        } else if (cargo == 2) {

        	salarioReajuste = (salarioNovo*1.18);
        }

        resultado.writeDouble(salarioReajuste);
        resultado.flush();

        resultado.close();
        dados.close();
        servidor.close();
    }
}