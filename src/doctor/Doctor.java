/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doctor;

/**
 *
 * @author dell
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Admin
 */
public class Doctor {
    private int Id;
    private String Name;
    private LocalDate DateOfBirth;
    private String Specialization;
    private int Availability;
    private String Email;
    private String Mobile;

    public Doctor() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) throws Exception {
        if(Name.length() > 50) {
            throw new Exception("Invalid Name");
        }
        
        this.Name = Name;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String DateOfBirth) throws Exception {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.DateOfBirth = LocalDate.parse(DateOfBirth, formatter);
        } catch (Exception e) {
            throw new Exception("Invalid Date of Birth");
        }
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String Specialization) throws Exception {
        if(Specialization.length() > 255) {
            throw new Exception("Invalid Specialization");
        }
        
        this.Specialization = Specialization;
    }

    public int getAvailability() {
        return Availability;
    }

    public void setAvailability(int Availability) throws Exception {
        if(Availability < 0 || Availability > 4) {
            throw new Exception("Invalid Availability");
        }
        
        this.Availability = Availability;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) throws Exception {
        if(!Email.matches("^.+@.+\\..+$")) {
            throw new Exception("Invalid Email");
        }

        this.Email = Email;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String Mobile) throws Exception {
        if(!Mobile.matches("^(1\\-)?[0-9]{3}\\-?[0-9]{3}\\-?[0-9]{4}$")) {
            throw new Exception("Invalid Phone Number");
        }
        
        this.Mobile = Mobile;
    }

    @Override
    public String toString() {
        return "Doctor{" + "Id=" + Id + ", Name=" + Name + ", DateOfBirth=" + DateOfBirth + ", Specialization=" + Specialization + ", Availability=" + Availability + ", Email=" + Email + ", Mobile=" + Mobile + '}';
    }
    
}
