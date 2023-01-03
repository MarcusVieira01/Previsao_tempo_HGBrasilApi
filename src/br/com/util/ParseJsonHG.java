//Declaração de pacote
package br.com.util;

import java.util.ArrayList;
import java.util.List;

//Importação de classes externas
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
//Importação de classes internas
import br.com.model.WeatherActual;
import br.com.model.WeatherForecast;

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
    private List<WeatherForecast> forecastList = new ArrayList<>();
    
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
     * @return
     * @throws ParseException
     */
    public List<WeatherForecast> parseForecast() throws ParseException{
        //Atribuição do valor de retorno do parseamento do atributo jsonIncial para o elemento de forecast
        String[] jsonForecast = (new JsonCut().getJsonForecast(jsonInicial));        
        
        //Iteração via foreach do array jsonForecast
        for (String iterator : jsonForecast) {
            //Instanciamento de objeto via construtor JSONParser();
            JSONParser parser = new JSONParser();
            //Evocação de método do objeto acima instanciado, .parse(json) com cast para o tipo JSONObject
            JSONObject jsonObject = (JSONObject) parser.parse(iterator);

            //Execução do parseamento dos elementos do JSON contido na variável iterator, via método .get(key) do objeto jsonObject
            String date = jsonObject.get("date").toString();
            String weekday = jsonObject.get("weekday").toString();
            String tempMax = jsonObject.get("max").toString();
            String tempMin = jsonObject.get("min").toString();
            String cloudiness = jsonObject.get("cloudiness").toString();
            String rain = jsonObject.get("rain").toString();
            String rainProb = jsonObject.get("rain_probability").toString();
            String wSpeed = jsonObject.get("wind_speedy").toString();
            String description = jsonObject.get("description").toString();
            String condition = jsonObject.get("condition").toString();

            //Declaração de variável e atribuição do objeto instanciado via construtor WeatherForecast
            WeatherForecast forecast = new WeatherForecast(date, weekday, tempMax, tempMin, cloudiness, 
                                                           rain, rainProb, wSpeed, description, condition);
            //Inclusão do objeto construído na variável tipo List
            this.forecastList.add(forecast);
        }

        //Retorno do objeto tipo List
        return forecastList;
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
