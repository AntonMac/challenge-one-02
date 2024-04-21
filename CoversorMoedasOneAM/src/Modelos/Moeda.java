
package Modelos;
import com.google.gson.JsonObject;
/**
 *
 * @author Antonio Macena
 * 20/04/2024
 */
public record Moeda(String codigo, JsonObject taxasConversao) {
    
    public double coletaTaxaConversao(String codigoAlvo){
        
        return this.taxasConversao.get(codigoAlvo).getAsDouble();
        
    }
    
    public double converteValor(String codigoAlvo, double valor){
        
        return valor * this.taxasConversao.get(codigoAlvo).getAsDouble();
        
    }
    
}
