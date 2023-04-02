package org.example;


import java.util.List;

public class Room {
    private String roomName;
    private int capacity;
    private List<Movie> movieList;


    public Room(String roomName, int capacity, List<Movie> movieList) {
        this.roomName = roomName;
        this.capacity = capacity;
        this.movieList = List.copyOf(movieList);
        //beleteszi a movieList-et egy új memóriacímbe, így mikor a movieList módosul, akkor az osztályváltozó nem fog vele.
    }
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
}
