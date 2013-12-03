package com.springapp.domain;

import java.util.Date;

public class Reservation {
    private String courtName;
    private Date data;
    private int hour;
    private Player player;
    private SportType sportType;

    public Reservation(String courtName, Date data, int hour, Player player, SportType sportType) {
        this.courtName = courtName;
        this.data = data;
        this.hour = hour;
        this.player = player;
        this.sportType = sportType;
    }

    public String getCourtName() {
        return courtName;
    }

    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public SportType getSportType() {
        return sportType;
    }

    public void setSportType(SportType sportType) {
        this.sportType = sportType;
    }
}
