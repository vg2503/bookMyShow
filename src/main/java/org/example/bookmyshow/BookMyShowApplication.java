package org.example.bookmyshow;

import org.example.bookmyshow.controllers.BookingController;
import org.example.bookmyshow.services.BookingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookMyShowApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowApplication.class, args);
        //BookingController controller = new BookingController(new BookingService());

        //controller.createTicket()
    }

}
