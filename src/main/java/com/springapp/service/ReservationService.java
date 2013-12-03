package com.springapp.service;

import com.springapp.domain.Reservation;

import java.util.List;

public interface ReservationService {
    public List<Reservation> query(String courtName);


}
