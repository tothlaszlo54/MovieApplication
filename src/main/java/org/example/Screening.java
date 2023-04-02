package org.example;

import java.time.LocalDateTime;

public class Screening {
    private String movieTitle;
    private String roomName;
    private LocalDateTime startTime;

    public Screening(String movieTitle, String roomName, LocalDateTime startTime) {
        this.movieTitle = movieTitle;
        this.roomName = roomName;
        this.startTime = startTime;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }
    public String getMovieTitle(){
        return movieTitle;
    }

    public void setStartTime(LocalDateTime startTime){
        this.startTime=startTime;
    }

    public LocalDateTime getStartTime(){
        return startTime;
    }
}
