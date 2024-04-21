
package Modelos;

/**
 *
 * @author Antonio Macena
 * 20/04/2024
 */
public record Conversao(String moedaBase, String moedaAlvo, double valorInicial,
        double valorFinal, String dataHora) {

    @Override
    public String toString() {
        return String.format("Valor %.2f [%s] foi convertido no valor final "
                + "de =>>> %.2f [%s] em [%s]",
                valorInicial, moedaBase, valorFinal, moedaAlvo, dataHora);
    }
}
