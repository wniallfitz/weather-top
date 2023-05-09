package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Station extends Model {
    public String name;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Reading> readings = new ArrayList<Reading>();

    public Station(String name) {
        this.name = name;
    }

    public Reading getLatestReading() {
        Reading latestReading = readings.get(readings.size() - 1);
        return latestReading;
    }

    public String getLatestCode() {
        Reading latestReading = getLatestReading();
        return latestReading.getWeatherCode();
    }

    public float getLatestTemperature() {
        Reading latestReading = getLatestReading();
        return latestReading.temperature;
    }

    public float getLatestFahrenheit() {
        Reading latestReading = getLatestReading();
        return latestReading.fahrenheit();
    }

    public int getLatestWindSpeed() {
        Reading latestReading = getLatestReading();
        return latestReading.windBft();
    }

    public int getLatestPressure() {
        Reading latestReading = getLatestReading();
        return latestReading.pressure;
    }

    public String getLatestWindCompassDirection() {
        Reading latestReading = getLatestReading();
        return latestReading.windCompassDirection();
    }

    public double getLatestWindChill() {
        Reading latestReading = getLatestReading();
        return latestReading.windChill();
    }

}







