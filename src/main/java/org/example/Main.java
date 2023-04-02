package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Movie movie1 = new Movie("Trónok harca","action",44);
        Movie movie2 = new Movie("Titanic","adventure",55);
        Movie movie3 = new Movie("Hair","horror",54);

        List<Movie> movieList1= new ArrayList<>();
        movieList1.add(movie1);
        movieList1.add(movie2);
        movieList1.add(movie3);


        Room room1 = new Room("room1",100,movieList1);
        Room room2 = new Room("room2",150,movieList1);
        Room room3 = new Room("room3",200,movieList1);


        List<Room> roomList = new ArrayList<>();
        roomList.add(room1);
        roomList.add(room2);
        roomList.add(room3);

        Screening screening1 = new Screening("Trónok harca", "room1", LocalDateTime.of(2023, 1, 2, 9, 0));
        Screening screening2 = new Screening("Titanic", "room1", LocalDateTime.of(2023, 1, 2, 10, 0));
        Screening screening3 = new Screening("Hair", "room1", LocalDateTime.of(2023, 1, 2, 10, 30));


        MovieApplication movieApplication = new MovieApplication(roomList, movieList1);


        System.out.println( movieApplication.addScreening(screening1) + "hozzáadva");
        System.out.println( movieApplication.addScreening(screening2) + "hozzáadva");
        System.out.println( movieApplication.addScreening(screening3) + "hozzáadva");

    }

}