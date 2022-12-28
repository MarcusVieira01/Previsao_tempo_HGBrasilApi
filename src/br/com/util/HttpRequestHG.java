//Declaração de pacote
package br.com.util;

//Importação de classes externas
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author Marcus Vieira
 * @apiNote Classe que realizará o acesso à API HG Weather, utilizando uma chave de acesso lida internamente e conterá o atributo bodyResponse. Esse atributo conterá o body da response da request HTTP. <br><br>
 * O atributo body conterá um JSON os parâmetros do clima atual para a cidade de localização automática pela API, além da previsão climática para 10 dias, incluindo o dia da request HTTP
 */
public class HttpRequestHG {
    //Declaração de atributos privados
    private String bodyResponse;

    /**
     * Declaração de método privado que fará a requisição HTTP para a API HG Weather, usando o caminho da chave de acesso à API passada como argumento
     * @param pathKey String contendo o caminho do arquivo que contém a chave de acesso à API
     */
    private void bodyRequest(String pathKey){
        //Estrutura try-cath que faz o tratamento de exceções
        try{
            //Instanciamento de objeto via construtor URI, passando uma string sendo a URL de requisição concatenada com o valor da chave de acesso da API, obtida via método da classe KeyReader
            URI uri = new URI("https://api.hgbrasil.com/weather?key=" + new SecretReader().getKey(pathKey));
    
            //Fluxo de requisição HTTP que isntancia um client, uma request e uma response, esta última faz o envio da request e usa um manipulador de corpo de resposta da requisição, transformando em String
            HttpClient cliente = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
            HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
    
            //Atribui o valor de restorno do body à variável body
            this.bodyResponse = response.body();

        //Tratamento de exceções via catch
        }catch(NullPointerException | UncheckedIOException | IllegalArgumentException | IOException | InterruptedException | URISyntaxException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }

    /**
     * Declaração de método getter para retorno do valor do atributo body
     * @param pathKey String contendo o caminho do arquivo que contém a chave de acesso à API
     * @return String contendo o JSON do bpdy de response da HTTP request
     */
    public String getBodyResponse(String pathKey){
        //Evocação de método interno auxiliar, que fará a requisição HTTP para a API HG Weather
        bodyRequest(pathKey);

        //Retorno do valor do atributo body
        return this.bodyResponse;
    }
}
