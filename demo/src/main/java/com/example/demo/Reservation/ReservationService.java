package com.example.demo.Reservation;

import com.example.demo.Users.Users;
import com.example.demo.Users.UsersService;
import com.example.demo.Store.StoreService;
import com.example.demo.Store.Store;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final StoreService storeService;
    private final UsersService usersService;
    @Autowired
    public ReservationService(ReservationRepository reservationRepository,
                              StoreService storeService,
                              UsersService usersService) {
        this.reservationRepository = reservationRepository;
        this.storeService = storeService;
        this.usersService = usersService;
    }
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }
    public List<Reservation> getReservationByStoreId(Long id) {
        return reservationRepository.findByStore_Id(id);
    }
    public List<Reservation> getReservationByUserId(Long id) {
        return reservationRepository.findByCustomer_Id(id);
    }
    public Reservation createReservation(LocalDateTime start, LocalDateTime end, Long store_id) {
        Store store = storeService.getStoreById(store_id);
        if(store == null) {
            return null;
        }
        Reservation reservation = new Reservation(start,end,"available");
        reservation.setStore(store);
        reservationRepository.save(reservation);
        return reservation;
    }

    public HashMap<String, String> bookReservation(Long userId, Long rerservationId) {
        HashMap<String, String> response = new HashMap<>();
        Users user = usersService.getUserById(userId);
        if(user == null) {
            response.put("status", "failed");
            response.put( "message", "UserNotFound");
            return response;
        }
        Reservation reservation = reservationRepository.findById(rerservationId).get();
        if(reservation == null) {
            response.put("status", "failed");
            response.put( "message", "ReservationNotFound");
            return response;
        }
        if(reservation.getStatus().equals("booked")){
            response.put("status", "failed");
            response.put( "message", "ReservationIsBooked");
            return response;
        }
        reservation.setCustomer(user);
        reservation.setStatus("booked");
        reservationRepository.save(reservation);
        response.put("status", "Good");
        response.put( "message", "OK");
        return response;
    }
}
