
package Principal;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Antonio Macena
 * 21/04/2024
 */

public class ConversorMoedasApp {
    
    static Scanner input = new Scanner(System.in);
   
    public static void main(String[] args) {
        
        int opcao = 0;
        do {

            Menu.menuInicial();
            System.out.print("\nOpção: ");
            try {
                opcao = input.nextInt();
                Menu.menuSeletor(opcao);
            } catch (InputMismatchException ex) {
                System.out.println("Valor digitado Inválido");
                input.nextLine(); // Limpar buffer
            }

        } while (opcao != 0);
        
        input.close();   
    }       
}
