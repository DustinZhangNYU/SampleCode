package com.example.demo.Reservation;

import com.example.demo.Store.Store;
import com.example.demo.Store.StoreRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{
    List<Reservation> findByStore_Id(long store_id);
    List<Reservation> findByCustomer_Id(Long customer_id);
}
