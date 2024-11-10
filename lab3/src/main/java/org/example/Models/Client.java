package org.example.Models;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import java.sql.Date;
import java.time.LocalDate;

public class Client {

    private int id;
    @JsonProperty("firstName")
    @Length(min = 2, max = 45, message = "Name must be biggest")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("birthDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @JsonProperty("email")
    private String email;
    @JsonProperty("vipPass")
    private boolean vipPass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public boolean getVipPass() {
        return vipPass;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }
    private void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public boolean isVipPass() {
        return vipPass;
    }
    private void setVipPass(boolean vipPass) {
        this.vipPass = vipPass;
    }

    public Client(int id,String firstName, String lastName, LocalDate birthDate, boolean vipPass) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.vipPass = vipPass;
        this.id = id;
    }

    public Client() {

    }

    @Override
    public String toString() {
        return "Client [id=" + id + "first_name=" + firstName + ", last_name=" + lastName + ", birth_date=" + birthDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + (vipPass ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Client other = (Client) obj;

        return vipPass == other.vipPass &&
                (firstName != null ? firstName.equals(other.firstName) : other.firstName == null) &&
                (lastName != null ? lastName.equals(other.lastName) : other.lastName == null) &&
                (birthDate != null ? birthDate.equals(other.birthDate) : other.birthDate == null) &&
                (email != null ? email.equals(other.email) : other.email == null);
    }
}
