package org.example;

public abstract class Place implements Cloneable{
    public String title;
    public boolean hasHotels;
    public boolean hasRestaurants;
    public int ageLimit;
    public String country;
    public Place(String namePlace, boolean hasHotels, boolean hasRestaurants, int ageLimit, String country) {
        this.title = namePlace;
        this.hasHotels = hasHotels;
        this.hasRestaurants = hasRestaurants;
        this.ageLimit = ageLimit;
        this.country = country;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
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
        return hasHotels == place.hasHotels &&
                hasRestaurants == place.hasRestaurants &&
                ageLimit == place.ageLimit &&
                title.equals(place.title) &&
                country.equals(place.country);
    }


}

