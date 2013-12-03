package com.springapp.service;

import com.springapp.domain.Player;
import com.springapp.domain.Reservation;
import com.springapp.domain.SportType;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class ReservationServiceImp implements ReservationService{

    private List<Reservation> reservations;

    public ReservationServiceImp() {
        reservations = new ArrayList<Reservation>();
        reservations.add(new Reservation("Tennis #1",new GregorianCalendar(2008,0,14).getTime(),16,new Player("Roger","N/A"),new SportType(1,"Tennis")));
        reservations.add(new Reservation("Tennis #2",new GregorianCalendar(2008,0,14).getTime(),20,new Player("James","N/A"),new SportType(2,"soccer")));
    }

    @Override
    public List<Reservation> query(String courtName) {
        ArrayList<Reservation> results = new ArrayList<Reservation>();
        for(Reservation reservation : reservations){
            if(reservation.getCourtName().equals(courtName)){
                results.add(reservation);
            }
        }
        return results;
    }
}
