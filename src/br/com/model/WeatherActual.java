//Declaração de pacote
package br.com.model;

/**
 * @author Marcus Vieira
 * @apiNote Classe que define um objeto WeatherActual, sendo o clima atual
 */
public class WeatherActual {
    /**
     * Declaração de atributos privados
     */
    private String temp;
    private String date;
    private String time;
    private String description;
    private String currently;
    private String city;
    private String humidity;
    private String cloudiness;
    private String rain;
    private String wSpeed;
    private String wDirection;
    private String sunRise;
    private String sunSet;
    private String condSlug;

    /**
     * Declaração de construtor
     * @param temp        Temperatura
     * @param date        Data
     * @param time        Hora
     * @param description Descrição do clima
     * @param currently   Dia/tarde/noite
     * @param city        Cidade, Estado
     * @param humidity    Umidade
     * @param cloudiness   Nebulosidade
     * @param rain        Precipitação
     * @param wSpeed      Velocidade do vento
     * @param wDirection  Direção do vento
     * @param sunRise     Nascer do sol
     * @param sunSet      Por do sol
     * @param condSlug    Condição 
     */
    public WeatherActual(String temp, String date, String time, String description, 
                         String currently, String city, String humidity, String cloudness, 
                         String rain, String wSpeed, String wDirection, String sunRise, 
                         String sunSet, String condSlug) {
        this.temp = temp;
        this.date = date;
        this.time = time;
        this.description = description;
        this.currently = currently;
        this.city = city;
        this.humidity = humidity;
        this.cloudiness = cloudness;
        this.rain = rain;
        this.wSpeed = wSpeed;
        this.wDirection = wDirection;
        this.sunRise = sunRise;
        this.sunSet = sunSet;
        this.condSlug = condSlug;
    }

    /**
     * Sobreescrita do método toString
     */
    @Override
    public String toString() {
        return "WeatherActual [temp="        + temp + 
                            ", date="        + date + 
                            ", time="        + time + 
                            ", description=" + description + 
                            ", currently="   + currently + 
                            ", city="        + city + 
                            ", humidity="    + humidity + 
                            ", cloudness="   + cloudiness + 
                            ", rain="        + rain + 
                            ", wSpeed="      + wSpeed + 
                            ", wDirection="  + wDirection + 
                            ", sunRise="     + sunRise + 
                            ", sunSet="      + sunSet + 
                            ", condSlug="    + condSlug + 
                            "]";
    }

    /**
     * Declaração de método getter para temperatura
     * @return string temp
     */
    public String getTemp() {
        return this.temp;
    }
    /**
     * Declaração de método getter para data
     * @return string date
     */
    public String getDate() {
        return this.date;
    }
    /**
     * Declaração de método getter para hora
     * @return string time
     */
    public String getTime() {
        return this.time;
    }
    /**
     * Declaração de método getter para descrição do clima
     * @return string description
     */
    public String getDescription() {
        return this.description;
    }
    /**
     * Declaração de método getter para dia/tarde/noite
     * @return string currently
     */
    public String getCurrently() {
        return this.currently;
    }
    /**
     * Declaração de método getter para cidade, estado
     * @return string city
     */
    public String getCity() {
        return this.city;
    }
    /**
     * Declaração de método getter para humidade
     * @return string humidity
     */
    public String getHumidity() {
        return this.humidity;
    }
    /**
     * Declaração de método getter para nebulosidade
     * @return string cloudness
     */
    public String getCloudiness() {
        return this.cloudiness;
    }
    /**
     * Declaração de método getter para precipitação
     * @return string rain
     */
    public String getRain() {
        return this.rain;
    }
    /**
     * Declaração de método getter para velocidade do vento
     * @return string wSpeed
     */
    public String getwSpeed() {
        return this.wSpeed;
    }
    /**
     * Declaração de método getter para direção do vento
     * @return string wDirection
     */
    public String getwDirection() {
        return this.wDirection;
    }
    /**
     * Declaração de método getter para hora do nascer do sol
     * @return string sunRise
     */
    public String getSunRise() {
        return this.sunRise;
    }
    /**
     * Declaração de método getter para por do sol
     * @return string sunSet
     */
    public String getSunSet() {
        return this.sunSet;
    }
    /**
     * Declaração de método getter para estado atual do clima
     * @return string condSlug
     */
    public String getCondSlug() {
        return this.condSlug;
    }
}
