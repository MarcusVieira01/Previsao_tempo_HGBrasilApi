//Declaração de pacote
package br.com.util;

/**
 * @apiNote Classe auxiliar que fará a separação do JSON em fraçoes pertinentes como a parte do clima atual e forecast
 */
public class JsonCut {
    //Declaração de atributos privados
    private String jsonInicial;
    private String jsonActual;
    private String[] jsonForecast;

    /**
     * Método que realiza o corte do json para os trechos que compõe o clima atual o forecast; 
     */
    private void jsonCut(String json){
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


    public String getJsonInicial(String json) {
        jsonCut(json);
        return jsonInicial;
    }

    public String getJsonActual(String json) {
        jsonCut(json);
        return jsonActual;
    }

    public String[] getJsonForecast(String json) {
        jsonCut(json);
        return jsonForecast;
    }
}
