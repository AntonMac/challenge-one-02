
package Dados;

import Modelos.Moeda;
import java.util.ArrayList;

/**
 *
 * @author Antonio Macena
 * 20/04/2024
 */
public class RepositorioMoedas {
    
    private ArrayList<Moeda> moedas;

    public RepositorioMoedas() {
        this.moedas = new ArrayList<Moeda>();
    }
  
    public Moeda buscaMoeda(String codigo) {
        for(Moeda m: this.moedas){
            if(m.codigo().equalsIgnoreCase(codigo)){
                return m;
            }
        }
        return null;
    }
  
    public void insereMoeda(Moeda moeda) {
        this.moedas.add(moeda);
    }
    
    public void limparRepositorio(){
        this.moedas.clear();
    }
 
    
}
