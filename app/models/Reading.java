package models;

import javax.persistence.Entity;

import play.db.jpa.Model;

import utilities.Conversions;

@Entity
public class Reading extends Model {
    public int code;
    public float temperature;
    public float windSpeed;

    public int pressure;

    public float windDirection;

//    public static double latitude;
//
//    public static double longitude;

    //Constructor for objects of class Reading
    public Reading(int code, float temperature, float windSpeed, int pressure, float windDirection) {
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.windDirection = windDirection;
    }

//    public Reading(int code, float temperature, float windSpeed, int pressure, float windDirection, double latitude, double longitude) {
//        this.code = code;
//        this.temperature = temperature;
//        this.windSpeed = windSpeed;
//        this.pressure = pressure;
//        this.windDirection = windDirection;
//        this.latitude = latitude;
//        this.longitude = longitude;
//    }

    //-------
    //getters
    //-------

    public String getWeatherCode() {return weatherCode();}

    public float getTemperature() {
        return temperature;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public int getPressure() {
        return pressure;
    }

    public float getWindDirection() {
        return windDirection;
    }

//    public static double getLatitude() {
//        return latitude;
//    }
//
//    public static double getLongitude() {
//        return longitude;
//    }


//    public float getWindChill() {return windChill;}

    public String weatherCode() {
        return Conversions.convertCodeToWeather(this.code);
    }
    public float fahrenheit() {
        return Conversions.convertToFahrenheit(this.temperature);
    }

    public int windBft() {
        return Conversions.convertWindSpeedToBeaufort(this.windSpeed);
    }

    public String windCompassDirection() { return Conversions.convertWindDirectionToCompass(this
        .windDirection);}

    public double windChill() { return Conversions.convertToWindChill(this
        .temperature, this.windSpeed);}


}




