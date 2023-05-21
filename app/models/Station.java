package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Station extends Model {
    // the instance variables for the Station class are declared below
    public String name;
    public double latitude;
    public double longitude;
    @OneToMany(cascade = CascadeType.ALL) // defines a one-to-many relationship between Station and Reading entities, with cascading operations applied to the associated readings.
    public List<Reading> readings = new ArrayList<Reading>(); // a list object declared to hold the list of readings

    //defines a constructor for the Station class
    public Station(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    //returns the most recent reading associated with a station
    public Reading getLatestReading() {
        if (readings.size() != 0) { //checks if the readings list is empty
            Reading latestReading = readings.get(readings.size() - 1);
            return latestReading;
        } else {
            // handles the case when there are no readings
            return null;
        }
    }

    // returns the weather code as part of the latest reading
    public String getLatestCode() {
        if (readings.size() != 0) {
            Reading latestReading = getLatestReading();
            return latestReading.getWeatherCode();
        } else {
            return " ";
        }
    }

    // returns the temperature (C) as part of the latest reading
    public float getLatestTemperature() {
        if (readings.size() != 0) {
            Reading latestReading = getLatestReading();
            return latestReading.temperature;
        } else {
            return 0;
        }
    }

    // returns the fahrenheit as part of the latest reading
    public float getLatestFahrenheit() {
        if (readings.size() != 0) {
            Reading latestReading = getLatestReading();
            return latestReading.fahrenheit();
        } else {
            return 0;
        }
    }

    // returns the wind speed as part of the latest reading
    public int getLatestWindSpeed() {
        if (readings.size() != 0) {
            Reading latestReading = getLatestReading();
            return latestReading.windBft();
        } else {
            return 0;
        }
    }

    // returns the pressure as part of the latest reading
    public int getLatestPressure() {
        if (readings.size() != 0) {
            Reading latestReading = getLatestReading();
            return latestReading.pressure;
        } else {
            return 0;
        }
    }

    // returns the wind compass direction as part of the latest reading
    public String getLatestWindCompassDirection() {
        if (readings.size() != 0) {
            Reading latestReading = getLatestReading();
            return latestReading.windCompassDirection();
        } else {
            return " ";
        }
    }

    // returns the wind chill as part of the latest reading
    public double getLatestWindChill() {
        if (readings.size() != 0) {
            Reading latestReading = getLatestReading();
            return latestReading.windChill();
        } else {
            return 0;
        }
    }

    // Temp Max and Min //

    // returns the minimum temperature from the list of readings
    public Reading getMinTemp() {
        if (readings.size() != 0) { //checks the readings list is not empty
            Reading minTemp = readings.get(0); //minTemp is initialised as the first reading in the list
            for (Reading reading : readings) { //iterates over each reading in the list
                if (reading.getTemperature() < minTemp.getTemperature()) { //compares the current temp reading with the initial temp reading.
                    minTemp = reading; //minTemp is updated to the current reading iff the current temp is lower than the initial temp reading
                }
            }
            return minTemp; //returns an up to date min temp after iterating through all of the readings
        } else {
            return null; //returns null if there are no readings
        }
    }

    //sets the minimum temperature value
    public float setMinTemperature() {
        if (readings.size() != 0) { //checks the readings list is not empty
            Reading minTemp = getMinTemp(); //calls the method to get the min temp
            return minTemp.getTemperature(); //returns the value of the min temp
        } else {
            return 0; //returns a default "0" value if there are no readings
        }
    }

    // returns the maximum temperature from the list of readings
    public Reading getMaxTemp() {
        if (readings.size() != 0) { //checks the readings list is not empty
            Reading maxTemp = readings.get(0); //maxTemp is initialised as the first reading in the list
            for (Reading reading : readings) { //iterates over each reading in the list
                if (reading.getTemperature() > maxTemp.getTemperature()) { //compares the current temp reading with the initial temp reading.
                    maxTemp = reading; //maxTemp is updated to the current reading if the current temp is lower than the initial temp reading
                }
            }
            return maxTemp; //returns an up to date max temp after iterating through all of the readings
        } else {
            return null; //returns null if there are no readings
        }
    }

    //sets the maximum temperature value
    public float setMaxTemperature() {
        if (readings.size() != 0) { //checks the readings list is not empty
            Reading maxTemp = getMaxTemp(); //calls the method to get the max temp
            return maxTemp.getTemperature(); //returns the value of the max temp
        } else {
            return 0; //returns a default "0" value if there are no readings
        }
    }

    // Wind Max and Min //
    public Reading getMinWindSpeed() {
        if (readings.size() != 0) {
            Reading minWindSpeed = readings.get(0);
            for (Reading reading : readings) {
                if (reading.getWindSpeed() < minWindSpeed.getWindSpeed()) {
                    minWindSpeed = reading;
                }
            }
            return minWindSpeed;
        } else {
            return null;
        }
    }

    public float setMinWindSpeed() {
        if (readings.size() != 0) {
            Reading minWindSpeed = getMinWindSpeed();
            return minWindSpeed.getWindSpeed();
        } else {
            return 0;
        }
    }

    public Reading getMaxWindSpeed() {
        if (readings.size() != 0) {
            Reading maxWindSpeed = readings.get(0);
            for (Reading reading : readings) {
                if (reading.getWindSpeed() > maxWindSpeed.getWindSpeed()) {
                    maxWindSpeed = reading;
                }
            }
            return maxWindSpeed;
        } else {
            return null;
        }
    }

    public float setMaxWindSpeed() {
        if (readings.size() != 0) {
            Reading maxWindSpeed = getMaxWindSpeed();
            return maxWindSpeed.getWindSpeed();
        } else {
            return 0;
        }
    }

    // Pressure Max and Min //
    public Reading getMinPressure() {
        if (readings.size() != 0) {
            Reading minPressure = readings.get(0);
            for (Reading reading : readings) {
                if (reading.getPressure() < minPressure.getPressure()) {
                    minPressure = reading;
                }
            }
            return minPressure;
        } else {
            return null;
        }
    }

    public int setMinPressure() {
        if (readings.size() != 0) {
            Reading minPressure = getMinPressure();
            return minPressure.getPressure();
        } else {
            return 0;
        }
    }

    public Reading getMaxPressure() {
        if (readings.size() != 0) {
            Reading maxPressure = readings.get(0);
            for (Reading reading : readings) {
                if (reading.getPressure() > maxPressure.getPressure()) {
                    maxPressure = reading;
                }
            }
            return maxPressure;
        } else {
            return null;
        }
    }

    public int setMaxPressure() {
        if (readings.size() != 0) {
            Reading maxPressure = getMaxPressure();
            return maxPressure.getPressure();
        } else {
            return 0;
        }
    }
}
















