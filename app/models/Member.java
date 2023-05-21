package models;

import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

import models.Station; //imports the station class

@Entity
public class Member extends Model //defines the class Member
{
  public String firstname;
  public String lastname;
  public String email;
  public String password;

  @OneToMany(cascade = CascadeType.ALL) // defines a one-to-many relationship between Member and Station entities, with cascading operations applied to the associated stations.
  public List<Station> stations = new ArrayList<Station>();

  public Member(String firstname, String lastname, String email, String password) //defines a constructor for the Member class which is used to create a new Member object
  {
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.password = password;
  }

  public static Member findByEmail(String email) //defines a method used to find a member by their email
  {
    return find("email", email).first();
  }

  public boolean checkPassword(String password) // a method that checks if the provided password matches the member's stored password.
  {
    return this.password.equals(password);
  }
}
