//Declaração de pacote
package br.com.model;

//Importação de classes externas
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * @apiNote Classe que realiza o corte do JSON de resposta da requisição HTTP da API HG Brasil, realiza o parse do trecho referente ao uso da chave, do trecho referente ao clima atual e a parte sobre o forecast
 */
public class ParseJsonHG {
    /**
     * Declaração de atributos privados. 
     */
    private String jsonInicial;
    private String jsonActual;
    private String[] jsonForecast;
    private String keyStatus;

    
    /**
     * Construtor do objeto ParseJsonHG
     * @param json String contendo o json para parseamento
     */
    public ParseJsonHG(String json){
        this.jsonInicial = json;
    }

    /**
     * Método que realiza o corte do json para os trechos que compõe o clima atual, o forecast e o retorno do uso da chave; 
     */
    private void jsonCut(){
        //Atribuição do valor do atributo jsonInicial à variável local json
        String json = this.jsonInicial;

        //Corte para limpeza e separação dos conteúdos actual e forecast
        String[] corteJsonInicial = (json.split("\"results\":"))[1].split(",\"forecast\":");

        //Separação do trecho do clima Actual e atribuição ao atributo específico
        this.jsonActual = corteJsonInicial[0] + "}";

        //
        String[] corteForecast1 = corteJsonInicial[1].split("],\"cref\"");

        String corteForecast2 = corteForecast1[0].replace("[", "");

        String[] corteForecast3 = corteForecast2.split("\\},\\{");

        corteForecast3[0] = corteForecast3[0].replaceAll("\\{", "");
        corteForecast3[9] = corteForecast3[9].replaceAll("\\}", "");

        for(int i = 0; i < corteForecast3.length; i++){
            corteForecast3[i] = "{" + corteForecast3[i] + "}";
        }

        this.jsonForecast = corteForecast3;


    }

    /**
     * Método que evoca o método auxiliar jsonCut e parseia o JSON resultante para construção do objeto da classe WeatherActual
     * @return Objeto WeatherActual com os atributos atribuídos pelo parseamento
     * @throws ParseException
     */
    public WeatherActual parseActual() throws ParseException{
        //Evocação de método interno que fará o corte do body do HttpResponse
        jsonCut();

        //Declaração de variável local e inicialização dom o valor do atributo homônimo
        String jsonActual = this.jsonActual;

        //Instanciamento de objeto via construtor JSONParser();
        JSONParser parser = new JSONParser();
        //Evocação de método do objeto acima instanciado, .parse(json) com cast para o tipo JSONObject
        JSONObject jsonObject = (JSONObject) parser.parse(jsonActual);
        
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
        WeatherActual weatherActual = new WeatherActual(temperature, date, time, description, currently, city, humidity, cloudiness, rain, wSpeed, wDirection, sunRise, sunSet, condSlug);

        //Retorno no objeto construído
        return weatherActual;
    }

    /**
     * Método getter que retorna o json para o clima atual
     * @return String jsonActual
     */
    public String getJsonActual() {
        return jsonActual;
    }
    /**
     * Método getter que retorna o json para a previsão do clima
     * @return String jsonForecast
     */
    public String[] getJsonForecast() {
        return jsonForecast;
    }

    public void parseForecast() throws ParseException{

        jsonCut();

        for (String string : jsonForecast) {
            System.out.println(string);
        }

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
    public String getKeyStatus() throws ParseException {
        //
        jsonCut();
        //Instanciamento de objeto via construtor JSONParser();
        JSONParser parser = new JSONParser();
        //Evocação de método do objeto acima instanciado, .parse(json) com cast para o tipo JSONObject
        JSONObject jsonObject = (JSONObject) parser.parse(this.jsonInicial);

        this.keyStatus = jsonObject.get("valid_key").toString();

        return keyStatus;
    }
}
