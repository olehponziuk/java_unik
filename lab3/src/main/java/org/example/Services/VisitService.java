package org.example.Services;

import org.example.Visit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VisitService {
    List<Visit> visits;
    public VisitService(List<Visit> v) {
        visits = v;
    }

    public double getMinVisitPrice() {
        return visits.stream().sorted().findFirst().get().getPrice();
    }
    public List<Visit> getCheapestVisit() {
        return visits.stream().sorted().collect(Collectors.toList());
    }

    public List<Visit> getInDateLimit(LocalDate start, LocalDate end)
    {
        return visits.stream().filter(visit -> visit.getStartDate().isAfter(start) && visit.getLastDate().isBefore(end))
                .collect(Collectors.toList());
    }
}
