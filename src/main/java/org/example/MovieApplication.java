package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MovieApplication {

    private List<Screening> screeningList;

    private List<Room> roomList;

    private List<Movie> movieList;


    public MovieApplication() {
        screeningList = new ArrayList<>();
        roomList = new ArrayList<>();
        movieList = new ArrayList<>();
    }

    public MovieApplication(List<Room> roomList, List<Movie> movieList) {
        this.roomList = List.copyOf(roomList);
        this.movieList = List.copyOf(movieList);
        screeningList = new ArrayList<>();
    }


    public List<Screening> getScreeningList() {
        return screeningList;
    }

    private LocalDateTime getEndtimeOfScreening(Screening screening, int breakTimeInMinutes) {
        int movieLength = 0;
        for (Movie actualMovie : movieList) {

            if (screening.getMovieTitle().equals(actualMovie.getTitle())) {
                movieLength = actualMovie.getLength();

            }

        }

        LocalDateTime endTime = screening.getStartTime().plusMinutes(movieLength).plusMinutes(breakTimeInMinutes);
        return endTime;

    }

    private void checkIfMovieExist(Screening screening) {
        boolean movieFound = false;

        for (Movie actualMovie : movieList) {

            if (screening.getMovieTitle().equals(actualMovie.getTitle())) {
                movieFound = true;
                break;
            }
        }
        if (!movieFound) {
            throw new IllegalArgumentException("not find movie in the movieList");
        }
    }

    private void checkIfRoomExist(Screening screening) {
        boolean roomFound = false;

        for (Room actualRoom : roomList) {
            if (screening.getRoomName().equals(actualRoom.getRoomName())) {
                roomFound = true;
                break;
            }
        }
        if (!roomFound) {
            throw new IllegalArgumentException("Nincs ilyen nevű terem");
        }
    }


    private void checkIfScreeningOverlapping(Screening screening, int breakTimeInMinutes) {
        for (Screening actualScreening : screeningList) {

            if (actualScreening.getRoomName().equals(screening.getRoomName())) {

                if (actualScreening.getStartTime().isBefore(screening.getStartTime()) && getEndtimeOfScreening(actualScreening, breakTimeInMinutes).isAfter(screening.getStartTime())) {
                    throw new IllegalArgumentException("idő ütközés");

                } else if (actualScreening.getStartTime().isBefore(getEndtimeOfScreening(screening, breakTimeInMinutes)) && getEndtimeOfScreening(actualScreening, breakTimeInMinutes).isAfter(getEndtimeOfScreening(screening, breakTimeInMinutes))) {
                    throw new IllegalArgumentException("idő ütközés");
                } else if (actualScreening.getStartTime().isBefore(screening.getStartTime()) && getEndtimeOfScreening(actualScreening, breakTimeInMinutes).isAfter(getEndtimeOfScreening(screening, breakTimeInMinutes))) {
                    throw new IllegalArgumentException("idő ütközés");
                } else if (actualScreening.getStartTime().isAfter(screening.getStartTime()) && getEndtimeOfScreening(actualScreening, breakTimeInMinutes).isBefore(getEndtimeOfScreening(screening, breakTimeInMinutes))) {
                    throw new IllegalArgumentException("idő ütközés");
                }
            }

        }
    }

    public Screening addScreening(Screening screening) {


        checkIfMovieExist(screening);
        checkIfRoomExist(screening);

        checkIfScreeningOverlapping(screening, 15);

        screeningList.add(screening);


        return screening;

    }
}
