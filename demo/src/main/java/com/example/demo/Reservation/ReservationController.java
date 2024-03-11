package com.example.demo.Reservation;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path = "/reservation")
public class ReservationController {
    private final ReservationService reservationService;
    @Autowired
    public ReservationController(ReservationService reservationService) {this.reservationService = reservationService;}
    @GetMapping(path = "/getAllReservations")
    public List<Reservation> getAllReservations(){return reservationService.getAllReservation();}
    @GetMapping(path = "/getReservationByStoreId")
    public List<Reservation> getReservationByStoreId(@RequestParam Long id) {return reservationService.getReservationByStoreId(id);}
    @GetMapping(path = "/getReservationByUserId")
    public List<Reservation> getReservationByUserId(@RequestParam Long id) {return reservationService.getReservationByUserId(id);}
    @PostMapping(path = "/createReservation")
    public ResponseEntity<Reservation> createReservation(@RequestBody ObjectNode json){
        String str1 = json.get("startTime").asText();
        LocalDateTime startTime = LocalDateTime.parse(str1);
        String str2 = json.get("endTime").asText();
        LocalDateTime endTime;
        if(str2.equals("null")) {
            endTime = null;
        }
        else{
            endTime = LocalDateTime.parse(str2);
        }
        Long storeId = json.get("store_id").asLong();
        Reservation reservation = reservationService.createReservation(startTime, endTime, storeId);
        if(reservation == null) {
            return ResponseEntity.notFound().build();
        }
        else{
            return ResponseEntity.ok(reservation);
        }

    }
    @PutMapping (path = "/bookReservation")
    public ResponseEntity<String> makeReservation(@RequestBody ObjectNode json)
    {
        Long userId = json.get("userId").asLong();
        Long reservationId = json.get("reservationId").asLong();
        HashMap<String, String> map = reservationService.bookReservation(userId, reservationId);
        if(map.get("status") == "OK"){
            return ResponseEntity.ok("OK");
        }
        else{
            return new ResponseEntity<>(map.get("message"), HttpStatus.NOT_FOUND);
        }
    }
}
