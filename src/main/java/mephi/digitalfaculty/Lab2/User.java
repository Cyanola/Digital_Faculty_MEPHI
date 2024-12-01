package mephi.digitalfaculty.Lab2;

import lombok.Data;

@Data
public class User {
  private  int id;
   private String firstName;
 private    String lastName;
 private    double age;
  private   String country;
 static int counter=1;
    public User(String firstName, String lastName, double age, String country) {
        id=counter++;
        this.firstName = firstName;
        this.lastName = lastName;
        if (age>0&&age<=110) {
            this.age = age;
        }
        this.country = country;
    }
    @Override
    public String toString() {
        return firstName + " " +lastName + " age =" + age + ", country ='" + country + "'}";
    }
}
