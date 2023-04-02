package org.example;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Movie> movieList;
        List<Room> roomList;
        Screening screening1 = new Screening("Trónok harca", "room1", LocalDateTime.of(2023, 1, 2, 9, 0));
        Screening screening2 = new Screening("Titanic", "room1", LocalDateTime.of(2023, 1, 2, 10, 0));
        Screening screening3 = new Screening("Hair", "room1", LocalDateTime.of(2023, 1, 2, 10, 30));


        MovieApplication movieApplication = new MovieApplication(roomList, movieList);
        movieApplication.addScreening()

    }

}