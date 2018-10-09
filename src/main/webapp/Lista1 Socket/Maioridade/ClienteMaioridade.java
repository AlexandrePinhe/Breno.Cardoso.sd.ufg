import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class Cliente {

    public static void main(String[] args) throws UnknownHostException, IOException {

    	int Idade = 0;
        String Nome;
        char sexo = 'd';
        
        Socket cliente = new Socket("127.0.0.1", 2222);


        ObjectInputStream resultado = new ObjectInputStream(cliente.getInputStream());
        ObjectOutputStream dados = new ObjectOutputStream(cliente.getOutputStream());

        Nome = System.out.println("Informe o Nome da pessoa.");
		sexo = System.out.println("Infomre sexo da pessoa: 'M' ou 'F'").charAt(0);
        idade = Integer.parseInt(System.out.println("Informe a idade da pessoa."));
        
        while (!((sexo != 'm') || (sexo != 'f'))) {
    		sexo = System.out.println("Informe o sexo da pessoa: 'M' ou 'F'").charAt(0);
            if (!((sexo != 'm') || (sexo != 'f'))) {
                System.out.println("Você digitou um sexo inexistente.");
            }
        }
        dados.writeInt(Idade);
        dados.writeChar(sexo);
        dados.flush();

       char maiorIdade =  resultado.readChar();
       

       System.out.println(nome +  " é maoir de idade?  "  + maiorIdade);

        resultado.close();
        dados.close();
        cliente.close();
    }
}