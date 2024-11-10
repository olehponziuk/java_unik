package org.example;

import org.example.Models.AmusementPark;
import org.example.Models.Client;
import org.example.Models.Visit;

import java.time.LocalDate;
import java.util.ArrayList;

/*public class Main {
    public static void main(String[] args) {
        /*Client client1 = new Client("Ivan", "Bubna", LocalDate.of(2007, 8, 10), true);
        Client client2 = new Client("Kate", "Petrenko", LocalDate.of(2003, 8, 24), false);

        ArrayList<Client> group = new ArrayList<>();
        group.add(client1);
        group.add(client2);

        AmusementPark disneyLand = new AmusementPark("DisneyLand", 5, "Japane", "Tokyo");

        disneyLand.addAttraction("Space Mountain", 50.0);
        disneyLand.addAttraction("Pirates of the Caribbean", 45.0);

        Visit visit = new Visit.VisitBuilder()
                .setGroup(group)
                .addPrice(150.0)
                .addTransport("Bus")
                .addPlace(disneyLand)
                .addFirst_date(LocalDate.of(2024,12,26))
                .addLastDate(LocalDate.of(2025, 1, 5))
                .build();

        System.out.println(visit);


        Client client1 = new Client("Ivan", "Bubna", LocalDate.of(2007, 8, 10), true);
        Client client2 = new Client("Kate", "Petrenko", LocalDate.of(2003, 8, 24), false);
        ArrayList<Client> group = new ArrayList<>();
        group.add(client1);
        group.add(client2);

        AmusementPark disneyLand = new AmusementPark("DisneyLand", 5, "Japan", "Tokyo");
        disneyLand.addAttraction("Space Mountain", 50.0);
        disneyLand.addAttraction("Pirates of the Caribbean", 45.0);

        AmusementPark sixFlags = new AmusementPark("SixFlags", 10, "USA", "Los Angeles");
        sixFlags.addAttraction("Superman", 60.0);
        sixFlags.addAttraction("Wonder Woman", 55.0);

        List<AmusementPark> parksList = Arrays.asList(disneyLand, sixFlags);
        AmusementParkService parkService = new AmusementParkService(parksList);

        System.out.println("All Parks: " + parkService.getAll());
        System.out.println("Park by Name (DisneyLand): " + parkService.findByName("DisneyLand"));
        System.out.println("Smallest Park by Age Limit: " + parkService.getSmallestWithAgeLim());

        AmusementPark europaPark = new AmusementPark("Europa Park", 6, "Germany", "Rust");
        parkService.addPark(europaPark);
        System.out.println("After Adding Europa Park: " + parkService.getAll());

        parkService.removePark(sixFlags);
        System.out.println("After Removing Six Flags: " + parkService.getAll());

        Place place1 = new Place("Central Park", 5, "USA", "Los Angeles");
        Place place2 = new Place("Golden Gate Park", 12, "UA", "London");

        List<Place> placesList = Arrays.asList(place1, place2);
        PlaceService placeService = new PlaceService(placesList);

        System.out.println("Places in San Francisco: " + placeService.findByCity("London"));
        System.out.println("Place with Max Age Limit: " + placeService.getWithMaxAgeLim());

        Visit visit1 = new Visit.VisitBuilder()
                .setGroup(group)
                .addPrice(100.0)
                .addTransport("Bus")
                .addPlace(disneyLand)
                .addFirst_date(LocalDate.of(2024, 12, 26))
                .addLastDate(LocalDate.of(2025, 1, 5))
                .build();

        Visit visit2 = new Visit.VisitBuilder()
                .setGroup(group)
                .addPrice(100.0)
                .addTransport("Car")
                .addPlace(europaPark)
                .addFirst_date(LocalDate.of(2024, 11, 1))
                .addLastDate(LocalDate.of(2024, 11, 10))
                .build();

        List<Visit> visitList = Arrays.asList(visit1, visit2);
        VisitService visitService = new VisitService(visitList);

        System.out.println("Min prices: " + visitService.getMinVisitPrice());
        System.out.println("Cheapest Visit: " + visitService.getCheapestVisit());
        System.out.println("Visits in Date Limit (Nov 2024): " +
                visitService.getInDateLimit(LocalDate.of(2024, 11, 1), LocalDate.of(2024, 11, 30)));
    }

}

public class Main {
    public static void main(String[] args) {
        AmusementPark disneyLand = new AmusementPark("DisneyLand", 5, "Japane", "Tokyo");

        disneyLand.addAttraction("Space Mountain", 50.0);
        disneyLand.addAttraction("Pirates of the Caribbean", 45.0);
        Client client1 = new Client("Ivan", "Bubna", LocalDate.of(2007, 8, 10), true);
        Client client2 = new Client("Kate", "Petrenko", LocalDate.of(2003, 8, 24), false);
        ArrayList<Client> group = new ArrayList<>();
        group.add(client1);
        group.add(client2);

        Visit visit = new Visit.VisitBuilder()
                .setGroup(group)
                .addPrice(100.5)
                .addTransport("Bus")
                .addPlace(disneyLand)
                .addFirstDate(java.time.LocalDate.of(2024, 10, 17))
                .addLastDate(java.time.LocalDate.of(2024, 10, 20))
                .build();

        ISerializable<Visit> jsonSerializer = new JSONSerializer<>(Visit.class);
        testSerializationAndDeserialization(jsonSerializer, visit, "C:\\Users\\kuzni\\IdeaProjects\\lab3\\visit.json");
        //System.out.println(visit);

        ISerializable<Visit> xmlSerializer = new XMLSerializer<>(Visit.class);
        testSerializationAndDeserialization(xmlSerializer, visit, "C:\\Users\\kuzni\\IdeaProjects\\lab3\\visit.xml");

        ISerializable<Visit> yamlSerializer = new YAMLSerializer<>(Visit.class, Visit.class);
        testSerializationAndDeserialization(yamlSerializer, visit, "C:\\Users\\kuzni\\IdeaProjects\\lab3\\visit.yaml");
    }

    private static void testSerializationAndDeserialization(ISerializable<Visit> serializer, Visit visit, String fileName) {
        try {
            ArrayList<Visit> visits = new ArrayList<>();
            visits.add(visit);
            String serializedData = serializer.serialize(visits);
            System.out.println("Serialized Data (" + fileName + "):\n"  + "\n\n");

            serializer.writeToFile(visits, fileName);
            System.out.println("Data written to file: " + fileName);

            List<Visit> deserializedVisits = serializer.readFromFile(fileName);
            System.out.println("Deserialized Data from file (" + fileName + "): " + deserializedVisits);

        } catch (IOException e) {
            System.err.println("Error during serialization: " + e.getMessage());
        }

    }
}
*/

/*public class Main {
    public static void main(String[] args) {
        AmusementPark disneyLand = new AmusementPark("DisneyLand", 5, "Japane", "Tokyo");

        disneyLand.addAttraction("Space Mountain", 50.0);
        disneyLand.addAttraction("Pirates of the Caribbean", 45.0);
        Client client1 = new Client(1,"Ivan", "Bubna", LocalDate.of(2007, 8, 10), true);
        Client client2 = new Client(2,"Kate", "Petrenko", LocalDate.of(2003, 8, 24), false);
        ArrayList<Client> group = new ArrayList<>();
        group.add(client1);
        group.add(client2);

        // Використовуємо VisitBuilder для створення візиту
        try {
            Visit visit = new Visit.VisitBuilder()
                    .setGroup(group)
                    .addPrice(100.5) // Додайте валідацію для ціни
                    .addTransport("Bus")
                    .addPlace(disneyLand)
                    .addFirstDate(LocalDate.of(2024, 10, 17))
                    .addLastDate(LocalDate.of(2024, 10, 20))
                    .build();

            System.out.println("Visit created successfully: " + visit);
        } catch (IllegalArgumentException e) {
            System.err.println("Validation errors: " + e.getMessage());
        }
    }
}*/

import org.example.DAO.ClientDAO;
import org.example.Models.Client;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        ClientDAO clientDAO = new ClientDAO();

        try {
            Client newClient = new Client(1,"Ivan", "Bubna", LocalDate.of(2007, 8, 10), true);
            boolean isCreated = clientDAO.create(newClient);
            System.out.println("Client created: " + isCreated + ", ID: " + newClient.getId());

            List<Client> clients = clientDAO.getAll();
            System.out.println("All clients:");
            for (Client client : clients) {
                System.out.println(client);
            }

            Optional<Client> clientById = clientDAO.getById(newClient.getId());


            newClient.setFirstName("Kataq");
            newClient.setLastName("You");
            boolean isUpdated = clientDAO.update(newClient);
            System.out.println("Client updated: " + isUpdated);

            clientById = clientDAO.getById(newClient.getId());
            if (clientById.isPresent()) {
                System.out.println("Updated client: " + clientById.get());
            }

            boolean isDeleted = clientDAO.delete(newClient);
            System.out.println("Client deleted: " + isDeleted);

            clientById = clientDAO.getById(newClient.getId());
            if (clientById.isEmpty()) {
                System.out.println("Client successfully deleted.");
            } else {
                System.out.println("Client still exists after deletion: " + clientById.get());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
