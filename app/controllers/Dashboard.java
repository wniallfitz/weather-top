package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

public class Dashboard extends Controller
{
  public static void index()
  {
    Logger.info("Rendering Admin");

    List<Station> stations = Station.findAll();
    render ("dashboard.html", stations);
  }

  public static void addStation (String name, double latitude, double longitude)
  {
    Station station = new Station (name, latitude, longitude);
    Logger.info ("Adding a new station called " + name);
    station.save();
    redirect ("/dashboard");
  }
}
