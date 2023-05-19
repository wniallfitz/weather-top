package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

import utilities.Conversions; //imports the Conversions class from the utilities package

@Entity
public class Reading extends Model { //declares the Reading class

    //instance variables for Reading are declared below
    public int code;
    public float temperature;
    public float windSpeed;

    public int pressure;

    public float windDirection;


    //Constructor for objects of class Reading
    public Reading(int code, float temperature, float windSpeed, int pressure, float windDirection) {
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.windDirection = windDirection;
    }

    //-------
    //getters
    //-------

    //returns the weather code
    public String getWeatherCode() {return weatherCode();}

    //returns the temperature
    public float getTemperature() {
        return temperature;
    }

    //returns the wind speed
    public float getWindSpeed() {
        return windSpeed;
    }

    //returns the pressure
    public int getPressure() {
        return pressure;
    }

    //returns the wind direction
    public float getWindDirection() {
        return windDirection;
    }

    //converts the weather code to a descriptive string
    public String weatherCode() {
        return Conversions.convertCodeToWeather(this.code);
    }

    //converts the temperature (celcius) reading to fahrenheit
    public float fahrenheit() {
        return Conversions.convertToFahrenheit(this.temperature);
    }

    //converts the windspeed to the beaufort scale
    public int windBft() {
        return Conversions.convertWindSpeedToBeaufort(this.windSpeed);
    }

    //converts wind direction to a compass direction
    public String windCompassDirection() { return Conversions.convertWindDirectionToCompass(this
        .windDirection);}

    //calculates windchill based on the temperature and wind speed
    public double windChill() { return Conversions.convertToWindChill(this
        .temperature, this.windSpeed);}

    public static String blankReading(){
        return "No Reading";
    }

}




