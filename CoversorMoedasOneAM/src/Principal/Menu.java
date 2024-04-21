package Principal;

import static Principal.Sistema.verificaMoeda;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antonio Macena
 * 21/04/2024
 */
public class Menu {

    public Menu() {
    }

    public static void menuInicial() {
        System.out.println("\n*****************************************************");
        System.out.println("\n**  Conversor de Moedas - AM - V1.0 **");
        System.out.println("\n*****************************************************");
        System.out.println();
        System.out.println(" 1 - Peso argentino(ARS) =>> Boliviano boliviano (BOB)");
        System.out.println(" 2 - Boliviano boliviano (BOB =>> Peso argentino(ARS)");
        System.out.println(" 3 - Real brasileiro(BRL) =>> Peso chileno (CLP)");
        System.out.println(" 4 - Peso chileno (CLP) =>> Real brasileiro(BRL)");
        System.out.println(" 5 - Peso colombiano (COP) =>> Dólar americano(USD)");
        System.out.println(" 6 - Dólar americano(USD) =>> Peso colombiano (COP)");
        System.out.println(" 7 - Listar Todas as Moedas e Escolher por Código");
        System.out.println(" 8 - Mostrar Histórico de Conversões nesta Sessão");
        System.out.println(" 9 - Exportar Logs de Conversões");
        System.out.println("10 - Limpar o Cache!");
        System.out.println(" 0 - Finalizar");
        System.out.println("\n*****************************************************");
    }

    public static void menuSeletor(int opcao) {
        try {
            switch (opcao) {
                case 1:
                    Sistema.converteValorBA(verificaMoeda("ARS"), "BOB");
                    break;
                case 2:
                    Sistema.converteValorBA(verificaMoeda("BOB"), "ARS");
                    break;
                case 3:
                    Sistema.converteValorBA(verificaMoeda("BRL"), "CLP");
                    break;
                case 4:
                    Sistema.converteValorBA(verificaMoeda("CLP"), "BRL");
                    break;
                case 5:
                    Sistema.converteValorBA(verificaMoeda("COP"), "USD");
                    break;
                case 6:
                    Sistema.converteValorBA(verificaMoeda("USD"), "COP");
                    break;
                case 7:
                    Sistema.escolhePorCodigo();
                    break;
                case 8:
                    Sistema.mostrarHistoricoSessao();
                    break;
                case 9:
                    Sistema.exportaLogs();
                    break;
                case 10:
                    Sistema.limparCacheMoedas();
                    break;
                case 0:
                    System.out.println("\n--- PROGRAMA FINALIZADO");
                    break;
                default:
                    System.out.println("\nOpção incorreta");
            }
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(ConversorMoedasApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
