package org.example.Comparators;

import org.example.Models.Place;

import java.util.Comparator;

public class PlaceComparator implements Comparator<Place> {
    @Override
    public int compare(Place p1, Place p2) {
        return p1.getAgeLimit() - p2.getAgeLimit();
    }
}
