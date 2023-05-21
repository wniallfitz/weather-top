package controllers; //the Dashboard class belongs to the controllers package

import java.util.ArrayList;
import java.util.List;

import models.Member; //imports the Member class from the models package
import models.Station; //imports the Station class from the models package
import models.Reading; //imports the Reading class from the models package
import play.Logger;
import play.mvc.Controller;

public class Dashboard extends Controller //defines a new class 'Dashboard'
{
  public static void index() //declares the method 'index'
  {
    Logger.info("Rendering Dashboard"); //logs a message and prints it to the log
    Member member = Accounts.getLoggedInMember(); //retrieves the currently logged-in member
    List<Station> stations = member.stations; //assigns the list of stations associated with the member to a variable stations of type List<Station>
    render ("dashboard.html", stations); //renders the named view
  }

  public static void addStation (String name, double latitude, double longitude) //declares the method addStation
  {
    Logger.info ("Adding a new station called " + name); //logs a message and prints it to the log
    Member member = Accounts.getLoggedInMember(); //retrieves the currently logged-in member
    Station station = new Station (name, latitude, longitude); //creates a new instance of the Station class
    member.stations.add(station); //adds the new station to the stations list associated with the member
    member.save(); //saves changes made to the member object
    redirect ("/dashboard");
  }
  
}

