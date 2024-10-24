package org.example.Services;

import org.example.AmusementPark;

import java.nio.file.AccessMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AmusementParkService
{
    private List<AmusementPark> parks;

    public AmusementParkService(List<AmusementPark> parks){
        this.parks = new ArrayList<AmusementPark>(parks);
    }
    public List<AmusementPark> getParks(){
        return parks;
    }
    public void setParks(List<AmusementPark> parks){
        this.parks = parks;
    }

    public void addPark(AmusementPark park){
        parks.add(park);
    }

    public void removePark(AmusementPark park){
        parks.remove(park);
    }

    public List<AmusementPark> findByName(String name){
        return parks.stream()
                .filter(park -> Objects.equals(park.getName(), name)).collect(Collectors.toList());}

    public List<AmusementPark> getAll(){
        return parks;
    }

    public List<AmusementPark> getSmallestWithAgeLim() {
        return parks.stream().sorted().collect(Collectors.toList());
        }

}

