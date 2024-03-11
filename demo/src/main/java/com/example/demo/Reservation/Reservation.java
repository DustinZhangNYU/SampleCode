package com.example.demo.Reservation;

import com.example.demo.Users.Users;
import com.example.demo.Store.Store;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Reservation {
    @Id
    @SequenceGenerator(
            name = "reservation_sequence",
            sequenceName = "reservation_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "reservation_sequence"
    )
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Users customer;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;
    private String status;
    public Reservation() {

    }
    public Reservation(Long id,
                       LocalDateTime startTime,
                       LocalDateTime endTime,
                       String status) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }
    public Reservation(LocalDateTime startTime,
                       LocalDateTime endTime,
                       String status) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Users getCustomer() {
        return customer;
    }

    public void setCustomer(Users customer) {
        this.customer = customer;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", customer=" + customer +
                ", store=" + store +
                ", status='" + status + '\'' +
                '}';
    }
}
