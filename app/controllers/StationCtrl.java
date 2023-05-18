package controllers;

import java.util.List;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;
import utilities.Conversions; //imports the Conversions class from the utilities package

public class StationCtrl extends Controller //defines a new class StationCtrl
{
    public static void index(Long id) //declares a method 'index'
    {
        Station station = Station.findById(id); //retreives a Station object from the database on an id parameter and assigns it to a variable 'station'
        if (station == null) { //checks if the station variable is null i.e. meaning no station was found with the given id
            station = new Station(" ", 0.0, 0.0); //creats a new Station object and assigns it to the station variable
        }
        Logger.info ("Station id = " + id); //logs and prints a message to the log
        render("station.html", station); //renders the named view
    }

    public static void addReading(Long id, int code, float temperature, float windSpeed, int pressure, float windDirection) //declares the method addReading
    {
        Reading reading = new Reading(code, temperature, windSpeed, pressure, windDirection); //creates a new Reading object and assigns it to the reading variable
        Station station = Station.findById(id); //retreives a Station object from the database on an id parameter and assigns it to a variable 'station'
        station.readings.add(reading); //adds the reading to the readings list associated with the station
        station.save(); //saves the changes made to the station
        redirect ("/stations/" + id); //redirects the user to the specific url for the station
    }

}
