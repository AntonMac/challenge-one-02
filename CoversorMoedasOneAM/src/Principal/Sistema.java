package Principal;

import Dados.RepositorioConversoes;
import Dados.RepositorioMoedas;
import Modelos.Conversao;
import Modelos.Moeda;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Antonio Macena 20/04/2024
 */
public class Sistema {

    static RepositorioMoedas moedas = new RepositorioMoedas();
    static RepositorioConversoes conversoes = new RepositorioConversoes();

    public static Moeda recebeMoeda(String codigoBase) throws IOException,
            InterruptedException {

        String endereco = "https://v6.exchangerate-api.com/v6/"
                + "71bb8d07ca989c44b0863181/latest/"
                + codigoBase;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        JsonObject jsonTaxas = gson.fromJson(response.body(), JsonObject.class);

        return new Moeda(codigoBase, jsonTaxas
                .getAsJsonObject("conversion_rates"));
    }

    private static double coletaValor() {
        Scanner s = new Scanner(System.in);
        System.out.println("Digite o valor que deseja converter: ");
        return Double.parseDouble(s.nextLine());
    }

    public static void converteValorBA(Moeda moeda, String codigoAlvo) throws
            IOException, InterruptedException {
        double valor = coletaValor();
        double valorConvertido = moeda.converteValor(codigoAlvo, valor);

        conversoes.insereConversao(new Conversao(moeda.codigo(), codigoAlvo,
                valor, valorConvertido, getDataHora()));

        String saida = String.format("Valor %.2f [%s] corresponde ao valor "
                + "final de =>>> %.2f [%s]", valor, moeda.codigo(),
                valorConvertido, codigoAlvo);

        System.out.println(saida);
    }

    public static Moeda verificaMoeda(String codigoMoeda) throws IOException,
            InterruptedException {
        Moeda m = moedas.buscaMoeda(codigoMoeda);
        if (m != null) {
            return m;
        }
        m = recebeMoeda(codigoMoeda);
        moedas.insereMoeda(m);
        return m;
    }

    public static String getDataHora() {

        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("dd/MM/yyyy - HH:mm:ss");
        return LocalDateTime.now().format(formatter);

    }

    public static void mostrarHistoricoSessao() {
        System.out.println("\nHistórico de Conversões:");
        for (String s : Sistema.conversoes.listagem()) {
            System.out.println(s);
        }
    }

    public static boolean exibeArquivo(String caminho) {

        try {
            File arquivo = new File(caminho);
            Scanner s = new Scanner(arquivo);
            while (s.hasNextLine()) {
                String linha = s.nextLine();
                System.out.println(linha);
            }
            s.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("\nErro: Arquivo não encontrado!");
        }
        return false;
    }
    
    public static void escolhePorCodigo() throws IOException, InterruptedException {
        if(!exibeArquivo("Codes-API-BR.txt")){
            return;
        }
        Scanner s = new Scanner(System.in);
        System.out.println("\nDigite o código da Moeda Base: ");
        String base = s.nextLine();
        System.out.println("\nDigite o código da Moeda Alvo: ");
        String alvo = s.nextLine();
        converteValorBA(verificaMoeda(base.toUpperCase()), alvo.toUpperCase());
           
    }
    
    public static void exportaLogs() {
        
        DateTimeFormatter formatter = DateTimeFormatter
                .ofPattern("yyyyMMdd_HHmmss");
        
        String s = String.format("Log_conversoes_[%s].csv",
                  LocalDateTime.now().format(formatter));
        
        conversoes.exportarLogCSV(s);
        System.out.println("\nLogs Exportados!");
    }
    
    public static void limparCacheMoedas(){
        moedas.limparRepositorio();
        System.out.println("\nCache Limpo!");
    }

}
