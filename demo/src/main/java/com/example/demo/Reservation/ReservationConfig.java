package com.example.demo.Reservation;

import com.example.demo.Store.Store;
import com.example.demo.Store.StoreRepository;
import com.example.demo.Users.Users;
import com.example.demo.Users.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
@Configuration
public class ReservationConfig {
    @Bean
    CommandLineRunner reservationCmd(ReservationRepository reservationRepo, UsersRepository userRepo, StoreRepository storeRepo) {
        return args -> {
            Users test = new Users(
                    "Test",
                    "Test",
                    "test@gmail.com",
                    'c',
                    "abc1234",
                    "US",
                    "Brooklyn",
                    "NY",
                    "277 Gold",
                    "",
                    "11201",
                    LocalDate.of(1998, Month.JULY,9)


            );
            Users atomixManager = new Users(
                    "Lip",
                    "Gal",
                    "atomix@atomix.com",
                    'e',
                    "abc1234",
                    "US",
                    "Brooklyn",
                    "NY",
                    "277 Gold",
                    "",
                    "11201",
                    LocalDate.of(1998, Month.JULY,9));
            Users jejuManager = new Users(
                    "Steve",
                    "Paul",
                    "jeju@jeju.com",
                    'e',
                    "abc1234",
                    "US",
                    "Brooklyn",
                    "NY",
                    "277 Gold",
                    "",
                    "11201",
                    LocalDate.of(1998, Month.JULY,9));
            Users pandaManager = new Users(
                    "Panda",
                    "Hong",
                    "panda@panda.com",
                    'e',
                    "abc1234",
                    "US",
                    "Brooklyn",
                    "NY",
                    "277 Gold",
                    "",
                    "11201",
                    LocalDate.of(1998, Month.JULY,9));
            userRepo.saveAll(List.of(test, jejuManager,pandaManager,atomixManager));
            Store jeju = new Store(
                    "Jeju Noodle Bar",
                    "USA",
                    "new york",
                    "NY",
                    "15 34th S",
                    "257",
                    "14011"

            );
            jeju.setManager(jejuManager);
            Store atomix = new Store(
                    "Atomix",
                    "USA",
                    "new york",
                    "NY",
                    "16 24th S",
                    "277",
                    "14038"

            );
            atomix.setManager(atomixManager);
            Store pandaExpress = new Store(
                    "PandaExpress",
                    "USA",
                    "new york",
                    "NY",
                    "16 244th S",
                    "277",
                    "14038"

            );
            pandaExpress.setManager(pandaManager);
            storeRepo.saveAll(List.of(jeju, atomix,pandaExpress));
            Reservation res1 = new Reservation(
                    LocalDateTime.of(2022, 12, 16, 17, 00),
                    LocalDateTime.of(2022, 12, 16, 19, 00),
                    "Booked"
            );
            res1.setCustomer(test);
            res1.setStore(jeju);

            Reservation res2 = new Reservation(
                    LocalDateTime.of(2022, 12, 16, 20, 00),
                    LocalDateTime.of(2022, 12, 16, 22, 00),
                    "Available"
            );
            res2.setStore(jeju);
            Reservation res3 = new Reservation(
                    LocalDateTime.of(2022, 12, 18, 17, 00),
                    LocalDateTime.of(2022, 12, 18, 19, 00),
                    "Available"
            );
            res3.setStore(atomix);

            Reservation res4 = new Reservation(
                    LocalDateTime.of(2022, 12, 21, 20, 00),
                    LocalDateTime.of(2022, 12, 21, 22, 00),
                    "Booked"
            );
            res4.setCustomer(atomixManager);
            res4.setStore(jeju);

            Reservation res5 = new Reservation(
                    LocalDateTime.of(2022, 12, 22,19, 00),
                    LocalDateTime.of(2022, 12, 22, 22, 00),
                    "Available"
            );
            res5.setCustomer(test);
            res5.setStore(pandaExpress);
            reservationRepo.saveAll(List.of(res1,res2,res3,res4,res5));
        };

    }
}
