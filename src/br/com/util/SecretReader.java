//Declaração de pacote
package br.com.util;

//Importação de classes externas
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @author Marcus Vieira
 * @apiNote Classe concreta que modela a secret de acesso à API HG Waather e possui o atributo secret
 */
public class SecretReader {
    //Declaração de atributos privados
    private String secret = "";

    /**
     * Método que buscará a secret da API em um arquivo .txt e atribuirá ao atributo secret
     * @param path String contendo o destino do arquivo que contém as secrets
     */
    private void captureKey(String path){
        //Estrutura try-catch para captura e tratamento de exceções
        try{
            //Instanciação de objeto que conterá o arquivo com a secret da API, onde o caminho é passado em seu parâmetro e contido na variável path
            File arquivo = new File(path);

            //Instanciação de processo de stream do objeto arquivo, que contém o arquivo com a secret de acesso à API HG Weather
            InputStream fileInputStream = new FileInputStream(arquivo);
            Reader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            
            //Atribuição do valor de retorno da leitura do buffer via método .readLine()
            this.secret = bufferedReader.readLine();

            //Evocação de método para encerramento da leitura do buffer
            bufferedReader.close();

        //Cláusulas catch que farão os tratamentos de exceções
        }catch(NullPointerException | FileNotFoundException e){
            //Exibição de mensagem de exceção concatenada
            System.out.println("Arquivo não encontrado.\n" + "Caminho: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Falha de IO.\n" + "Caminho: " + e.getMessage());
        }
    }    

    /**
     * Método getter para retorno do valor do atributo secret
     * @param path String com o caminho do arquivo a ser lido
     * @return String sendo o valor do atributo secret
     */
    public String getKey(String path){
        //Evocação de método interno auxiliar
        captureKey(path);

        //Retorno do valor contido no atributo secret
        return this.secret;
    }
}
