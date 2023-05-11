package controllers;

import java.util.List;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;
import utilities.Conversions;

public class StationCtrl extends Controller
{
    public static void index(Long id)
    {
        Station station = Station.findById(id);
        Logger.info ("Station id = " + id);
        render("station.html", station);


    }
//    public static void addReading(Long id, int code, float temperature, float windSpeed, int pressure, float windDirection, double latitude, double longitude)
    public static void addReading(Long id, int code, float temperature, float windSpeed, int pressure, float windDirection)
    {
        Reading reading = new Reading(code, temperature, windSpeed, pressure, windDirection);
        Station station = Station.findById(id);
        station.readings.add(reading);
        station.save();
        redirect ("/stations/" + id);
    }

}
