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
    public double latitude;
    public double longitude;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Reading> readings = new ArrayList<Reading>();

    public Station(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

//    public String blankReading() {
//        if (readings.size() == 0) {
//            return String "No reading";
//        }
//    }

    public Reading getLatestReading() {
        if (readings.size() != 0) {
            Reading latestReading = readings.get(readings.size() - 1);
            return latestReading;
        } else {
            // Handle the case when there are no readings
            return null;
//            return Float.NaN; // Or you can return an appropriate default value
        }
    }


    public String getLatestCode() {
        if (readings.size() != 0) {
            Reading latestReading = getLatestReading();
            return latestReading.getWeatherCode();
        } else {
            return " ";
        }
    }

    public float getLatestTemperature() {
        if (readings.size() != 0) {
            Reading latestReading = getLatestReading();
            return latestReading.temperature;
        } else {
            return 0;
        }
    }

    public float getLatestFahrenheit() {
        if (readings.size() != 0) {
            Reading latestReading = getLatestReading();
            return latestReading.fahrenheit();
        } else {
            return 0;
        }
    }

    public int getLatestWindSpeed() {
        if (readings.size() != 0) {
            Reading latestReading = getLatestReading();
            return latestReading.windBft();
        } else {
            return 0;
        }
    }

    public int getLatestPressure() {
        if (readings.size() != 0) {
            Reading latestReading = getLatestReading();
            return latestReading.pressure;
        } else {
            return 0;
        }
    }

    public String getLatestWindCompassDirection() {
        if (readings.size() != 0) {
            Reading latestReading = getLatestReading();
            return latestReading.windCompassDirection();
        } else {
            return " ";
        }
    }

    public double getLatestWindChill() {
        if (readings.size() != 0) {
            Reading latestReading = getLatestReading();
            return latestReading.windChill();
        } else {
            return 0;
        }
    }


    public Reading getMinTemp() {
        if (readings.size() != 0) {
            Reading minTemp = readings.get(0);
            for (Reading reading : readings) {
                if (reading.getTemperature() < minTemp.getTemperature()) {
                    minTemp = reading;
                }
            }
            return minTemp;
        } else {
            return null;
        }
    }

    public float setMinTemperature() {
        if (readings.size() != 0) {
            Reading minTemp = getMinTemp();
            return minTemp.getTemperature();
        } else {
            return 0;
        }
    }

    // Temp Max and Min //
    public Reading getMaxTemp() {
        if (readings.size() != 0) {
            Reading maxTemp = readings.get(0);
            for (Reading reading : readings) {
                if (reading.getTemperature() > maxTemp.getTemperature()) {
                    maxTemp = reading;
                }
            }
            return maxTemp;
        } else {
            return null;
        }
    }

    public float setMaxTemperature() {
        if (readings.size() != 0) {
            Reading maxTemp = getMaxTemp();
            return maxTemp.getTemperature();
        } else {
            return 0;
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
















