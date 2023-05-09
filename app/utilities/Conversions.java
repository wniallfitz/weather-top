package utilities;

public class Conversions {

    public static String convertCodeToWeather(int code) {
        if (code == 100) {
            return "Clear";
        } else if (code == 200) {
            return "Partial clouds";
        } else if (code == 300) {
            return "Cloudy";
        } else if (code == 400) {
            return "Light Showers";
        } else if (code == 500) {
            return "Heavy Showers";
        } else if (code == 600) {
            return "Rain";
        } else if (code == 700) {
            return "Snow ";
        } else if (code == 800) {
            return "Thunder";
        } else {
            return "Error:no weather code reading.";
        }
    }

    public static float convertToFahrenheit(float temperature) {
        float fahrenheit = temperature * 9 / 5 + 32;
        return fahrenheit;
    }

    public static int convertWindSpeedToBeaufort(float windSpeed) {
        if (windSpeed < 1) {
            return 0;
        } else if (windSpeed <= 5) {
            return 1;
        } else if (windSpeed <= 11) {
            return 2;
        } else if (windSpeed <= 19) {
            return 3;
        } else if (windSpeed <= 28) {
            return 4;
        } else if (windSpeed <= 38) {
            return 5;
        } else if (windSpeed <= 49) {
            return 6;
        } else if (windSpeed <= 61) {
            return 7;
        } else if (windSpeed <= 74) {
            return 8;
        } else if (windSpeed <= 88) {
            return 9;
        } else if (windSpeed <= 102) {
            return 10;
        } else if (windSpeed <= 117) {
            return 11;
        } else return 12;

    }

    //method for converting wind direction to compass
    public static String convertWindDirectionToCompass(float windDirection) {
        if (windDirection <= 11.25) {
            return "North";
        } else if (windDirection <= 33.75) {
            return "North North East";
        } else if (windDirection <= 56.25) {
            return "North East";
        } else if (windDirection <= 78.75) {
            return "East North East";
        } else if (windDirection <= 101.25) {
            return "East";
        } else if (windDirection <= 123.75) {
            return "East South East";
        } else if (windDirection <= 146.25) {
            return "South East";
        } else if (windDirection <= 168.75) {
            return "South South East";
        } else if (windDirection <= 191.25) {
            return "South";
        } else if (windDirection <= 213.75) {
            return "South South West";
        } else if (windDirection <= 236.25) {
            return "South West";
        } else if (windDirection <= 258.75) {
            return "West South West";
        } else if (windDirection <= 281.25) {
            return "West";
        } else if (windDirection <= 303.75) {
            return "West North West";
        } else if (windDirection <= 326.25) {
            return "North West";
        } else if (windDirection <= 348.75) {
            return "North North West";
        } else if (windDirection <= 360.00) {
            return "North";
        } else
            return "Wind Compass Reading Error";
    }
// method for converting wind chill
    public static double convertToWindChill(float temperature, float windSpeed) {
        double windChill = 13.12 + (0.6215*temperature) - (11.37 * (Math.pow(windSpeed, 0.16))) + (0.3965*temperature) *(Math.pow(windSpeed, 0.16));
        return toTwoDecimalPlaces(windChill);
    }
    // method for converting number to two decimal places
    private static double toTwoDecimalPlaces(double num){
        return (int) (num *100 ) /100.0;
    }
}

