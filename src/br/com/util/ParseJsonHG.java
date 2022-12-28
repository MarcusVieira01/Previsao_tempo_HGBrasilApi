//Declaração de pacote
package br.com.util;

//Importação de classes externas
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
//Importação de classes internas
import br.com.model.WeatherActual;

/**
 * @apiNote Classe que realiza o corte do JSON de resposta da requisição HTTP da API HG Brasil, 
 * realiza o parse do trecho referente ao uso da chave, do trecho referente ao clima atual e a 
 * parte sobre o forecast
 */
public class ParseJsonHG {
    /**
     * Declaração de atributos privados. 
     */
    private String jsonInicial;
    
    /**
     * Construtor do objeto ParseJsonHG
     * @param json String contendo o json para parseamento
     */
    public ParseJsonHG(String json){
        this.jsonInicial = json;
    }

    /**
     * Método que evoca o método auxiliar jsonCut e parseia o JSON resultante para construção do 
     * objeto da classe WeatherActual
     * @return Objeto WeatherActual com os atributos atribuídos pelo parseamento
     * @throws ParseException
     */
    public WeatherActual parseActual() throws ParseException{

        //Instanciamento de objeto via construtor JSONParser();
        JSONParser parser = new JSONParser();
        //Evocação de método do objeto acima instanciado, .parse(json) com cast para o tipo JSONObject
        JSONObject jsonObject = (JSONObject) parser.parse(new JsonCut().getJsonActual(this.jsonInicial));
        
        //Parseamento dos elementos contidos no objeto jsonObject
        String date = jsonObject.get("date").toString();
        String time = jsonObject.get("time").toString();
        String temperature = jsonObject.get("temp").toString();
        String humidity = jsonObject.get("humidity").toString();
        String description = jsonObject.get("description").toString();
        String currently = jsonObject.get("currently").toString();
        String city = jsonObject.get("city").toString();
        String cloudiness = jsonObject.get("cloudiness").toString();
        String rain = jsonObject.get("rain").toString();
        String wSpeed = jsonObject.get("wind_speedy").toString();
        String wDirection = jsonObject.get("wind_direction").toString();
        String sunRise = jsonObject.get("sunrise").toString();
        String sunSet = jsonObject.get("sunset").toString();
        String condSlug = jsonObject.get("condition_slug").toString();

        //Construção de objeto da classe WeatherActual com os atributos parseados
        WeatherActual weatherActual = new WeatherActual(temperature, date, time, description, currently, city, 
                                                        humidity, cloudiness, rain, wSpeed, wDirection, sunRise, 
                                                        sunSet, condSlug);

        //Retorno no objeto construído
        return weatherActual;
    }

    /**
     * Método que realiza o parse do trecho forecast do JSON
     * @throws ParseException
     */
    public void parseForecast() throws ParseException{
        //Atribuição do valor de retorno do parseamento do atributo jsonIncial para o elemento de forecast
        String[] jsonForecast = (new JsonCut().getJsonForecast(jsonInicial));
        
        //TRECHO AINDA NÃO IMPLEMENTADO ---> INSTANCIAMENTO DE OBJETOS WEATHERFORECAST E INCLUSÂO EM UM LIST
        for (String string : jsonForecast) {
            //Instanciamento de objeto via construtor JSONParser();
            JSONParser parser = new JSONParser();
            //Evocação de método do objeto acima instanciado, .parse(json) com cast para o tipo JSONObject
            JSONObject jsonObject = (JSONObject) parser.parse(string);

            String weekday = jsonObject.get("weekday").toString();

            System.out.println(weekday); 
        }
    }

    /**
     * Método getter para o atributo keyStatus
     * @return
     * @throws ParseException
     */
    public String parseKeyStatus() throws ParseException {
        //Instanciamento de objeto via construtor JSONParser();
        JSONParser parser = new JSONParser();
        //Evocação de método do objeto acima instanciado, .parse(json) com cast para o tipo JSONObject
        JSONObject jsonObject = (JSONObject) parser.parse(this.jsonInicial);

        //Retorno do valor do elemento valid_key
        return jsonObject.get("valid_key").toString();
    }
}
