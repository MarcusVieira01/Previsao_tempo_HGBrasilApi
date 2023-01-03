//Declaração de pacote
package br.com.model;
/**
 * @author Marcus Vieira
 * @apiNote Classe concreta contendo uma abstração de uma previsão do tempo futura, denominada forecast
 */
public class WeatherForecast {
    String date;
    String weekday;
    String tempMax;
    String tempMin;
    String cloudiness;
    String rain;
    String rainProb;
    String wSpeed;
    String description;
    String condition;

    /**
     * Declaração de construtor
     * @param date
     * @param weekday
     * @param tempMax
     * @param tempMin
     * @param cloudiness
     * @param rain
     * @param rainProb
     * @param wSpeed
     * @param description
     * @param condition
     */
    public WeatherForecast(String date, String weekday, String tempMax, String tempMin, String cloudiness, String rain,
            String rainProb, String wSpeed, String description, String condition) {
        this.date = date;
        this.weekday = weekday;
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.cloudiness = cloudiness;
        this.rain = rain;
        this.rainProb = rainProb;
        this.wSpeed = wSpeed;
        this.description = description;
        this.condition = condition;
    }

    /**
     * Declaração de métodos getter
     * @return
     */
    public String getDate() {
        return date;
    }
    /**
     * Declaração de métodos getter
     * @return
     */
    public String getWeekday() {
        return weekday;
    }
    /**
     * Declaração de métodos getter
     * @return
     */
    public String getTempMax() {
        return tempMax;
    }
    /**
     * Declaração de métodos getter
     * @return
     */
    public String getTempMin() {
        return tempMin;
    }
    /**
     * Declaração de métodos getter
     * @return
     */
    public String getCloudiness() {
        return cloudiness;
    }
    /**
     * Declaração de métodos getter
     * @return
     */
    public String getRain() {
        return rain;
    }
    /**
     * Declaração de métodos getter
     * @return
     */
    public String getRainProb() {
        return rainProb;
    }
    /**
     * Declaração de métodos getter
     * @return
     */
    public String getwSpeed() {
        return wSpeed;
    }
    /**
     * Declaração de métodos getter
     * @return
     */
    public String getDescription() {
        return description;
    }
    /**
     * Declaração de métodos getter
     * @return
     */
    public String getCondition() {
        return condition;
    }

    /**
     * Declaração de método toString() sobreescrito
     * @return Um String com a descrição de todos os atributos da classe
     */
    @Override
    public String toString() {
        return "Previsão do tempo "                               + "\n" + 
                "Data: "                   + date + " " + weekday + "\n" + 
                "Temperatura máxima: "     + tempMax + "°C"       + "\n" +
                "Temperatura mínima: "     + tempMin + "°C"       + "\n" + 
                "Nebulosidade: "           + cloudiness + "%"     + "\n" + 
                "Precipitação Prevista: "  + rain + "mm"          + "\n" + 
                "Probabilidade de chuva: " + rainProb + "%"       + "\n" + 
                "Velocidade do vento: "    + wSpeed               + "\n" + 
                "Descrição prevista: "     + description          + "\n" + 
                "Tendência prevista: "     + condition            + "\n";
    }
}
