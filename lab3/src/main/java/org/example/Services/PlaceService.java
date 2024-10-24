package org.example.Services;

import org.example.Comparators.PlaceComparator;
import org.example.Place;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PlaceService {
    List<Place> places;

    public PlaceService(List<Place> places) {
        this.places = places;
    }

    public List<Place> findByCity(String city) {
        return places.stream().filter(place -> place.getCity().equals(city))
                .collect(Collectors.toList());
    }

    public  Place getWithMaxAgeLim(){
        return places.stream().max(new PlaceComparator()).orElse(null);
    }
}
