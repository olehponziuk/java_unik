package org.example;
import java.util.*;

public class AmusementPark extends Place implements Comparable<AmusementPark> {
    Map<String, Double> attractions;

    public AmusementPark(String namePlace, int ageLimit, String country, String city) {
        super(namePlace, ageLimit, country, city);
        attractions = new HashMap<String, Double>();
    }

    public void addAttraction(String attraction, double price) {
        attractions.put(attraction, price);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + attractions.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof AmusementPark)){
            return false;
        }
        AmusementPark other = (AmusementPark)obj;
        int n = attractions.size();
        boolean equals = true;
        if (! attractions.equals(other.attractions)){
            equals = false;
        }

        return super.equals(obj) && equals;
    }

    @Override
    public String toString() {
        StringBuilder tmp = new StringBuilder();
        String[] attractionNames = attractions.keySet().toArray(new String[attractions.size()]);
        Double[] attractionPrices = attractions.values().toArray(new Double[attractions.size()]);
        for(int i = 0 ; i < attractions.size(); i++) {
            tmp.append(attractionNames[i]).append(" : ").append(attractionPrices[i]).append("\n");
        }
        return super.toString() + tmp;
    }

    @Override
    public int compareTo(AmusementPark park) {
        return this.getAgeLimit() - park.getAgeLimit();
    }
}
