package org.example;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import jakarta.validation.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Visit implements Comparable<Visit> {

    @JacksonXmlElementWrapper(localName = "group")
    @JacksonXmlProperty(localName = "client")
    private List<Client> group;
    private double price;
    private String transport;
    private Place place;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @JsonProperty("lastDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    public Visit() {
        this.group = new ArrayList<>();
    }

    public List<Client> getGroup() {
        return group;
    }


    public Visit(VisitBuilder builder) {
        this.group = builder.group;
        this.price = builder.price;
        this.transport = builder.transport;
        this.place = builder.place;
        this.startDate = builder.firstDate;

        this.endDate = builder.lastDate;
    }

    public double getPrice() {
        return price;
    }

    public String getTransport() {
        return transport;
    }

    public Place getPlace() {
        return place;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getLastDate() {
        return endDate;
    }

    private void setGroup(ArrayList<Client> group) {
        this.group = group;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    private void setTransport(String transport) {
        this.transport = transport;
    }

    private void setPlace(Place place) {
        this.place = place;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")

    private void setLast_date(LocalDate last_date) {
        this.endDate = last_date;
    }

    @Override
    public int compareTo(Visit visit) {
        return Double.compare(this.price, visit.price);
    }

    @Override
    public String toString() {
        return "Visit{" +
                "group=" + group +
                ", price='" + price + '\'' +
                ", transport='" + transport + '\'' +
                ", place=" + place +
                ", first_date=" + startDate +
                ", last_date=" + endDate +
                '}';
    }

    @Override
    public int hashCode() {
        return 52 * group.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Visit other = (Visit) obj;
        return group.equals(other.group) &&
                price == other.price &&
                transport.equals(other.transport) &&
                place.equals(other.place) &&
                startDate.equals(other.startDate) &&
                endDate.equals(other.endDate);
    }

    public static class VisitBuilder {
        @JacksonXmlElementWrapper(localName = "group")
        @JacksonXmlProperty(localName = "client")
        @Valid
        private List<Client> group;
        @NotNull(message = "Name cannot be null")
        @Min(value = 40, message = "The price of the trip contradicts the company's policy")
        @Max(value = 1_999_999, message = "The price of the trip contradicts the company's policy")
        private double price;

        @NotNull(message = "Name cannot be null")
        private String transport;
        @NotNull(message = "Name cannot be null")
        private Place place;
        @JsonProperty("firstDate")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        @FutureOrPresent()
        private LocalDate firstDate;

        @JsonProperty("lastDate")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        @FutureOrPresent()
        private LocalDate lastDate;

        public VisitBuilder setGroup(ArrayList<Client> group) {
            this.group = group;
            return this;
        }

        public VisitBuilder addPrice(double price) {
            this.price = price;
            return this;
        }

        public VisitBuilder addTransport(String transport) {
            this.transport = transport;
            return this;
        }

        public VisitBuilder addPlace(Place place) {
            this.place = place;
            return this;
        }

        public VisitBuilder addFirst_date(LocalDate firstDate) {
            this.firstDate = firstDate;
            return this;
        }

        public VisitBuilder addLastDate(LocalDate lastDate) {
            this.lastDate = lastDate;
            return this;
        }

        public Visit build() {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            Set<ConstraintViolation<VisitBuilder>> violations = validator.validate(this);
            if (!violations.isEmpty()) {
                StringBuilder errorMessage = new StringBuilder("Validation errors:");
                for (ConstraintViolation<VisitBuilder> violation : violations) {
                    errorMessage.append("\n").append(violation.getMessage());
                }
                throw new IllegalArgumentException(errorMessage.toString());
            }

            return new Visit(this);
        }

        public VisitBuilder addFirstDate(LocalDate of) {
            this.firstDate = of;
            return this;
        }
    }

}
