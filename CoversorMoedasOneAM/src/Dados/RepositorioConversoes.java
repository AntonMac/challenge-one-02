
package Dados;

import Modelos.Conversao;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Antonio Macena
 * 21/04/2024
 */
public class RepositorioConversoes {
    
    private ArrayList<Conversao> conversoes;

    public RepositorioConversoes() {
        this.conversoes = new ArrayList<Conversao>();
    }

    
    public Conversao buscaConversao(String codigo) {
        for(Conversao c: this.conversoes){
            if(c.moedaBase().equalsIgnoreCase(codigo)){
                return c;
            }
        }
        return null;
    }

    
    public void insereConversao(Conversao conversao) {
        this.conversoes.add(conversao);
    }
    
    public ArrayList<String> listagem(){
        ArrayList<String> lista = new ArrayList<>();
        for(Conversao c : conversoes){
            lista.add(c.toString());
        }
        return lista;
    } 
    
    public void limparRepositorio(){
        this.conversoes.clear();
    }
    
    public void exportarLogCSV(String arquivo) {
        try {
            FileWriter temp = new FileWriter(arquivo);

            temp.write("Moeda Base,Moeda Alvo,Valor Inicial,Valor Final,"
                    + "Data/Hora\n");

            for (Conversao conversao : conversoes) {
                String linha = String.format("%s,%s,%.2f,%.2f,%s\n", 
                        conversao.moedaBase(), conversao.moedaAlvo(), 
                        conversao.valorInicial(), conversao.valorFinal(), 
                        conversao.dataHora());
                temp.write(linha);
            }
            temp.close();
            System.out.println("Logs de conversão exportados para o arquivo " 
                    + arquivo);

        } catch (IOException e) {
            System.out.println("Erro ao exportar os logs de conversão para "
                    + "o arquivo " 
                    + arquivo);
        }
    }
    
}
