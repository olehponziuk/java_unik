package org.example;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class Place {
    @NotNull(message = "Name cannot be null")
    private String name;
    @Min(value = 3, message = "Age limit > 3")
    private int ageLimit;
    @NotNull(message = "Name cannot be null")
    private String country;
    @NotNull(message = "Name cannot be null")
    private String city;

    public String getName() {
        return name;
    }
    public int getAgeLimit() {
        return ageLimit;
    }
    private void setName(String name) {
        this.name = name;
    }
    private void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }
    public String getCountry() {
        return country;
    }
    private void setCountry(String country) {
        this.country = country;
    }

    private void setCity(String city)
    {
        this.city = city;
    }
    public String getCity(){
        return city;
    }
    //public boolean hasHotels;
    //public boolean hasRestaurants;

    public Place(String namePlace, int ageLimit, String country, String city) {
        this.name = namePlace;
        this.ageLimit = ageLimit;
        this.country = country;
        this.city = city;
    }

    public Place() {

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Place place = (Place) obj;
        return city.equals(place.city) &&
                ageLimit == place.ageLimit &&
                name.equals(place.name) &&
                country.equals(place.country);
    }

    @Override
    public int hashCode()
    {
        return 52 + Objects.hash(name,ageLimit,country,city);
    }

    @Override
    public String toString()
    {
        return "name: " + name + ", ageLimit: " + ageLimit + ", country: " + country + ", city: " + city;
    }
}
