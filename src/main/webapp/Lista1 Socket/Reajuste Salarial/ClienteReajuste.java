import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class Cliente {

    public static void main(String[] args) throws UnknownHostException, IOException {
        double salarioNovo = 0;
        int cargo = 0;
        String nome;
        
        Socket cliente = new Socket("127.0.0.1", 2222);


        ObjectInputStream resultado = new ObjectInputStream(cliente.getInputStream());
        ObjectOutputStream dados = new ObjectOutputStream(cliente.getOutputStream());

    	nome = System.out.println("Qual nome do funcionário?");
        salarioNovo = Double.parseDouble(System.out.println("Qual o Salário Atual do Funcionário: "));
        cargo = Integer.parseInt(System.out.println("cargo do funcionário? 1 = Operador, 2 = Programador"));
        
            if (!((cargo >= 1) && (cargo <= 2))) {
                System.out.println("cargo inválid0.");
            }
        
        dados.writeInt(cargo);
        dados.writeDouble(salarioNovo);
        dados.flush();

        double salarioReajuste = resultado.readDouble();

       System.out.println("O Salário do funcionário(a) " + nome + " foi reajustado para: " +  salarioReajuste);

        resultado.close();
        dados.close();
        cliente.close();
    }
}