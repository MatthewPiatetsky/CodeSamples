package photoshare;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * A bean that handles new user data
 *
 * @author G. Zervas <cs460tf@bu.edu>
 */
public class NewUserBean {
  private String first_name = "";
  private String last_name = "";
  private String date_of_birth = "";
  private String gender = "";
  private String email = "";
  private String password1 = "";
  private String password2 = "";
  private String hometown_address = "";
  private String current_address = "";
  private String education_information = "";  
  
  public String saySomething() {
    System.out.println("Hello!");
    return "Test";
  }
  
  public String getFirstName() {
    return first_name;
  }

    public String getLastName() {
	return last_name;
    }

    public String getDateOfBirth() {
	return date_of_birth;
    }

    public String getGender() {
	return gender;
    }

    public String getHometownAddress() {
	return hometown_address;
    }

    public String getCurrentAddress(){
	return current_address;
    }

    public String getEducationInformation(){
	return education_information;
    }

  public String getEmail() {
    return email;
  }
  
  public String getPassword1() {
    return password1;
  }

  public String getPassword2() {
    return password2;
  }

    public void setFirstName(String first_name) {
	this.first_name = first_name;
    }

    public void setLastName(String last_name) {
	this.last_name = last_name;
    }

    public void setDateOfBirth(String date_of_birth) {
	this.date_of_birth = date_of_birth;
    }

    public void setGender(String gender) {
	this.gender = gender;
    }

    public void setHometownAddress(String hometown_address) {
	this.hometown_address = hometown_address;
    }

    public void setCurrentAddress(String current_address) {
	this.current_address = current_address;
    }
    public void setEducationInformation(String education_information) {
	this.education_information = education_information;
    }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword1(String password1) {
    this.password1 = password1;
  }

  public void setPassword2(String password2) {
    this.password2 = password2;
  }
}
